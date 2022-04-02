package pl.zajavka.exercises;

import java.util.Arrays;

public class GenericElementSwitch {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog(1),new Dog(2),new Dog(3),new Dog(4), new Dog(5)};
        Cat[] cats = {new Cat(1),new Cat(2),new Cat(3),new Cat(4), new Cat(5)};

        System.out.println(Arrays.toString(dogs));
        swap(dogs, 3, 5);
        System.out.println(Arrays.toString(dogs));

        System.out.println();

        System.out.println(Arrays.toString(cats));
        swap(cats, 2, 1);
        System.out.println(Arrays.toString(cats));

    }

    public static <T> void swap(T[] array, int position1, int position2){
        if(position1 >= array.length){
            System.out.println("Position " + position1 + "is too big");
            return;
        }
        if(position2 >= array.length){
            System.out.println("Position " + position2 + "is too big");
            return;
        }
        System.out.println("Swapping index: " + array[position1] + " with index: " + array[position2]);

        T temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;

    }

    static class Cat{
        private final int id;

        public Cat(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Cat: " + + id;
        }
    }

    static class Dog{
        private final int id;

        public Dog(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Dog: " + + id;
        }
    }
}
