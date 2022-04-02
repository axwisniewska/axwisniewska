package pl.zajavka.exercises;

import java.util.Arrays;
import java.util.List;

public class GenericStaticMethodMax {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(4, 2, 12, 4, 11, 6, 7, 3, 5, 9);
        List<Long> longs = Arrays.asList(4L, 2L, 12L, 4L, 11L, 6L, 7L, 3L, 5L, 9L);
        List<Float> floats = Arrays.asList(4.0F, 2.0F, 12.0F, 4.0F, 11.0F, 6.0F, 7.0F, 3.0F, 5.0F, 9.0F);
        List<Double> doubles = Arrays.asList(4.0, 2.0, 12.0, 4.0, 11.0, 6.0, 7.0, 3.0, 5.0, 9.0);

        System.out.println(max(3, 8, ints));
        System.out.println(max(1, 3, ints));
        System.out.println(max(4, 6, ints));
        System.out.println(max(2L, 12L, longs));
        System.out.println(max(2.0F, 14F, floats));
        System.out.println(max(2.0, 7.1, doubles));
        System.out.println(max(2.8, 3.2, doubles));

    }

    public static <T extends Number> T max(T start, T end, List<T> list){
        T max = null;
        for (T element : list) {
            if(element.doubleValue() >= start.doubleValue() && element.doubleValue() < end.doubleValue()){
                if(max == null || element.doubleValue() > max.doubleValue()){
                    max = element;
                }
            }
        }
        return max;
    }

    public static <T extends Number & Comparable<T>> T maxWithCompareTo(T start, T end, List<T> list){
        T max = null;
        for (T element : list) {
            if(element.compareTo(start) >= 0 && element.compareTo(end) < 0){
                if(max == null || element.compareTo(max) > 0){
                    max = element;
                }
            }
        }
        return max;
    }
}
