package lesson22.onlineWallet;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        Transaction trNew1 = new Transaction(101, "Kiev", 30, "XXX", TransactionType.INCOME, new Date());
        Transaction trNew2 = new Transaction(102, "Donetsk", 10, "YYY", TransactionType.OUTCOME, new Date());

        TransactionDAO.fillingTransaction();

        System.out.println(TransactionDAO.save(trNew1).getId());
        System.out.println();
        //System.out.println(TransactionDAO.save(trNew2).getId());

        //transactionList()
        for (Transaction el : TransactionDAO.transactionList()) {
            System.out.println(el.getId() + " " + el.getCity() + " " + el.getAmount() +
                    " " + el.getDescription() + " " + el.getType() + " " + el.getDateCreated());
        }
        System.out.println();

        //transactionList(String city)
        for (Transaction el : TransactionDAO.transactionList("Kiev")) {
            System.out.println(el.getId() + " " + el.getCity() + " " + el.getAmount() +
                    " " + el.getDescription() + " " + el.getType() + " " + el.getDateCreated());
        }
        System.out.println();

        //transactionList(int amount)
        for (Transaction el : TransactionDAO.transactionList(3)) {
            System.out.println(el.getId() + " " + el.getCity() + " " + el.getAmount() +
                    " " + el.getDescription() + " " + el.getType() + " " + el.getDateCreated());
        }
    }
}
