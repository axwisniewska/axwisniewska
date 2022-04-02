package pl.zajavka.project;

import java.util.Comparator;

public class TryHardComparator<T extends Comparable<T>> implements Comparator<T> {
    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}