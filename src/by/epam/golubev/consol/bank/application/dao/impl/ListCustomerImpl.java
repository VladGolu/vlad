package by.epam.golubev.consol.bank.application.dao.impl;

import by.epam.golubev.consol.bank.application.dao.ListCustomer;
import by.epam.golubev.consol.bank.application.dao.beans.Customer;


import java.util.*;

public class ListCustomerImpl implements ListCustomer {

    private final List<Customer> customers = new ArrayList<>();
    private static final ListCustomerImpl INSTANCE = new ListCustomerImpl();

    private ListCustomerImpl() {

    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static ListCustomerImpl getInstance() {
        return INSTANCE;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    public int getSize(){ return customers.size();}


}







