package lesson12;

public class ChinaBank extends Bank{

    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    //limit of withdrawal = 100 if currency is USD and 150 if currency is EUR
    @Override
    public int getLimitOfWithdrawal() {
        return getCurrency() == Currency.EUR ? 150 : 100;
    }

    // limit of funding - 5000 if EUR and 10000 if USD
    @Override
    public int getLimitOfFunding() {
        return getCurrency() == Currency.EUR ? 5000 : 10000;
    }

    //monthly rate - 1% with USD and 0% with EUR
    @Override
    public double getMonthlyRate() {
        return getCurrency() == Currency.EUR ? 0.01 : 0;
    }

//    commision - 3% if USD and up to 1000, 5% if USD and more than 1000
//            10% if EUR and up to 1000 and 11% if EUR and more than 1000

    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.03;
            else
                return 0.05;
        } else {
            if (amount <= 1000)
                return 0.10;
            else
                return 0.11;
        }
    }
}
