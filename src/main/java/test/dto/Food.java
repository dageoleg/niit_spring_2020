package test.dto;

import java.time.LocalDateTime;
import java.util.Random;

public class Food {
    private String foodName;
    private LocalDateTime expirationDate;
    private FoodType foodType;

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public enum FoodType {FOOD_DOGS,FOOD_CATS,FOOD_FISHES}
}
