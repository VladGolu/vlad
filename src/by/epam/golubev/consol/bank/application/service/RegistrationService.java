package by.epam.golubev.consol.bank.application.service;

import by.epam.golubev.consol.bank.application.dao.beans.Customer;
import by.epam.golubev.consol.bank.application.dao.impl.ListCustomerImpl;
import by.epam.golubev.consol.bank.application.view.EnterCustomerMenu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RegistrationService {

    List<Customer> customers = ListCustomerImpl.getInstance().getCustomers();
    CustomerService customerService = new CustomerService();

    private final Scanner menu = new Scanner(System.in);

    /**
     *
     * @return
     */
    public String enterLogin() {
        System.out.print("\nВведите логин");
        String customerLogin = menu.next();
        System.out.print(customerLogin);
        return customerLogin;
    }

    /**
     *
     * @return
     */
    public char[] enterPassword() {
        System.out.print("\nВведите пароль");
        String stringPassword = menu.next();
        char[] charPassword = stringPassword.toCharArray();
        System.out.println(charPassword);
        for (char c : charPassword) {
            System.out.print(c);
        }
        return charPassword;
    }

    public String enterAge() {
        System.out.print("\nВведите возраст");
        String customerAge = menu.next();
        System.out.print(customerAge);
        return customerAge;
    }

    public String firstAdminService() {
        String customerStatus = "Customer";
        if (customerService.ListCustomerSizeCheck() == 0) {
            customerStatus = "Admin";
        }
        return customerStatus;
    }

    public int idForCustomer() {
        int customerId = customerService.ListCustomerSizeCheck();
        customerId++;
        return customerId;
    }

    public boolean CheckNewLoginCustomerInDao(String login) {
        boolean flag = true;
        if (customerService.ListCustomerSizeCheck() > 0) {
            for (Customer customer : customers) {
                if (customer.getCustomerLogin().equals(login)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public Boolean customerEnterAccount(String login, char[] charPassword) throws IOException, ClassNotFoundException {
        boolean flag = false;
        for (Customer customer : customers) {
            System.out.println(customer.getCustomerLogin());
            System.out.println(customer);
            System.out.println(customer.getCharPassword());
            if (customer.getCustomerLogin().equals(login) && Arrays.equals((customer.getCharPassword()), charPassword)) {
                flag = true;
                System.out.println(customer);
                EnterCustomerMenu enterCustomerMenu = new EnterCustomerMenu();
                enterCustomerMenu.enterCustomerMenu(customer);

            }
        }
        return flag;
    }

    public int idForBankAccount(Customer customer) {
        int bankAccountId = customer.getBankAccountListSize();
        bankAccountId++;
        return bankAccountId;
    }
}




