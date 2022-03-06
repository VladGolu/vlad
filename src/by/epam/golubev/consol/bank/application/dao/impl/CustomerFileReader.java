package by.epam.golubev.consol.bank.application.dao.impl;

import by.epam.golubev.consol.bank.application.dao.beans.Customer;

import java.io.*;

public class CustomerFileReader {
    public void ReadCustomerFromFile(Customer customer) throws IOException, ClassNotFoundException {
        FileInputStream customerFile = new FileInputStream("CustomerFile.bin");
        ObjectInputStream cus = new ObjectInputStream(customerFile);
        boolean flag = true;
        while (flag) {
            Customer customer1 = (Customer) cus.readObject();
            if (customer1 == customer)
                System.out.println("Такой пользователь есть в папке");
            cus.close();
            flag = false;
            if (customer1 == null) {
                System.out.println("Пользователя нет");
            } else System.out.println("Привет");
        }
    }
}

