package by.epam.golubev.consol.bank.application.dao.impl;

import by.epam.golubev.consol.bank.application.dao.beans.BankAccount;
import by.epam.golubev.consol.bank.application.dao.ListAccount;

import java.util.ArrayList;
import java.util.List;

public class ListBankAccountImpl implements ListAccount {

    private final List<BankAccount> bankAccounts = new ArrayList<>();
    private static final ListBankAccountImpl INSTANCE = new ListBankAccountImpl();

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public static ListBankAccountImpl getInstance() {
        return INSTANCE;
    }

    public List<BankAccount> getBanksAccounts() {
        return bankAccounts;
    }
    public int getSize(){ return bankAccounts.size();}
}

