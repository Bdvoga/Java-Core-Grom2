package lesson10.abstractbigexample;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;

    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positionWorked = new String[10];

    abstract void paySalary();

    void changePosition(String newPosition) { // Изменение должностной позиции
        // 1. сохранить тек.позицию в историю
        // 2. поменять позицию
        // перенесли п.1 в метод saveCurPositionToHistory()
        saveCurPositionToHistory();
        curPosition = newPosition;
    }

    private void saveCurPositionToHistory() {
        int index = 0;
        for (String pos : positionWorked) {
            if (pos == null) {
                positionWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance() { // Возвращаем баланс на счете
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }
}
