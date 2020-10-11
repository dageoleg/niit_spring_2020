package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import test.dto.Food;
import test.event.ZooEvent;

import static test.dto.Food.FoodType.FOOD_FOR_CATS;

@Component
public class Cat implements Animal {
    private boolean angry = true;
    @Autowired
    private ApplicationEventPublisher publisher;

    public void voice() {
        System.out.println("mi");
    }

    @Override
    public boolean eat(Food food) {
        angry = false;
        return isAngry();
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    @Override
    @Scheduled(fixedDelay = 4500)
    public void hungry() {
        angry=true;
        publisher.publishEvent(new ZooEvent(this,inheritorClassName()));
    }

    @Override
    public boolean typeEat(Food food) {
        boolean result;
        result = food.getFoodType() == FOOD_FOR_CATS;
        return result;
    }

    @Override
    public String inheritorClassName() {
        return "Cat";
    }
}
