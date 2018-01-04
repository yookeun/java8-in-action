package chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
            System.out.println("green: "+ apple.toString());
        }

        List<Apple> heavyApples = filterHeavyApples(inventory);

        for (Apple apple: heavyApples) {
            System.out.println("heavy: "+ apple.toString());
        }

        List<Apple> greenApples2 = filterApples(inventory, FilteringApple::isGreenApple);
        for (Apple apple: greenApples2) {
            System.out.println("green2: "+ apple.toString());
        }
        List<Apple> heaveApples2 = filterApples(inventory, FilteringApple::isHeavyApple);
        for (Apple apple: heaveApples2) {
            System.out.println("heavy2: "+ apple.toString());
        }

        List<Apple> greenApples3 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        for (Apple apple: greenApples3) {
            System.out.println("green3: "+ apple.toString());
        }
        List<Apple> heavyApples3 = filterApples(inventory, (Apple a) -> a.getWeight() > 100);
        for (Apple apple: heavyApples3) {
            System.out.println("heavy3: "+ apple.toString());
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

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 100) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 100;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)) { //사과 p가 제시하는 조건이 맞는가?
                result.add(apple);
            }
        }
        return result;

    }


}
