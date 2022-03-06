package by.epam.golubev.consol.bank.application.view;

import by.epam.golubev.consol.bank.application.dao.beans.Customer;
import by.epam.golubev.consol.bank.application.service.BankAccountService;
import by.epam.golubev.consol.bank.application.service.ConsoleService;

import java.io.IOException;
import java.util.Scanner;

/**
 * This menu for transaction operation
 */
public class TransactionMenu {

    private final Scanner menu = new Scanner(System.in);
    BankAccountService bankAccountService = new BankAccountService();
    EnterCustomerMenu enterCustomerMenu = new EnterCustomerMenu();
    ConsoleService consoleService = new ConsoleService();

    /**
     * param customer
     */
    public void transactionMenu(Customer customer) throws IOException, ClassNotFoundException {
        consoleService.creteConsoleForTransactionMenu();

        int customChoice = Integer.parseInt(menu.next());

        switch (customChoice) {
            case 1 -> {
                bankAccountService.transferMoneyToYourself(customer);
                enterCustomerMenu.enterCustomerMenu(customer);
            }

            case 2 -> {
                bankAccountService.transferMoneyToCustomer(customer);
                enterCustomerMenu.enterCustomerMenu(customer);
            }

            case 3 -> {
                enterCustomerMenu.enterCustomerMenu(customer);
            }
        }
    }
}

