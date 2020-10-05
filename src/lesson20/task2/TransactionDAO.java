package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public void fillingTransaction() {
        Transaction tr1 = new Transaction(1, "Kiev", 3, "A", TransactionType.INCOME, new Date());
        Transaction tr2 = new Transaction(2, "Odessa", 3, "B", TransactionType.INCOME, new Date());
        Transaction tr3 = new Transaction(3, "Kiev", 30, "C", TransactionType.INCOME, new Date());
        Transaction tr4 = new Transaction(4, "Odessa", 30, "D", TransactionType.INCOME, new Date());
        Transaction tr5 = new Transaction(4, "Odessa", 30, "D", TransactionType.INCOME, new Date());
        transactions[0] = tr1;
        transactions[1] = tr2;
        transactions[2] = tr3;
        transactions[3] = tr4;
        transactions[4] = tr5;
    }

    public Transaction save(Transaction transaction) throws Exception {
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

    private void validate(Transaction transaction) throws Exception {
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
        if (!Arrays.asList(utils.getCities()).contains(transaction.getCity())) {
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

    public Transaction[] transactionList() {
        // определяем кол-во ненулевых элементов = длина возвращаемого массива
        int count = 0;
        for (Transaction el : transactions) {
            if (el != null)
                count++;
        }

        Transaction[] trans = new Transaction[count];

        int count1 = 0;
        for (Transaction el : transactions) {
            if (el != null) {
                trans[count1] = el;
                count1++;
            }
        }

        return trans;
    }

    public Transaction[] transactionList(String city) {
        // определяем кол-во элементов city = длина возвращаемого массива
        int count = 0;
        for (Transaction el : transactions) {
            if (el != null && el.getCity().equals(city))
                count++;
        }

        Transaction[] trans = new Transaction[count];

        int count1 = 0;
        for (Transaction el : transactions) {
            if (el != null && el.getCity().equals(city)) {
                trans[count1] = el;
                count1++;
            }
        }
        return trans;
    }

    public Transaction[] transactionList(int amount) {
        // определяем кол-во элементов amount = длина возвращаемого массива
        int count = 0;
        for (Transaction el : transactions) {
            if (el != null && el.getAmount() == amount)
                count++;
        }

        Transaction[] trans = new Transaction[count];

        int count1 = 0;
        for (Transaction el : transactions) {
            if (el != null && el.getAmount() == amount) {
                trans[count1] = el;
                count1++;
            }
        }
        return trans;
    }

    // Поиск транзакций за текущий день
    // Метод сами не пишем, тк не умеем работать с датами, используем уже готовый
    private Transaction[] getTransactionsPerDay(Date DateOfCurTransaction) {
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
