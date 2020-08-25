package lesson10.abstractbigexample;

public class ManagerEmployee extends Employee{ //Еще один тип сотрудника

    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth();
        newBalance += newBalance * 0.25;
        getBankAccount().setBalance(newBalance);
    }
}
