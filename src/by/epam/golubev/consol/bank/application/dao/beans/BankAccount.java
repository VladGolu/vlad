package by.epam.golubev.consol.bank.application.dao.beans;

import java.io.Serializable;
import java.util.Objects;

public class BankAccount implements Serializable {

    private final String bankAccountName;
    private final int bankAccountId;
    String PIN;
    public String accountStatus;
    long accountBalance;

    public long getAccountBalance() {
        return accountBalance;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public BankAccount(String bankAccountName, String PIN, int bankAccountId) {
        this.bankAccountName = bankAccountName;
        this.PIN = PIN;
        this.bankAccountId = bankAccountId;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return ("\nId BankAccount -" + bankAccountId + " Название счёта - " + bankAccountName + " Баланс -" + accountBalance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        if (bankAccountId != that.bankAccountId) return false;
        if (accountBalance != that.accountBalance) return false;
        if (!Objects.equals(bankAccountName, that.bankAccountName))
            return false;
        if (!Objects.equals(PIN, that.PIN)) return false;
        return Objects.equals(accountStatus, that.accountStatus);
    }

    @Override
    public int hashCode() {
        int result = bankAccountName != null ? bankAccountName.hashCode() : 0;
        result = 31 * result + bankAccountId;
        result = 31 * result + (PIN != null ? PIN.hashCode() : 0);
        result = 31 * result + (accountStatus != null ? accountStatus.hashCode() : 0);
        result = 31 * result + (int) (accountBalance ^ (accountBalance >>> 32));
        return result;
    }

}
