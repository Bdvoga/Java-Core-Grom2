package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.USD, 100, 1400, 4, 434545334);
        Bank euBank = new EUBank(2333, "Italy", Currency.EUR, 200, 1900,6, 836738989);
        Bank chBank = new ChinaBank(3444, "Chine", Currency.EUR, 250, 2500, 2, 7489264);

        User userUSBank1 = new User(1001, "Denis", 1000, 40, "AAA", 1500, usBank);
        User userUSBank2 = new User(1002, "Richard", 2000, 50, "BBB", 2000, usBank);
        User userEUBank1 = new User(2001, "Ben", 3000, 30, "CCC", 2500, euBank);
        User userEUBank2 = new User(2002, "Tom", 4000, 35, "DDD", 3000, euBank);
        User userChinaBank1 = new User(3001, "Huang", 5000, 10, "EEE", 200, chBank);
        User userChinaBank2 = new User(3002, "Tin", 6000, 20, "III", 300, chBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.withdraw(userUSBank1, 100);
        System.out.println(userUSBank1.getBalance());
        bankSystem.fund(userUSBank2, 2000);
        System.out.println(userUSBank2.getBalance());
        System.out.println();

        bankSystem.fund(userEUBank1, 200);
        System.out.println(userEUBank1.getBalance());
        bankSystem.paySalary(userEUBank2);
        System.out.println(userEUBank2.getBalance());
        System.out.println();

        bankSystem.transferMoney(userChinaBank1, userEUBank1, 100);
        System.out.println(userChinaBank1.getBalance());
        bankSystem.withdraw(userChinaBank2, 100);
        System.out.println(userChinaBank2.getBalance());
        System.out.println();
    }
}
