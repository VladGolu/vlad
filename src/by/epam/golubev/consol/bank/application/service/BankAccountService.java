package by.epam.golubev.consol.bank.application.service;

import by.epam.golubev.consol.bank.application.dao.beans.BankAccount;
import by.epam.golubev.consol.bank.application.dao.beans.Customer;
import by.epam.golubev.consol.bank.application.dao.impl.ListCustomerImpl;
import by.epam.golubev.consol.bank.application.service.controller.validator.Validator;
import by.epam.golubev.consol.bank.application.service.controller.validator.impl.ValidatorImpl;
import by.epam.golubev.consol.bank.application.view.CustomerMenu;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BankAccountService {

    CustomerMenu customerMenu = new CustomerMenu();
    List<Customer> customers = ListCustomerImpl.getInstance().getCustomers();
    private final Scanner menu = new Scanner(System.in);
    private final Validator validator = ValidatorImpl.getINSTANCE();
    public String enterBankAccountLogin() {
        System.out.println("Введите название счёта ");
        return menu.next();
    }

    public String enterBankAccountPINCode() {
        System.out.println("Создайте PIN из 4 цифр ");
        return menu.next();
    }

    public boolean enterBankAccountPINCodeCheck(String PIN) {
        boolean flag = true;
        if (PIN.length() == 4) {
            for (int i = 0; i < PIN.length(); i++) {
                if (!validator.isDigit(PIN.charAt(i))) {
                    flag = false;
                    break;
                }
            }
        } else flag = false;
        return flag;
    }

    public void createReplenishMenu(Customer customer) {
        int i = 0;
        for (BankAccount bankAccount : customer.getBankAccounts()) {
            i++;
            System.out.println(i + "." + bankAccount);
        }
    }

    public void replenishService(int replenishChoice, Customer customer) {
        int i = 0;

        for (BankAccount bankAccount : customer.getBankAccounts()) {
            i++;
            if (replenishChoice == i) {
                System.out.println("Ваш баланс- " + bankAccount.getAccountBalance());
                System.out.println("Введите сумму пополнения");
                long NewBalance = bankAccount.getAccountBalance() + Integer.parseInt(menu.next());
                bankAccount.setAccountBalance(NewBalance);
            }
        }
    }

    public void transferMoneyToYourself(Customer customer) {
        System.out.println("vlad begin");
        System.out.println(new Date());
        int i = 0;
        int j = 0;
        int f = 0;
        for (BankAccount bankAccount3 : customer.getBankAccounts()) {
            f++;
            System.out.println(f + " " + bankAccount3);
        }
        System.out.println("Введите номер счёта с которого нужно перевести");
        int choice = Integer.parseInt(menu.next());
        for (BankAccount bankAccount : customer.getBankAccounts()) {
            i++;
            if (choice == i) {
                System.out.println("Баланс счёта" + bankAccount.getBankAccountName() + "составляет" + bankAccount.getAccountBalance());
                System.out.println("Выбирите аккаунт для перевода");

                int choice2 = Integer.parseInt(menu.next());
                for (BankAccount bankAccount1 : customer.getBankAccounts()) {
                    j++;
                    if (choice2 == j) {
                        System.out.println("Баланс счёта" + bankAccount1.getBankAccountName() + "cоставляет" + bankAccount1.getAccountBalance());
                        System.out.println("Введите сумму перевода");
                        long transferSum = Integer.parseInt(menu.next());
                        if (transferSum > bankAccount.getAccountBalance()) {
                            System.out.println("Недостаточно средств на счёте");
                            transferMoneyToYourself(customer);
                            break;
                        }
                        long NewBalance = bankAccount.getAccountBalance() - transferSum;
                        long NewBalance1 = bankAccount1.getAccountBalance() + transferSum;
                        bankAccount.setAccountBalance(NewBalance);
                        bankAccount1.setAccountBalance(NewBalance1);
                    }
                }
            }
        }
        System.out.println("vlad end");
        System.out.println(new Date());
    }

    public void transferMoneyToCustomer(Customer customer) {
        int i = 0;
        int f = 0;
        int j = 0;
        int t = 0;
        for (BankAccount bankAccount3 : customer.getBankAccounts()) {
            t++;
            System.out.println(t + " " + bankAccount3);
        }
        System.out.println("Введите номер счёта с которого нужно перевести");
        int choice = Integer.parseInt(menu.next());
        for (BankAccount bankAccount : customer.getBankAccounts()) {
            i++;
            if (choice == i) {
                System.out.println("Баланс счёта" + bankAccount.getBankAccountName() + "составляет" + bankAccount.getAccountBalance());
                System.out.println("Введите логин аккаунта на который будет осуществлён перевод");
                String acc = menu.next();
                for (Customer customer1 : customers) {
                    if (customer1.getCustomerLogin().equals(acc)) {
                        for (BankAccount bankAccount1 : customer1.getBankAccounts()) {
                            f++;
                            System.out.println(f + " " + bankAccount1);
                            System.out.println("Выбирите счёт для перевода");
                        }
                        int choice2 = Integer.parseInt(menu.next());
                        for (BankAccount bankAccount2 : customer1.getBankAccounts()) {
                            j++;
                            if (choice2 == j) {
                                System.out.println("Введите сумму перевода");
                                long transferSum = Integer.parseInt(menu.next());
                                if (transferSum > bankAccount.getAccountBalance()) {
                                    System.out.println("Недостаточно средств на счёте");
                                    transferMoneyToCustomer(customer);
                                    break;
                                }
                                long NewBalance = bankAccount.getAccountBalance() - transferSum;
                                long NewBalance1 = bankAccount2.getAccountBalance() + transferSum;
                                bankAccount.setAccountBalance(NewBalance);
                                bankAccount2.setAccountBalance(NewBalance1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void showListCustomer() {
        int f = 0;
        for (Customer customer : customers) {
            f++;
            System.out.println(f + " " + customer);
        }
    }

    public void giveAdmin() {
        showListCustomer();
        System.out.println("Введите логин аккаунта");
        String acc = menu.next();
        for (Customer customer1 : customers) {
            if (customer1.getCustomerLogin().equals(acc)){
            customer1.setCustomerStatus("Admin");
            }
        }
    }
    public void deleteCustomer(Customer customer) throws IOException, ClassNotFoundException {
        showListCustomer();
        System.out.println("Введите логин аккаунта для удаления");
        String acc = menu.next();
        if(customer.getCustomerLogin().equals(acc)){
            customers.removeIf(customer1 -> customer1.getCustomerLogin().equals(acc));
            customerMenu.customMenu();}
        else {
        customers.removeIf(customer1 -> customer1.getCustomerLogin().equals(acc));
        }

        }

    }

