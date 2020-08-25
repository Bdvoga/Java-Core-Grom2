package lesson8.accounts;

public class SavingAccount extends Account { // Сберегательный акк, на кото. преводим ежемес. сумму
    int savingPerMonth;
    int savings; // общая сумма на счете

    public SavingAccount(String bankName, String ownerName, int moneyAmount, int savingPerMonth) {
        super(bankName, ownerName, moneyAmount);
        this.savingPerMonth = savingPerMonth;
    }

    // метод тот же, что и в классе Account, но реализация его немного другая
    // это и есть переопределение методов
    // Мы взяли метод из класса Аккаунт и перезаписали его
    @Override
    // Аннотация, в данном примере ничего не делает, просто обращает наше внимание,
    // что метод переопределен.
    // Появилась голубая кнопка, перебрасывет нас на оригинальный метод
    void changeOwnerName(String newOwnerName) {
        if (newOwnerName == "Jack" || newOwnerName == "Ann")
            ownerName = newOwnerName;
        else
            System.out.println("Sorry, you can't change owner name of this saving account");
    }

}
