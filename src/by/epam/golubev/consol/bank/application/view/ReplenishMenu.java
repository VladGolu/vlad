package by.epam.golubev.consol.bank.application.view;

import by.epam.golubev.consol.bank.application.dao.beans.Customer;
import by.epam.golubev.consol.bank.application.service.BankAccountService;

import java.io.IOException;
import java.util.Scanner;

public class ReplenishMenu {
    final Scanner menu = new Scanner(System.in);
    BankAccountService bankAccountService = new BankAccountService();
    EnterCustomerMenu enterCustomerMenu = new EnterCustomerMenu();

    /**
     * param customer
     */
    public void replenishMenu(Customer customer) throws IOException, ClassNotFoundException {
        bankAccountService.createReplenishMenu(customer);
        System.out.println("\nВведите номер счёта");
        bankAccountService.replenishService(Integer.parseInt(menu.next()), customer);
        enterCustomerMenu.enterCustomerMenu(customer);
    }
}

