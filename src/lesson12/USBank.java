package lesson12;

//import java.util.Currency;

public class USBank extends Bank {

    public USBank(long id, String bankCountry, lesson12.Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    // limit of withdrawal = 1000 if currency is USD and 1200 if currency is EUR
    @Override
    public int getLimitOfWithdrawal() {
        return getCurrency() == Currency.EUR ? 1200 : 1000;
    }

    // limit of funding - 10000 if EUR and no limit if USD
    @Override
    public int getLimitOfFunding() {
        return getCurrency() == Currency.EUR ? 10000 : Integer.MAX_VALUE; // без лимита, устанавливает макс значение int
    }

    // monthly rate - 1% with USD and 2% with EUR
    @Override
    public double getMonthlyRate() {
        return getCurrency() == Currency.EUR ? 0.02 : 0.01;
    }

    // commision - 5% if USD and up to 1000, 7% if USD and more than 1000
    // commision - 6% if EUR and up to 1000 and 8% if EUR and more than 1000
    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.05;
            else
                return 0.07;
        } else {
            if (amount <= 1000)
                return 0.06;
            else
                return 0.08;
        }
    }
}
