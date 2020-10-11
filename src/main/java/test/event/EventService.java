package test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import test.Animal;
import test.Zoo;
import test.dto.Food;
import test.dto.FoodContainer;

import java.time.LocalDateTime;

@Service
public class EventService {
    @Autowired
    Zoo zoo;
    @Autowired
    FoodContainer foodContainer;

    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        for (Animal animal : zoo.getAnimals()) {
            if (animal.inheritorClassName()==zooEvent.getMessage()) {
                System.out.println(zooEvent.getMessage() + " is hungry");
                for (Food food : foodContainer.getFoodList()) {
                    if (animal.typeEat(food) && LocalDateTime.now().isBefore(food.getExpirationDate())) {
                        animal.eat(food);
                        foodContainer.getFoodList().remove(food);
                        break;
                    }
                }
                if (animal.isAngry()){
                    System.out.println("The container is missing the correct type of food. "+zooEvent.getMessage()
                            +" remained hungry.");
                }
            }
        }

    }

}
