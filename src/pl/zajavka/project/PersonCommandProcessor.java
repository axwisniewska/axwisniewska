package pl.zajavka.project;

public class PersonCommandProcessor {

    private final CustomQueue<Person> customQueue;

    public PersonCommandProcessor(CustomQueue<Person> customQueue) {
        this.customQueue = customQueue;
    }

    public void processCommand(String command) {
        if (command.contains("VIP")) {
            addingVIPPerson(command);
        } else if (command.contains("ADD PERSON")) {
            addingPerson(command);
        } else if (command.contains("LEAVE PERSON")) {
            deletingPerson(command);
        } else if ("PROCESS".equals(command)) {
            processing(command);
        } else {
            throw new RuntimeException("O co Ci chodzi z tą komendą: " + command + "?");
        }
    }

    private void addingVIPPerson(String command) {
        System.out.println(command);
        Person person = createVIPPerson(command);
        customQueue.addVIP(person);
    }

    private Person createVIPPerson(String command) {
        String providedName = command.substring(command.indexOf("(") + 1, command.indexOf(")"));
        String[] splitTemp = providedName.split("_");
        String splitName = splitTemp[0];
        String[] split = splitTemp[1].split(",");
        String splitSurname = split[0];
        String vip = split[1];
        String keyPerson = (splitName + " " + splitSurname);


        if (splitTemp.length == 2) {
            return new Person(splitName, splitSurname, customQueue.getAndIncrementCounter(providedName), vip);
        }
        else {
            throw new IllegalArgumentException("Illegal argument: " + command);
        }
    }

    private void addingPerson(String command) {
        System.out.println(command);
        Person person = createIncomingPerson(command);
        customQueue.add(person);
    }

    private Person createIncomingPerson(String command){
        String providedName = command.substring(command.indexOf("(") + 1, command.indexOf(")"));
        String[] split = providedName.split("_");

//DRUGA OPCJA NA WYCIĄGNIĘCIE IMIENIA I NAZWISKA
        String[] split2 = command
                .replace("ADD PERSON(", "")
                .replace(")", "")
                .split("_");

        if (split.length == 2) {
            return new Person(split[0], split[1], customQueue.getAndIncrementCounter(providedName));
        }
        else {
            throw new IllegalArgumentException("Illegal argument: " + command);
        }
    }

    private void deletingPerson(String command) {
        System.out.println(command);
        Person person = createLeavingPerson(command);
        customQueue.delete(person);

    }

    private Person createLeavingPerson(String command) {
        String providedName = command.substring(command.indexOf("(") + 1, command.indexOf(")"));
        String[] split = providedName.split("_");

        if (split.length == 2){
            return new Person(split[0], split[1], 1);
        } else if (split.length == 3){
            return new Person(split[0], split[1], Integer.parseInt(split[2]));
        } else {
            throw new IllegalArgumentException("Illegal argument: " + command);
        }
    }

    private void processing(String command) {
        System.out.println(command);
        customQueue.enter();
    }
}
