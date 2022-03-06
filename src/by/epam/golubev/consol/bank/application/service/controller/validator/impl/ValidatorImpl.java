package by.epam.golubev.consol.bank.application.service.controller.validator.impl;

import by.epam.golubev.consol.bank.application.service.controller.validator.Validator;

public class ValidatorImpl implements Validator {


    private static final ValidatorImpl INSTANCE = new ValidatorImpl();

    private ValidatorImpl() {
    }

    public static ValidatorImpl getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public boolean isAgeDigit(String age) {
        boolean isAgeDigit = true;
        int p = 0;
        for (int i = 0; i < age.length(); i++) {
            if (!isDigit(age.charAt(i))) {
                isAgeDigit = false;
                break;
            }
        }
        return isAgeDigit;
    }

    public boolean isDigit(char ch) {
        return "1234567890".indexOf(ch) != -1;
    }

}
