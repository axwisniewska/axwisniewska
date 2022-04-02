package pl.zajavka.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericStackOfThings {
    public static void main(String[] args) {

        Stack<ItemOnTable> stack = new Stack<>();

        stack.put(new Book());
        stack.put(new Book());
        stack.put(new Newspaper());
        stack.put(new Smartphone());
        System.out.println(stack);
        System.out.println(stack.take().orElse(null));
        System.out.println(stack);
        System.out.println(stack.take().orElse(null ));
        System.out.println(stack);

    }
    public static class Stack<T extends ItemOnTable>{
        private List<T> stack = new ArrayList<>();

        public void put(T element){
            if (element == null){
                return;
            }
            stack.add(element);
        }
        public Optional<T> take(){
            if(stack.size() == 0){
                return Optional.empty();
            }

            return Optional.ofNullable(stack.remove(stack.size() - 1));
        }

        @Override
        public String toString() {
            return stack.toString();
        }
    }

    public static class Book implements ItemOnTable{
        @Override
        public String toString() {
            return "Book{}";
        }
    }
    public static class Smartphone implements ItemOnTable{
        @Override
        public String toString() {
            return "Smartphone{}";
        }
    }
    public static class Newspaper implements ItemOnTable{
        @Override
        public String toString() {
            return "Newspaper{}";
        }
    }
    public interface ItemOnTable{

    }
}
