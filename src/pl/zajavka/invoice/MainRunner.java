package pl.zajavka.invoice;

import java.util.List;
import java.util.Scanner;

public class MainRunner {
    public static void main(String[] args) {
        InvoiceStack invoiceStack = new InvoiceStack();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide new invoice by entering \"CEO: ADD INVOICE(amount)\" " +
                "or process invoice by entering \"ACCOUNTANT: PROCESS INVOICE\"");
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if ("EXIT".equals(command)) {
                break;
            }
            invoiceStack.processInput(command);
        }
// Bez Scanner
        List<String> inputs = List.of(
                "CEO: ADD INVOICE(19.20)",
                "CEO: ADD INVOICE(31.40)",
                "ACCOUNTANT: PROCESS INVOICE",
                "CEO: ADD INVOICE(21.20)",
                "CEO: ADD INVOICE(120.99)",
                "ACCOUNTANT: PROCESS INVOICE",
                "ACCOUNTANT: PROCESS INVOICE",
                "ACCOUNTANT: PROCESS INVOICE"
        );
        for (String input : inputs) {
            invoiceStack.processInput(input);
        }
    }
}
