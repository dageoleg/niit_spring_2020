package test.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import test.dto.Food;

@Service
@EnableScheduling
public class FoodContainer {
    private List<Food> foodList = new ArrayList<>();

    @Autowired
    public FoodContainer(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Scheduled(fixedDelay = 2000)
    public void addRandomFood() {
        Food food1 = new Food();
        food1.setExpirationDate(LocalDateTime.now().plusHours(6));
        food1.setFoodType(Food.FoodType.values()[new Random().nextInt(Food.FoodType.values().length)]);
        food1.setFoodName("name");
        foodList.add(food1);
        System.out.println("Add food "+food1.getFoodType()+" to container");
    }

    public void addFoodList(Food food){
        foodList.add(food);
        System.out.println("Add......");
    }



}
