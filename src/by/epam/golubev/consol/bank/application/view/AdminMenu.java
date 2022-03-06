package by.epam.golubev.consol.bank.application.view;

import by.epam.golubev.consol.bank.application.dao.beans.Customer;
import by.epam.golubev.consol.bank.application.service.BankAccountService;
import by.epam.golubev.consol.bank.application.service.ConsoleService;

import java.io.IOException;
import java.util.Scanner;

public class AdminMenu {
    ConsoleService consoleService=new ConsoleService();
   BankAccountService bankAccountService=new BankAccountService();
    private final Scanner menu = new Scanner(System.in);

    public void adminMenu(Customer customer) throws IOException, ClassNotFoundException {

        consoleService.createConsoleForAdminMenu();
        int customChoice = Integer.parseInt(menu.next());

        switch (customChoice) {
            case 1 -> {
                bankAccountService.showListCustomer();
                adminMenu(customer);
            }

            case 2 -> {
            bankAccountService.giveAdmin();
            adminMenu(customer);
            }

            case 3 -> {
                bankAccountService.deleteCustomer(customer);
                adminMenu(customer);

            }
            case 4 -> {
                EnterCustomerMenu enterCustomerMenu= new EnterCustomerMenu();
                enterCustomerMenu.enterCustomerMenu(customer);
            }
            default -> throw new IllegalStateException("Unexpected value: " + customChoice);
        }
    }
}
