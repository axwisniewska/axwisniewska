package pl.zajavka.exercises;

import java.util.*;

public class TreeMapExercise {
    public static void main(String[] args) {
        List<String> inputPeopleList = List.of(
                "Jan Kowalski +48928192871",
                "Stefan Nawrocki +48457125847",
                "Joanna Spychalski +48597421413",
                "Monika Spychalski +48597421452",
                "Anna Nawrocki +4859742145731",
                "Renata Iksiński +4859742145731",
                "Magdalena Iksiński +4859742145731",
                "Ewa Nawrocki +4859742145731",
                "Anna Spychalski +48597421617"
        );
        List<Person> peopleList = new ArrayList<>();
        for (String input : inputPeopleList) {
            peopleList.add(new Person(input));
        }
        Map<String, List<Person>> phoneBook = new TreeMap<>();
        for (Person person : peopleList) {
            addPersonToPhoneBook(phoneBook, person);
        }
    }

    private static void addPersonToPhoneBook(Map<String, List<Person>> phoneBook, Person person) {
        List<Person> bySurnameList = getSurnameList(phoneBook, person);
        bySurnameList.add(person);
        bySurnameList.sort((Comparator.comparing(p -> p.getName())));
        phoneBook.put(person.getSurname(), bySurnameList);
        print(phoneBook);
    }

    private static List<Person> getSurnameList(Map<String, List<Person>> phoneBook, Person person) {
        return !phoneBook.containsKey(person.getSurname())
                ? new ArrayList<>()
                : phoneBook.get(person.getSurname());
    }

    private static void print(Map<String, List<Person>> phoneBook) {
        System.out.println("#########");
        for (Map.Entry<String, List<Person>> entry : phoneBook.entrySet()) {
            System.out.println(entry);
        }
    }

    private static class Person {
        private final String name;
        private final String surname;
        private final String phone;

        public Person(String input) {
            String[] splitInput = input.split(" ");
            if (splitInput.length == 3) {
                this.name = splitInput[0];
                this.surname = splitInput[1];
                this.phone = splitInput[2];
            } else {
                throw new RuntimeException("Wrong input: " + input
                        + ". Name, surname and phone number separated by space needed.");
            }
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", phoneNumber='" + phone + '\'' +
                    '}';
        }
    }
}