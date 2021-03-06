import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.configuration.AnnotationConfiguration;

public class Main {
//    public static void main(String[] args) {
//        Zoo zoo = new Zoo(new Dog(), new Cat());
//        zoo.getCat().voice();
//        zoo.getDog().voice();
//    }

    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
//        feedAnimal(context);
    }

//    public static void feedAnimal(ApplicationContext context) {
//        ZooService service = context.getBean(ZooService.class);
//        Food food = new Food();
//        food.setFoodName("fish");
//        food.setExpirationDate(LocalDateTime.now().plusHours(6));
//        food.setFoodType(Food.FoodType.FOOD_FOR_FISHES);
//        service.feed(food);
//    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }
}
