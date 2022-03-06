package by.epam.golubev.consol.bank.application.view;

import by.epam.golubev.consol.bank.application.dao.beans.BankAccount;
import by.epam.golubev.consol.bank.application.dao.beans.Customer;
import by.epam.golubev.consol.bank.application.dao.impl.ListBankAccountImpl;
import by.epam.golubev.consol.bank.application.service.*;

import java.io.IOException;
import java.util.Scanner;

public class EnterCustomerMenu {

    BankAccountService bankAccountService = new BankAccountService();
    RegistrationService registrationService = new RegistrationService();
    ListBankAccountImpl listBankAccount = ListBankAccountImpl.getInstance();
    ConsoleService consoleService = new ConsoleService();
    private final Scanner menu = new Scanner(System.in);
    AdminMenu adminMenu = new AdminMenu();

    /**
     * param customer
     */
    public void enterCustomerMenu(Customer customer) throws IOException, ClassNotFoundException {
        consoleService.creteConsoleForEnterCustomerMenu();

        int customChoice = Integer.parseInt(menu.next());

        switch (customChoice) {
            case 1 -> {
                BankAccount bankAccount = new BankAccount(bankAccountService.enterBankAccountLogin(), customer.getPIN(), registrationService.idForBankAccount(customer));
                customer.addBankAccount(bankAccount);
                listBankAccount.addBankAccount(bankAccount);
                System.out.println(bankAccount);
                enterCustomerMenu(customer);
            }

            case 2 -> {
                TransactionMenu transactionMenu = new TransactionMenu();
                transactionMenu.transactionMenu(customer);
            }
            case 3 -> {
                ReplenishMenu replenishMenu = new ReplenishMenu();
                replenishMenu.replenishMenu(customer);
            }
            case 4 -> {
                CustomerService customerService = new CustomerService();
                customerService.changeCustomerInfo(customer);
                enterCustomerMenu(customer);
            }
            case 5 -> {
                if (customer.getCustomerStatus() == "Admin") {
                    adminMenu.adminMenu(customer);
                }
                else {
                    System.out.println("Вы не обладаете правами администратора");
                    enterCustomerMenu(customer);
                }
            }

            case 6 -> {
                ApplicationExecutor applicationExecutor = new ApplicationExecutor();
                try {
                    applicationExecutor.execute();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
