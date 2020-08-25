package lesson10.abstractbigexample;

public class DeveloperEmployee extends Employee{ //Другой тип сотрудника - разраб
    private String[] frameworks = new String[10]; //Умения работника

    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth() + 1000;
        getBankAccount().setBalance(newBalance);
    }
}
