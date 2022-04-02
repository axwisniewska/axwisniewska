package pl.zajavka.exercises;

import java.util.*;

public class ExampleClassComparator {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "A", "1", "aA", "Aa", "A1", "a1");
        System.out.println(strings);
        Comparator<String> comparator = Comparator.<String>naturalOrder().reversed();
        strings.sort(comparator);
        System.out.println(strings);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, "Roman"));
        cats.add(new Cat(6, "Zbyszek"));
        cats.add(new Cat(3, "Rafał"));
        cats.add(new Cat(2, "Stefan"));
        cats.add(new Cat(5, "Roman"));
        cats.add(new Cat(4, "Roman"));
        System.out.println();


        Comparator<Cat> myFirstComparator;
        myFirstComparator = Comparator.<Cat, String>comparing(cat1 -> cat1.getName())
                .thenComparingInt(cat -> cat.getId());

        cats.sort(myFirstComparator);
        System.out.println(cats);
    }
}
