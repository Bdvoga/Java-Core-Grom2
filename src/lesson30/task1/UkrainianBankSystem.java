package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        if (amount + user.getBank().getCommission(amount) > user.getBank().getLimitOfWithdrawal() ||
                amount + user.getBank().getCommission(amount) > user.getBalance()) {
            System.err.println("Can't withdraw money " + amount + " from user" + user.toString());
            return;
        }
        user.setBalance(user.getBalance() - amount * (1 + user.getBank().getCommission(amount)));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdsdc");
    }

    @Override
    public void fund(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't funding money " + amount + " to user" + user.toString());
            return;
        }
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "sdsdc");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if ((fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) ||
                amount + fromUser.getBank().getCommission(amount) > fromUser.getBank().getLimitOfWithdrawal() ||
                amount + fromUser.getBank().getCommission(amount) > fromUser.getBalance() ||
                amount > toUser.getBank().getLimitOfFunding()) {
            System.err.println("Can't transfer money " + amount + " from user " + fromUser.toString() + " to user " + toUser.toString());
            return;
        }

        fromUser.setBalance(fromUser.getBalance() - amount * (1 + fromUser.getBank().getCommission(amount)));
        toUser.setBalance(toUser.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "sdsdc");
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary());

        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "sdsdc");
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
