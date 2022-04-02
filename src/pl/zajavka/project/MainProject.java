package pl.zajavka.project;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainProject {
    public static void main(String[] args) {
        CustomQueue<Person> queue = new CustomQueue<>(new ArrayDeque<>());
        PersonCommandProcessor commandProcessor = new PersonCommandProcessor(queue);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide your choice by entering \"ADD PERSON(person)\" " +
                "\"PROCESS\", \"LEAVE PERSON(person_personId)\"");
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if ("EXIT".equals(command)) {
                break;
            }
            commandProcessor.processCommand(command);


//        List<String> commandList = List.of(
//                "ADD PERSON(Tomasz_Romański)",
//                "ADD PERSON(Rafał_Adamczuk)",
//                "ADD PERSON(Tomasz_Romański)",
//                "ADD PERSON(Mariusz_Wilczek,VIP)",
//                "ADD PERSON(Zbigniew_Ratownik)",
//                "ADD PERSON(Roman_Tomaszewski,VIP)",
//                "PROCESS",
//                "LEAVE PERSON(Zbigniew_Ratownik)",
//                "LEAVE PERSON(Tomasz_Romański_2)",
//                "PROCESS",
//                "PROCESS",
//                "PROCESS"
//
//        );
//
//        for (String input : commandList) {
//            commandProcessor.processCommand(input);
//        }

        }
    }
}
