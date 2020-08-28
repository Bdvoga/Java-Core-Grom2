package lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        if (amount + user.getBank().getCommission(amount) > user.getBank().getLimitOfWithdrawal() ||
                amount + user.getBank().getCommission(amount) > user.getBalance()) {
            System.err.println("Can't withdraw money " + amount + " from user" + user.toString());
            return;
        }

        user.setBalance(user.getBalance() - amount * (1 + user.getBank().getCommission(amount)));
    }

    @Override
    public void fund(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't funding money " + amount + " to user" + user.toString());
            return;
        }
        user.setBalance(user.getBalance() + amount);
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
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary());
    }
}
