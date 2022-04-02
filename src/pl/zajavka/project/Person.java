package pl.zajavka.project;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String name;
    private final String surName;
    private final Integer counter;
    private final String id;
    private String vip;

    public Person(String name, String surName, Integer counter) {
        this.name = name;
        this.surName = surName;
        this.counter = counter;
        this.id = generateId();
    }

    public Person(String name, String surName, Integer counter, String vip) {
        this.name = name;
        this.surName = surName;
        this.counter = counter;
        this.vip = vip;
        this.id = generateVIPId();
    }

    public String getId() {
        return id;
    }

    private String generateId() {
        return String.format("%s_%s_%s", this.name, this.surName, this.counter);
    }

    private String generateVIPId() {
        return String.format("%s_%s_%s_%s", this.name, this.surName, this.counter, this.vip);
    }


    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Person o) {
        if(o.id.length() == this.id.length()){
            return 0;
        } else if(o.id.length() < this.id.length()){
            return -1;
        } else {
            return 1;
        }

    }


//    @Override
//    public int compare(Person o) {
//        return this.id.compareTo(o.id);
//    }
}
