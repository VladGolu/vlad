package by.epam.golubev.consol.bank.application.service.controller;

import by.epam.golubev.consol.bank.application.service.BankAccountService;
import by.epam.golubev.consol.bank.application.service.RegistrationService;
import by.epam.golubev.consol.bank.application.service.controller.validator.Validator;
import by.epam.golubev.consol.bank.application.service.controller.validator.impl.ValidatorImpl;

import java.io.IOException;

public class VerificationController {

    private RegistrationService registrationService;
    private final Validator validator = ValidatorImpl.getINSTANCE();
    String login;
    String age;

    public boolean loginVerification(String login) {
        return Character.isUpperCase(login.charAt(0));
    }

    public boolean AgeVerification(String age) {
        boolean flag = true;
        if (!validator.isAgeDigit(age)) {
            System.out.print("\n Неправильно указан возраст, введите снова");
            flag = false;
        }
        return flag;
    }

    public String log() {
        registrationService = new RegistrationService();
        while (true) {
            login = registrationService.enterLogin();
            if (loginVerification(login)) {
                break;
            } else {
                System.out.println("Enter one more time:");
            }
        }
        return login;
    }

    public String AgeLog() {
        registrationService = new RegistrationService();
        while (true) {
            age = registrationService.enterAge();
            if (AgeVerification(age)) {
                break;
            } else {
                System.out.println("Введите числа:");
            }
        }
        return age;
    }

    public String Logination() {
        registrationService = new RegistrationService();
        while (true) {
            login = log();
            if ((registrationService.CheckNewLoginCustomerInDao(login))) {
                break;
            } else {
                System.out.println("Пользователь с таким логином уже существует, введите логин заново:");
            }
        }
        return login;
    }

    public String enterToAccount() throws IOException, ClassNotFoundException {
        registrationService = new RegistrationService();
        while (true) {
            login = log();
            char[] pass = registrationService.enterPassword();
            if ((registrationService.customerEnterAccount(login, pass))) {
                break;
            } else {
                System.out.println("Неверный логин или пароль:");
            }
        }
        return login;
    }

    public String enterAccountPIN() {
        BankAccountService bankAccountService = new BankAccountService();
        String PIN = bankAccountService.enterBankAccountPINCode();
        while (true) {

            if ((bankAccountService.enterBankAccountPINCodeCheck(PIN))) {
                break;
            } else {
                System.out.println("Введите 4 цифры:");
                PIN = bankAccountService.enterBankAccountPINCode();
            }
        }
        return PIN;
    }
}


