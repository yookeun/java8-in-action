package chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yookeun on 2017. 8. 8..
 */
public class FilteringApple {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(90, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filterGreenApples(inventory);

        for (Apple apple: greenApples) {
            System.out.println(apple.toString());
        }

    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
}
