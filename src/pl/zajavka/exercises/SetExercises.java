package pl.zajavka.exercises;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExercises {
    public static void main(String[] args) {
        List<Car> myCars = List.of(
                new Car("Audi", "80", 1989),
                new Car("Ford", "Mustang", 1969),
                new Car("Cadillac", "Eldorado", 1959),
                new Car("Ferrari", "Enzo", 2006),
                new Car("Chevy", "Bel Air", 1955),
                new Car("Mercedes", "Benz 300sl", 1955)
        );
        List<Car> hisCars = List.of(
                new Car("Audi", "80", 1989),
                new Car("Aston Martin", "DB9", 2006),
                new Car("Mercedes", "Benz 300sl", 1955),
                new Car("Dodge", "Charger", 1969),
                new Car("Cadillac", "Eldorado", 1959),
                new Car("Delorean", "DMC 12", 1981),
                new Car("Ford", "GT40", 1968),
                new Car("Mercedes", "Benz 300sl", 1955),
                new Car("Ford", "Mustang", 1969),
                new Car("Ferrari", "F430", 2006)
        );
        Set<Car> mixed = new TreeSet<>();
        mixed.addAll(myCars);
        mixed.addAll(hisCars);
        for (Car car : mixed) {
            System.out.println(car);
        }
    }

    private static class Car implements Comparable<Car> {
        private final String brand;
        private final String model;
        private final Integer year;

        public Car(final String brand, final String model, final Integer year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public Integer getYear() {
            return year;
        }

        @Override
        public int compareTo(final Car o) {
            return Comparator.comparingInt((Car car) -> car.year)
                    .thenComparing((Car car) -> car.brand)
                    .thenComparing((Car car) -> car.model)
                    .compare(this, o);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", year=" + year +
                    '}';
        }
    }
}