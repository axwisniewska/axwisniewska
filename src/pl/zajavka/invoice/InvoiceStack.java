package pl.zajavka.invoice;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class InvoiceStack {
    private Integer counter = 1;
    private Deque<Invoice> invoiceStack = new ArrayDeque<>();

    public void processInput(String command) {
        if (command.contains("CEO: ADD INVOICE")) {
            processCEOInput(command);
        } else if ("ACCOUNTANT: PROCESS INVOICE".equals(command)) {
            processAccountantInput(command);
        } else {
            System.out.println("O co Ci chodzi?");
        }
    }

    private void processCEOInput(String command) {
        BigDecimal amount = new BigDecimal(command.substring(command.indexOf("(") + 1, command.indexOf(")")));
        Integer year = 2005;
        String id = counter + "/" + year;
        counter++;
        Invoice invoice = new Invoice(id, amount);
        invoiceStack.push(invoice);
        System.out.printf("%s%n", command);
        System.out.printf("CEO added invoice: ID: %s, amount: %s%n", id, amount);
        System.out.printf("Current invoices amount: %s. Invoices: %s%n%n", getInvoicesSum(), invoiceStack);
    }

    private void processAccountantInput(String command) {
        System.out.printf("%s%n", command);
        if (invoiceStack.isEmpty()) {
            System.out.println("Stack empty. No work for Accountant.");
            return;
        }
        Invoice invoice = invoiceStack.pop();
        System.out.printf("ACCOUNTANT processed invoice: %s%n", invoice);
        System.out.printf("Current invoices amount: %s. Invoices: %s%n%n", getInvoicesSum(), invoiceStack);
    }

    private String getInvoicesSum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Invoice invoice : invoiceStack) {
            sum = sum.add(invoice.getAmount());
        }
        return sum.toString();
    }
}