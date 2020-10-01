package lesson22.onlineWallet;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    Transaction[] transactionList() {

        return null;
    }

    Transaction[] transactionList(String city) {


        return null;
    }

    Transaction[] transactionList(int amount) {


        return null;
    }

}
