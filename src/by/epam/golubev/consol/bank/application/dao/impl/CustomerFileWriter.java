package by.epam.golubev.consol.bank.application.dao.impl;

import by.epam.golubev.consol.bank.application.dao.beans.Customer;

import java.io.*;

public class CustomerFileWriter {

    public void writeCustomerInFile(Customer customer) {
        try {
            FileOutputStream customerFile = new FileOutputStream("CustomerFile.bin");
            ObjectOutputStream cus = new ObjectOutputStream(customerFile);
            cus.writeObject(customer);
            cus.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


