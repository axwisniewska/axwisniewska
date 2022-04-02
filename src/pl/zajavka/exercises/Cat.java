package pl.zajavka.exercises;

public class Cat {

    private Integer id;

    private String name;

    public Cat(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat: " + id + ", " + name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
