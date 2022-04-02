package pl.zajavka.project;

import java.util.*;

public class CustomQueue<T> {

    private final Deque<T> queue;
    private final Map<String, Integer> counterMap = new HashMap<>();

    public CustomQueue(Deque<T> queue) {
        this.queue = queue;
    }

    public void add(T item) {
        boolean isAdded = queue.offer(item);
        System.out.printf("%s came to the queue: %s%n", item, isAdded);
        System.out.println(queue);
        System.out.println();

    }

    public Integer getAndIncrementCounter(String key) {
        Integer tempCounter = counterMap.getOrDefault(key, 0);
        counterMap.put(key, ++tempCounter);
//        ALBO
//        tempCounter++;
//        counterMap.put(providedName, tempCounter);
        return tempCounter;
    }

    public void enter() {
       if (queue.isEmpty()) {
           System.out.println("No items in the queue");
           return;
       }
        T arrived = queue.poll();
        System.out.printf("Processing queue: %s arrived at the store%n", arrived);
        System.out.println(queue);
        System.out.println();
    }

    public void delete(T item) {
        if (queue.contains(item)){
            queue.remove(item);
            System.out.printf("Leaving queue: %s%n", item);
            System.out.println(queue);
            System.out.println();
        } else {
            System.out.println(item + " is not in the queue");
        }

    }

    public void addVIP(T item) {
        boolean isAdded = queue.offerFirst(item);

        T[] array = (T[]) queue.toArray();
        Arrays.sort(array, new TryHardComparator());
        queue.clear();
        queue.addAll(Arrays.asList(array));
        System.out.printf("%s came to the queue: %s%n", item, isAdded);
        System.out.println(queue);
        System.out.println();
    }
}

