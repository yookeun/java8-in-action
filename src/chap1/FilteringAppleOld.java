package chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yookeun on 2017. 12. 22..
 */
public class FilteringAppleOld {

    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(
                new Apple(100, "green"),
                new Apple(150, "green"),
                new Apple(200, "blue")
        );
/*

        List<Apple> greenApples = filterGreenApples(appleList, "green");
        for (Apple apple : greenApples) {
            System.out.println(apple.getColor() + ", " + apple.getWeight());
        }

        List<Apple> weightApples = filterWeightApples(appleList, 130);
        for (Apple apple : weightApples) {
            System.out.println(apple.getColor() + ", " + apple.getWeight());
        }
*/


        //명확하지 않은 메소드
        /*
        List<Apple> apples = filterApplesOld(appleList, "green", 0, true);
        for (Apple apple : apples) {
            System.out.println(apple.getColor() + ", " + apple.getWeight());
        }
        List<Apple> apples2 = filterApplesOld(appleList, "", 150, false);
        for (Apple apple : apples2) {
            System.out.println(apple.getColor() + ", " + apple.getWeight());
        }
        */



        List<Apple> colorApples = filterApplesNew(appleList, new AppleColor("green"));
        for (Apple apple : colorApples) {
            System.out.println(apple.getColor() + ", " + apple.getWeight());
        }

        List<Apple> weightApples = filterApplesNew(appleList, new AppleWeight(200));
        for (Apple apple : weightApples) {
            System.out.println(apple.getColor() + ", " + apple.getWeight());
        }
    }



    /*
    요구사항
     */
    public static List<Apple> filterGreenApples(List<Apple> apples, String color) {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                greenApples.add(apple);
            }
        }
        return greenApples;
    }


    /*
    요구사항이 늘었다.
     */
    public static List<Apple> filterWeightApples(List<Apple> apples, int weight) {
        List<Apple> weightApples = new ArrayList<>();
        for (Apple apple : apples) {
            if ( weight <= apple.getWeight()) {
                weightApples.add(apple);
            }
        }
        return weightApples;
    }


    /*
        늘어난 요구사항을 처리하는 형편없는 코드..
     */
    public static List<Apple> filterApplesOld(List<Apple> apples, String color, int weight, boolean flag) {
        List<Apple> appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    //동작파라미터를 처리하기 위헤서는 프레디게이트라는 인터페이스가 필요하다.


    public static List<Apple> filterApplesNew(List<Apple> apples, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {    //프레디게이트 객체로 사과검사를 캡슐화했다. 즉, 호출하는 쪽에서 로직을 던지면 된다.
                result.add(apple);
            }
        }
        return result;
    }


}



/*
클래스를 만들어서 구현하는 방법
 */
class AppleColor implements ApplePredicate {

    private String color;
    AppleColor(String color) {
        this.color = color;
    }

    @Override
    public boolean test(Apple apple) {
        return color.equals(apple.getColor());
    }
}

class AppleWeight implements ApplePredicate {

    private int weight;
    AppleWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean test(Apple apple) {
        return weight <= apple.getWeight();
    }
}

