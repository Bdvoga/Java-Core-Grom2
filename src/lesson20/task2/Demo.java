package lesson20.task2;

import lesson20.task2.exception.LimitExceeded;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        TransactionDAO transactionDAO = new TransactionDAO();

        Transaction trNew1 = new Transaction(101, "Kiev", 40, "XXX", TransactionType.INCOME, new Date());
        Transaction trNew2 = new Transaction(102, "Donetsk", 10, "YYY", TransactionType.OUTCOME, new Date());

        transactionDAO.fillingTransaction();

        System.out.println(transactionDAO.save(trNew1).getId());
        System.out.println();
        //System.out.println(TransactionDAO.save(trNew2).getId());

        //transactionList()
        for (Transaction el : transactionDAO.transactionList()) {
            System.out.println(el.getId() + " " + el.getCity() + " " + el.getAmount() +
                    " " + el.getDescription() + " " + el.getType() + " " + el.getDateCreated());
        }
        System.out.println();

        //transactionList(String city)
        for (Transaction el : transactionDAO.transactionList("Kiev")) {
            System.out.println(el.getId() + " " + el.getCity() + " " + el.getAmount() +
                    " " + el.getDescription() + " " + el.getType() + " " + el.getDateCreated());
        }
        System.out.println();

        //transactionList(int amount)
        for (Transaction el : transactionDAO.transactionList(3)) {
            System.out.println(el.getId() + " " + el.getCity() + " " + el.getAmount() +
                    " " + el.getDescription() + " " + el.getType() + " " + el.getDateCreated());
        }
    }
}