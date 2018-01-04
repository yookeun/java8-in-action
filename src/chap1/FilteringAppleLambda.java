package chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by yookeun on 2017. 12. 22..
 */
public class FilteringAppleLambda {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(
                new Apple(100, "green"),
                new Apple(150, "red"),
                new Apple(200, "blue")

        );

        final int port = 111;
        Runnable r = () -> System.out.println(port);
        r.run();


        List<Apple> redApples = filterApple(appleList, (Apple apple) -> "red".equals(apple.getColor()));
        for (Apple apple : redApples) {
            System.out.println(apple.toString());
        }

        List<Apple> weightApple = filterApple(appleList, (Apple apple) -> 150 <= apple.getWeight());
        for (Apple apple : weightApple) {
            System.out.println(apple.toString());
        }

        List<Apple> greenApples4 = filterApple(appleList, (apple) -> "green".equals(apple.getColor()));
        for (Apple apple: greenApples4) {
            System.out.println("green4: "+ apple.toString());
        }
    }


//    public static List<Apple> filerApple(List<Apple> apples, ApplePredicate p) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : apples) {
//            if (p.test(apple)) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }


    public static <T> List<T> filterApple(List<T> lists, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : lists) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
