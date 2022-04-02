package pl.zajavka.exercises;

public class GenericsElementSwap {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Mirek");
        Cat cat2 = new Cat("Marek");
        Cat cat3 = new Cat("Murek");

        Cat[] catsArray = {cat1, cat2, cat3};

        System.out.println(catsArray);
        swap(catsArray, 1, 3);
        System.out.println(catsArray);
    }

    public static <T extends Animal> boolean swap(T[] array, int indexStart, int indexEnd){
        if(indexStart == indexEnd
        || indexStart <0
        || indexEnd <0
        || indexStart >= array.length
        || indexEnd >= array.length
        ){
            return false;
        }
        T temp = array[indexStart];
        array[indexStart] = array[indexEnd];
        array[indexEnd] = temp;

        return true;

    }

    public static class Cat extends Animal{
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat: " + name;
        }
    }
    public static class Animal{

    }


}
