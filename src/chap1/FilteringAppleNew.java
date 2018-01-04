package chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yookeun on 2017. 12. 22..
 */
public class FilteringAppleNew {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(
                new Apple(100, "green"),
                new Apple(150, "green"),
                new Apple(200, "blue")
        );

        //익명클래스로 처리해보자
        List<Apple> colorApples = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "blue".equals(apple.getColor());
            }
        });

        for (Apple apple : colorApples) {
            System.out.println(apple.toString());
        }

        //그런데 여전히 라인수가 많다...
        List<Apple> weightApples = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return 150 <= apple.getWeight();
            }
        });

        for (Apple apple : weightApples) {
            System.out.println(apple.toString());
        }
    }


    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
