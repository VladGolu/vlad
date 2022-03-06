package by.epam.golubev.consol.bank.application;

import by.epam.golubev.consol.bank.application.service.ApplicationExecutor;

import java.io.IOException;
/**
 * Start point of program
 */
public class Main {
    /**
     *
     * param args
     * throws IOException
     * throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ApplicationExecutor applicationExecutor = new ApplicationExecutor();
        applicationExecutor.execute();
    }
}

