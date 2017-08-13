package chap2;

import chap1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yookeun on 2017. 8. 13..
 */
public class FilteringApple2 {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(100, "red"),
                new Apple(150,"green"),
                new Apple(200, "blue")
        );

        List<Apple> greenApples = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        for (Apple apple: greenApples) {
            System.out.println("green apple = " + apple.toString());
        }

        List<Apple> weightApples = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        for (Apple apple: weightApples) {
            System.out.println("weight apple = " + apple.toString());
        }

        //익명클래스를 이용하는 방법
        List<Apple> redApples1 = filterApples(inventory, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        for (Apple apple: redApples1) {
            System.out.println("red apple1 = " + apple.toString());
        }

        //람다식 처리
        List<Apple> redApples2 = filterApples(inventory, (Apple a) -> "red".equals(a.getColor()));
        for (Apple apple: redApples2) {
            System.out.println("red apple2 = " + apple.toString());
        }

    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {  //제시한 조건에 맞는가?
                result.add(apple);
            }
        }
        return result;
    }
}
