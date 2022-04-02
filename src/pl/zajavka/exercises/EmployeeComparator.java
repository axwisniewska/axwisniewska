package pl.zajavka.exercises;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class EmployeeComparator {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Roman", "Pracowniczy", 29, new BigDecimal("2911.2")),
                new Employee("Adam", "Adamski", 27, new BigDecimal("2352.2")),
                new Employee("Stefan", "Programistyczny", 31, new BigDecimal("3512.52")),
                new Employee("Karol", "Bekalski", 21, new BigDecimal("2819.92")),
                new Employee("Adam", "Czeski", 39, new BigDecimal("2819.65")),
                new Employee("Krzysiek", "Fioletowy", 39, new BigDecimal("3819.23")),
                new Employee("Karol", "Lubella", 22, new BigDecimal("2911.2")),
                new Employee("Adam", "Adamski", 27, new BigDecimal("2911.2")),
                new Employee("Adam", "Adamski", 22, new BigDecimal("3542.12")),
                new Employee("Jacek", "Pracowniczy", 23, new BigDecimal("3819.23"))
        );
        print(employees);
        Collections.sort(employees);
        print(employees);
        Comparator<Employee> comparator = Comparator.comparing((Employee e) -> e.name)
                .reversed()
                .thenComparing(Comparator.comparing((Employee e) -> e.surname).reversed())
                .thenComparing(a -> a.age)
                .thenComparing(a -> a.salary);
        employees.sort(comparator);
        print(employees);
        Comparator<Employee> reversedComparator = comparator.reversed();
        employees.sort(reversedComparator);
        print(employees);
    }
    private static void print(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }
    static class  Employee implements Comparable<Employee> {
        private final String name;
        private final String surname;
        private final int age;
        // jak piniondze to BigDecimal!
        private final BigDecimal salary;
        public Employee(
                final String name,
                final String surname,
                final int age,
                final BigDecimal salary
        ) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.salary = salary;
        }
        @Override
        public String toString() {
            return "Employee{name='"
                    + name + "', surname='"
                    + surname + "', age="
                    + age + ", salary="
                    + salary + '}';
        }
        @Override
        public int compareTo(final Employee other) {
            int nameCompareTo = name.compareTo(other.name);
            if (nameCompareTo != 0) {
                return nameCompareTo;
            }
            int surnameCompareTo = other.surname.compareTo(surname);
            if (surnameCompareTo != 0) {
                return surnameCompareTo;
            }
            int ageCompareTo = Integer.compare(age, other.age);
            if (ageCompareTo != 0) {
                return ageCompareTo;
            }
            return other.salary.compareTo(salary);
        }
    }
}
