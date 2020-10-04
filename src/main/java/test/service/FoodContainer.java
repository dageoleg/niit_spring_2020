package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import test.dto.Food;

@Service
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

    public void addFoodList(Food food){
        foodList.add(food);
    }


}
