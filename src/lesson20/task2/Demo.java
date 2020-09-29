package lesson20.task2;

import lesson20.task2.exception.LimitExceeded;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        Transaction trNew1 = new Transaction(101, "Kiev", 30, "XXX", TransactionType.INCOME, new Date());
        Transaction trNew2 = new Transaction(102, "Donetsk", 10, "YYY", TransactionType.OUTCOME, new Date());

        TransactionDAO.fillingTransaction();

        System.out.println(TransactionDAO.save(trNew1).getId());
        System.out.println();
        //System.out.println(TransactionDAO.save(trNew2).getId());

        TransactionDAO.transactionList();
        System.out.println();

        TransactionDAO.transactionList("Kiev");
        System.out.println();

        TransactionDAO.transactionList(3);

    }
}
