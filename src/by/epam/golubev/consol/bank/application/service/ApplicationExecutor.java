package by.epam.golubev.consol.bank.application.service;

import by.epam.golubev.consol.bank.application.view.CustomerMenu;

import java.io.IOException;

public class ApplicationExecutor {
    public void execute() throws IOException, ClassNotFoundException {
        while (true) {
            CustomerMenu customerMenu = new CustomerMenu();
            customerMenu.customMenu();
        }
    }
}
