package lesson12;

public class EUBank extends Bank{

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    //limit of withdrawal = 2000 if currency is USD and 2200 if currency is EUR
    @Override
    public int getLimitOfWithdrawal() {
        return getCurrency() == Currency.EUR ? 2200 : 2000;
    }

    // limit of funding - 20000 if EUR and 10000 if USD
    @Override
    public int getLimitOfFunding() {
        return getCurrency() == Currency.EUR ? 20000 : 10000;
    }

    //monthly rate - 0% with USD and 1% with EUR
    @Override
    public double getMonthlyRate() {
        return getCurrency() == Currency.EUR ? 0.01 : 0;
    }

    // commision - 5% if USD and up to 1000, 7% if USD and more than 1000
    // commision - 2% if EUR and up to 1000 and 4% if EUR and more than 1000
    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.05;
            else
                return 0.07;
        } else {
            if (amount <= 1000)
                return 0.02;
            else
                return 0.04;
        }
    }
}
