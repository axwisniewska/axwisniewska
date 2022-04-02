package pl.zajavka.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleClassComparable {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Mirek"));
        dogs.add(new Dog("Marek"));
        dogs.add(new Dog("Maniek"));
        dogs.add(new Dog("Roman"));
        dogs.add(new Dog("Stefan"));
        dogs.add(new Dog("Fafik"));
        dogs.add(new Dog("Burek"));

        System.out.println();
        Collections.sort(dogs);
        System.out.println();
    }
}
