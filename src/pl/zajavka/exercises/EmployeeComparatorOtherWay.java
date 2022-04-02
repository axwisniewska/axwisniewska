package pl.zajavka.exercises;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeComparatorOtherWay {
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
//        Collections.sort(employees);
//        Comparator<Employee> comparator = Comparator.<Employee, String>comparing(e -> e.getName()).reversed()
//                .thenComparing(Comparator.<Employee, String>comparing(e -> e.getSurname()).reversed())
//                .thenComparingInt(e -> e.getAge())
//                .thenComparing(e -> e.getSalary());

        Comparator<Employee> comparator = Comparator.<Employee, String>comparing(e -> e.getName()).reversed()
                .thenComparing(Comparator.<Employee, String>comparing(e -> e.getSurname()).reversed())
                .thenComparingInt(e -> e.getAge())
                .thenComparing(e -> e.getSalary());

        employees.sort(comparator);


        print(employees);


    }
    private static void print(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }

}
