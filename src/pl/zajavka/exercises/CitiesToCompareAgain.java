package pl.zajavka.exercises;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CitiesToCompareAgain implements Comparable<CitiesToCompareAgain>, Comparator<CitiesToCompareAgain> {
    private final String someText;
    private final Integer someNumber;


    public CitiesToCompareAgain(final String someText, final int someNumber) {
        this.someText = someText;
        this.someNumber = someNumber;
    }

    @Override
    public String toString() {
        return someNumber.toString();
    }

    public int compareTo(CitiesToCompareAgain element) {
        return element.someNumber - someNumber;
    }

    public int compare(CitiesToCompareAgain element1, CitiesToCompareAgain element2) {
        return element1.someText.compareTo(element2.someText);
    }

    public static void main(String[] args) {
        CitiesToCompareAgain element1 = new CitiesToCompareAgain("Text1", 2);
        CitiesToCompareAgain element2 = new CitiesToCompareAgain("Text2", 3);
        CitiesToCompareAgain element3 = new CitiesToCompareAgain("Text3", 1);
        List<CitiesToCompareAgain> list = new ArrayList<>();
        list.add(element1);
        list.add(element2);
        list.add(element3);
        Collections.sort(list);
        System.out.println(list);
    }
}