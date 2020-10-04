package test.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.dto.Food;
import test.service.FoodContainer;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@EnableScheduling
public class AddFoodToContainer {
    public FoodContainer foodContainer;

    public AddFoodToContainer(FoodContainer foodContainer) {
        this.foodContainer = foodContainer;
    }
 //   public AddFoodToContainer() {
 //   }

    @Scheduled(fixedDelay = 1000)
    public void addFood() {
        Food food1 = new Food();
        food1.setExpirationDate(LocalDateTime.now().plusHours(6));
        food1.setFoodType(Food.FoodType.values()[new Random().nextInt(Food.FoodType.values().length)]);
        food1.setFoodName("name");
        foodContainer.addFoodList(food1);

        System.out.println("Add......");
    }

}
