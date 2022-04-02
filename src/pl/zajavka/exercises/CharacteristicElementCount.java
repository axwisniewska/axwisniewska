package pl.zajavka.exercises;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class CharacteristicElementCount {
    public static void main(String[] args) {
        Set<Long> longs = new HashSet<>(Arrays.asList(1L,2L,3L,4L,5L,6L,7L));
        System.out.println(countIf(longs, element -> element % 2 !=0));
    }
    public static <T> int countIf(Collection<T> collection, Predicate<T> predicate){
        int counter = 0;
        for (T elem : collection) {
            if(predicate.test(elem)){
                counter++;
            }
        }
        return counter;
    }
}
