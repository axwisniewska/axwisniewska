package pl.zajavka.exercises;

import java.math.BigDecimal;
import java.util.Comparator;

public class  Employee implements Comparable<Employee> {
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
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
    public int compareTo(final Employee employee) {
        return Comparator.<Employee, String>comparing(e3 -> e3.name)
                .thenComparing((e1, e2) -> e2.surname.compareTo(e1.surname))
                .thenComparingInt(e -> e.age)
                .thenComparing((e1, e2) -> e2.salary.compareTo(e1.salary))
                .compare(this, employee);



//        Comparator<Employee> comparingName = Comparator.comparing(e -> e.name);
//        Comparator<Employee> comparingSurname = comparingName
//                .thenComparing((e1, e2) -> e2.surname.compareTo(e1.surname));
//        Comparator<Employee> comparingAge = comparingSurname.thenComparingInt(e -> e.age);
//        Comparator<Employee> comparingSalary = comparingAge
//                .thenComparing((e1, e2) -> e2.salary.compareTo(e1.salary));
//        return comparingSalary.compare(this, employee);




//        int nameCompareTo = this.name.compareTo(employee.name);
//        if (nameCompareTo != 0) {
//            return nameCompareTo;
//        }
//        int surnameCompareTo = employee.surname.compareTo(this.surname);
//        if (surnameCompareTo != 0) {
//            return surnameCompareTo;
//        }
//        int ageCompareTo = this.age - employee.age;
//        if (ageCompareTo != 0) {
//            return ageCompareTo;
//        }
//        return employee.salary.compareTo(salary);
    }
}
