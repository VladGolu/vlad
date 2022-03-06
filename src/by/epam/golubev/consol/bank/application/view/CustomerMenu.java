package by.epam.golubev.consol.bank.application.view;

import by.epam.golubev.consol.bank.application.dao.beans.Customer;

import by.epam.golubev.consol.bank.application.service.ConsoleService;
import by.epam.golubev.consol.bank.application.service.controller.VerificationController;
import by.epam.golubev.consol.bank.application.dao.impl.CustomerFileReader;
import by.epam.golubev.consol.bank.application.dao.impl.CustomerFileWriter;
import by.epam.golubev.consol.bank.application.dao.impl.ListCustomerImpl;
import by.epam.golubev.consol.bank.application.service.RegistrationService;

import java.io.IOException;
import java.util.Scanner;

public class CustomerMenu {

    int customChoice;

    ListCustomerImpl listCustomer = ListCustomerImpl.getInstance();
    VerificationController verificationController = new VerificationController();
    RegistrationService registrationService = new RegistrationService();
    CustomerFileWriter customerFileWriter = new CustomerFileWriter();
    CustomerFileReader customerFileReader = new CustomerFileReader();
    ConsoleService consoleService= new ConsoleService();

    private final Scanner menu = new Scanner(System.in);

    public void customMenu() throws IOException, ClassNotFoundException {

        consoleService.creteConsoleForCustomerMenu();
        customChoice = Integer.parseInt(menu.next());

        switch (customChoice) {
            case 1 -> {
                System.out.print("\nВойдите в аккаунт");
                verificationController.enterToAccount();
            }

            case 2 -> {
                System.out.print("\nПожалуйста зарегистрируйтесь");
                Customer customer = new Customer(verificationController.Logination(), verificationController.AgeLog(), registrationService.enterPassword(), registrationService.firstAdminService(), registrationService.idForCustomer(), verificationController.enterAccountPIN());
                customerFileWriter.writeCustomerInFile(customer);
                customerFileReader.ReadCustomerFromFile(customer);
                listCustomer.addCustomer(customer);
            }

            case 3 -> {
                System.out.print("\nВы вышли из программы");
                System.exit(0);
            }
            default -> {

                System.out.println("Неверное значение, повторите ввод");
                customMenu();
            }
        }
    }
}
