package chap3;

import chap1.Apple;

import java.util.Comparator;

/**
 * Created by yookeun on 2017. 12. 24..
 */
public class AppleComparator implements Comparator<Apple> {
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
