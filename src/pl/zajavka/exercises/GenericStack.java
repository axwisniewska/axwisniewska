package pl.zajavka.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericStack {

    public static void main(String[] args) {
        Stack<StackElement> stackGeneric = new Stack<>();
        stackGeneric.add(new Book());
        stackGeneric.add(new Newspaper());
        stackGeneric.add(new Newspaper());
        stackGeneric.add(new Book());
        stackGeneric.add(new Smartphone());
        System.out.println(stackGeneric);

        stackGeneric.get();
        stackGeneric.get();
        stackGeneric.get();
        System.out.println(stackGeneric);

    }

    interface StackElement{

    }

    static class Book implements StackElement{
        @Override
        public String toString(){
            return "Book";
        }
    }
    static class Smartphone implements StackElement{
        @Override
        public String toString(){
            return "Smartphone";
        }
    }
    static class Newspaper implements StackElement{
        @Override
        public String toString(){
            return "Newspaper";
        }
    }
    static class Stack<T extends StackElement>{

        private final List<T> elements = new ArrayList<>();

        public void add(T element){
            elements.add(element);
        }
        public Optional<T> get(){
            int size = elements.size();
            if (size > 0) {
                return Optional.ofNullable(elements.remove(size - 1));
            }
            return Optional.empty();
        }

        @Override
        public String toString() {
            return elements.toString();
        }
    }
}
