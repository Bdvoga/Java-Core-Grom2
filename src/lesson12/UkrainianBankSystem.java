package lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        //1. Проверить, можно ли снять -
        //1.1. проверить лимит
        //1.2. достаточно ли денег
        //3. снять

        //1.1
        // Вынесли проверку 1.1 & 1.2 в метод checkWithdraw

//        int limitOfWithdrawal = user.getBank().getLimitOfWithdrawal();
//        if (amount + user.getBank().getCommission(amount) > limitOfWithdrawal) { //c учетом комиссии
//            printWithdrawalErrorMsg(amount, user);
//            return;
//        }
//
//        //1.2
//        if (amount + user.getBank().getCommission(amount) > user.getBalance()) {
//            printWithdrawalErrorMsg(amount, user);
//            return;
//        }
        if (!checkWithdraw(user, amount))
            return;

        //3
        changeBalanceWithdraw(user, amount);
    }

    @Override
    public void fund(User user, int amount) {
        //1. Проверить лимит
        //2. Пополнить
        if (!checkFunding(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        // Проверка на одну валюту
        // Проверка на снятие
        // Проверка на пополнение
        // снимаем деньги с fromUser
        // пополняем toUser

        if (!checkCurrency(fromUser, toUser, amount))
            return;

        if (!checkWithdraw(fromUser, amount))
            return;

        if (!checkFunding(toUser, amount))
            return;

        changeBalanceWithdraw(fromUser, amount);

        toUser.setBalance(toUser.getBalance() + amount);
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary());
    }

    // списание со счета суммы снятия + комиссия
    private void changeBalanceWithdraw (User user, int amount) {
        user.setBalance(user.getBalance() - amount * (1 + user.getBank().getCommission(amount)));
    }

    // проверка на совпадение валют счетов у клиентов
    private boolean checkCurrency (User user1, User user2, int amount) {
        if (user1.getBank().getCurrency() != user2.getBank().getCurrency()) {
            printTransferMoneyErrorMsg(user1, user2, amount);
            return false;
        }
        return true;

    }

    // проверки при пополнении счета
    private boolean checkFunding (User user, double amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            printFundingErrorMsg((int) amount, user);
            return false;
        }
        return true;
    }

    // Проверки при снятии со счета
    private boolean checkWithdraw (User user, int amount) {
        return  checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits (User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) { //c учетом комиссии
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    // Выносим в отдельный метод печать сообщения при невозмоности выдать сумму
    private void printWithdrawalErrorMsg(int amount, User user) {
        // в классе User переопределили метод toString
        System.err.println("Can't withdraw money " + amount + " from user" + user.toString());
    }

    //Сообщение о невозможности пополнить счет
    private void printFundingErrorMsg(int amount, User user) {
        System.err.println("Can't funding money " + amount + " to user" + user.toString());
    }

    //Сообщение о невозможности выполнить трансфер
    private void printTransferMoneyErrorMsg(User user1, User user2, int amount) {
        System.err.println("Can't transfer money " + amount + " from user " + user1.toString() + " to user " + user2.toString());
    }
}
