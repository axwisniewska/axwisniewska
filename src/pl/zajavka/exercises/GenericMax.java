package pl.zajavka.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GenericMax {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(4, 2, 12, 4, 11, 6, 7, 3, 5, 9);
        List<Long> longs = Arrays.asList(4L, 2L, 12L, 4L, 11L, 6L, 7L, 3L, 5L, 9L);
        List<Float> floats = Arrays.asList(4.0F, 2.0F, 12.0F, 4.0F, 11.0F, 6.0F, 7.0F, 3.0F, 5.0F, 9.0F);
        List<Double> doubles = Arrays.asList(4.0, 2.0, 12.0, 4.0, 11.0, 6.0, 7.0, 3.0, 5.0, 9.0);

        System.out.println(maximum(ints, -3, 14).orElse(null));
        System.out.println(maximum(ints, 3, 8).orElse(null));
        System.out.println(maximum(ints, 0, 9).orElse(null));
        System.out.println(maximum(doubles, 0.0, 9.0).orElse(null));
        System.out.println(maximum(floats, 2.0F, 9.0F).orElse(null));
        System.out.println(maximum(longs, 0L, 9L).orElse(null));

    }

    public static <T extends Number>Optional<T> maximum(List<T> list, T min, T max){
        T tempMaxValue = null;

        for (T el : list) {
            if(el.doubleValue() >= min.doubleValue() && el.doubleValue() < max.doubleValue()){
                if (Objects.isNull(tempMaxValue) || el.doubleValue() > tempMaxValue.doubleValue()){
                    tempMaxValue = el;
                }
            }
        }
        return Optional.ofNullable(tempMaxValue);
    }
}
