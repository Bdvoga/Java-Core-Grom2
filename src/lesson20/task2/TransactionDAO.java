package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];

    public static void fillingTransaction() {
        Transaction tr1 = new Transaction(1, "Kiev", 3, "A", TransactionType.INCOME, new Date());
        Transaction tr2 = new Transaction(2, "Odessa", 3, "B", TransactionType.INCOME, new Date());
        Transaction tr3 = new Transaction(3, "Kiev", 30, "C", TransactionType.INCOME, new Date());
        Transaction tr4 = new Transaction(4, "Odessa", 30, "D", TransactionType.INCOME, new Date());
        transactions[0] = tr1;
        transactions[1] = tr2;
        transactions[2] = tr3;
        transactions[3] = tr4;
    }

    private static Utils utils = new Utils();

    public static Transaction save(Transaction transaction) throws Exception {
//        1. сумма транзакции больше указанного лимита +
//        2. сумма транзакций за день больше дневного лимита +
//        3. количество транзакций за день больше указанного лимита +
//        4. если город оплаты (совершения транзакции) не разрешен
//        5. не хватило места

        validate(transaction);

        int count = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
                return transactions[i];
            }
        }

        throw new InternalServerException("Unexpected error");
    }

    private static void validate(Transaction transaction) throws Exception {
        // 1.
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        // 2. 3.
        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");
        }

        if (count >= utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
        }

        // 4.
        count = 0;
        for (String el : utils.getCities()) {
            if (el.equals(transaction.getCity())) {
                count = 1;
                break;
            }
        }

        if (count == 0) {
            throw new BadRequestException("Transaction " + transaction.getId() + " to/from this city can't be saved");
        }

        // 5.
        for (Transaction tr : transactions) {
            if (tr == null) {
                return;
            }
        }

        throw new InternalServerException("Not enough free space " + transaction.getId() + ". Can't be saved");
    }

    public static void transactionList() {
        for (Transaction tr : transactions) {
            if (tr != null) {
                System.out.println(tr.getId() + " " + tr.getCity() + " " + tr.getAmount() +
                        " " + tr.getDescription() + " " + tr.getType() + " " + tr.getDateCreated());
            }
        }
    }

    public static void transactionList(String city) {
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                System.out.println(tr.getId() + " " + tr.getCity() + " " + tr.getAmount() +
                        " " + tr.getDescription() + " " + tr.getType() + " " + tr.getDateCreated());
            }
        }
    }

    public static void transactionList(int amount) {
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                System.out.println(tr.getId() + " " + tr.getCity() + " " + tr.getAmount() +
                        " " + tr.getDescription() + " " + tr.getType() + " " + tr.getDateCreated());
            }
        }


    }

    // Поиск транзакций за текущий день
    // Метод сами не пишем, тк не умеем работать с датами, используем уже готовый
    private static Transaction[] getTransactionsPerDay(Date DateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }
}
