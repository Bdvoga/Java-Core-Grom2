package lesson30.task1;

public class Demo {
    public static void main(String[] args) throws Exception {
        Bank usBank = new USBank(1222, "Sweden", Currency.USD, 100, 1400, 4, 434545334);
        User userUSBank1 = new User(1001, "Denis", 1000, 40, "AAA", 1500, usBank);
        User userUSBank2 = new User(1002, "Denis", 2000, 40, "AAA", 500, usBank);


        UkrainianBankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(userUSBank1, 150);
        bankSystem.fund(userUSBank1, 200);
        Thread.sleep(1000);
        bankSystem.withdraw(userUSBank1, 10);
        Thread.sleep(1000);
        bankSystem.transferMoney(userUSBank1, userUSBank2, 30);
        Thread.sleep(1000);
        bankSystem.paySalary(userUSBank1);

        System.out.println(bankSystem.getTransactions());
    }
}
