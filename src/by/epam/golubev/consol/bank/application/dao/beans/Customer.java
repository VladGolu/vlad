package by.epam.golubev.consol.bank.application.dao.beans;

import by.epam.golubev.consol.bank.application.service.RegistrationService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Customer implements Serializable {
    private String login;
    private String age;
    private int customerId;
    public char[] charPassword;
    public String customerStatus;
    private String PIN;
    RegistrationService registrationService;
    List<BankAccount> bankAccounts = new ArrayList<>();

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void addBankAccount(BankAccount bankAccount) {

        bankAccounts.add(bankAccount);
    }

    public int getBankAccountListSize() {
        return bankAccounts.size();
    }

    public String getCustomerLogin() {
        return login;
    }

    public String getAge() {
        return age;
    }

    public char[] getCharPassword() {
        return charPassword;
    }

    public String getPIN() {
        return PIN;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public Customer() {
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setAge(int age) {
        this.age = String.valueOf(age);
    }
    public void setCharPassword(char[] charPassword) {
        this.charPassword = charPassword;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Customer(String login, String age, char[] charPassword, String customerStatus, int customerId, String PIN) {
        this.login = login;
        this.age = age;
        this.charPassword = charPassword;
        this.customerStatus = customerStatus;
        this.customerId = customerId;
        this.PIN = PIN;
    }

    public String toString() {
        return ("\nId -" + customerId + " Логин - " + login + " Возраст -" + age + "Статус" + customerStatus);
    }

    public void print() {
        System.out.println(charPassword);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (!Objects.equals(login, customer.login)) return false;
        if (!Objects.equals(age, customer.age)) return false;
        if (!Arrays.equals(charPassword, customer.charPassword)) return false;
        if (!Objects.equals(customerStatus, customer.customerStatus))
            return false;
        if (!Objects.equals(PIN, customer.PIN)) return false;
        return Objects.equals(registrationService, customer.registrationService);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + customerId;
        result = 31 * result + Arrays.hashCode(charPassword);
        result = 31 * result + (customerStatus != null ? customerStatus.hashCode() : 0);
        result = 31 * result + (PIN != null ? PIN.hashCode() : 0);
        result = 31 * result + (registrationService != null ? registrationService.hashCode() : 0);
        return result;
    }
}
