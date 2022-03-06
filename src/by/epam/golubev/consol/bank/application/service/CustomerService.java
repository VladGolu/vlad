package by.epam.golubev.consol.bank.application.service;

import by.epam.golubev.consol.bank.application.dao.beans.Customer;
import by.epam.golubev.consol.bank.application.dao.impl.ListCustomerImpl;
import by.epam.golubev.consol.bank.application.service.controller.VerificationController;
import by.epam.golubev.consol.bank.application.service.controller.validator.impl.ValidatorImpl;
import by.epam.golubev.consol.bank.application.view.EnterCustomerMenu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerService {


    VerificationController verificationController = new VerificationController();
    List<Customer> customers = ListCustomerImpl.getInstance().getCustomers();
    private final Scanner menu = new Scanner(System.in);

    public int ListCustomerSizeCheck() {
        int SizeListCustomer = 0;
        for (Customer customer : customers) {
            if (customer.getCustomerLogin() != null) {
                SizeListCustomer++;
            }
        }
        return SizeListCustomer;
    }

    public void changeCustomerInfo(Customer customer) throws IOException, ClassNotFoundException {
        System.out.println("\nВыбирите что изменить");
        System.out.println("\n 1.Ваш логин" + customer.getCustomerLogin());
        System.out.println("\n 2.Ваш возраст" + customer.getAge());
        System.out.println("\n 3.Ваш пароль" + Arrays.toString(customer.getCharPassword()));
        System.out.println("\n 4.Ваш PIN" + customer.getPIN());
        System.out.println("\n 5.Назад");
        int choice = Integer.parseInt(menu.next());

                if (choice == 1) {
                    customer.setLogin(verificationController.Logination());
                }
                if (choice == 2) {
                    customer.setAge(Integer.parseInt(verificationController.AgeLog()));
                }
                if (choice == 3) {
                    RegistrationService registrationService = new RegistrationService();
                    customer.setCharPassword(registrationService.enterPassword());
                }
                if (choice == 4) {
                    customer.setPIN(verificationController.enterAccountPIN());
                }
                if (choice == 5) {
                    EnterCustomerMenu enterCustomerMenu = new EnterCustomerMenu();
                    enterCustomerMenu.enterCustomerMenu(customer);
                }
                System.out.println(customer);
            }
        }


