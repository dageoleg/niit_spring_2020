package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Animal;
import test.Zoo;
import test.dto.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZooServiceImpl implements ZooService {
    private final Zoo zoo;

    @Autowired
    public ZooServiceImpl(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public void feed(Food food) {
        List<Animal> angryAnimals = new ArrayList<>();
        for (Animal animal : zoo.getAnimals()) {
            animal.eat(food);
            if (animal.isAngry()) {
                angryAnimals.add(animal);
            }
        }
        System.out.println(angryAnimals);
    }
}
