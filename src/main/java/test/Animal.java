package test;

import test.dto.Food;

public interface Animal {
    void voice();

    boolean eat(Food food);

    boolean isAngry();

    void hungry (); //метод делает животное голодным

    boolean typeEat(Food food);//метод проверяет подходит ли тип еды животному

    String inheritorClassName();// возвращает имя класса наследника
}
