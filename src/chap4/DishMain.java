package chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yookeun on 2018. 1. 4..
 */
public class DishMain {
    public static void main(String[] args) {
        //show8();
        //showThreeMenu();
        showThreeMenu2();
        //outterRepeat(Dish.menu);
        //System.out.println("-------------");
        //innerRepeat(Dish.menu);
    }

    public static void show8() {
        List<String> names = Arrays.asList("Java8", "NodeJS", "Python", "Elastic");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);  //탐색된 스트림은 소비된다.
        s.forEach(System.out::println);  //이미 위에서 소비되었기 때문에 에러 발생
    }

    public static void showThreeMenu() {
        List<Dish> menus = Dish.menu;
        List<String> names = menus.stream().filter(dish -> dish.getCalories()>300).map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(names);
    }

    public static void showThreeMenu2() {
        List<Dish> menus = Dish.menu;
        List<String> names = menus.stream().filter(dish -> {
            System.out.println("filtering " + dish.getName());
            return dish.getCalories() > 300;
        }).map( dish -> {
            System.out.println("mapping " + dish.getName());
            return dish.getName();
        }).limit(3).collect(Collectors.toList());
    }

    /**
     * 컬렉션에서 외부 반복
     * @param menus
     */
    public static void outterRepeat(List<Dish> menus) {
        List<String> names = new ArrayList<>();
        for (Dish dish : menus) {
            names.add(dish.getName());
        }
        for (String name: names) {
            System.out.println(name);
        }
    }

    public static void innerRepeat(List<Dish> menus) {
        List<String> names = menus.stream().map(Dish::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}
