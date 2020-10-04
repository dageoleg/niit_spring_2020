package test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import test.dto.Food;

@Component
public class Cat implements Animal {
    private boolean angry = true;

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
    @Scheduled(fixedDelay = 3000)
    public void hungry() {
        if(angry=true) voice();
    }
}
