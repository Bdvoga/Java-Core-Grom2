package lesson11.interfaceexampl;

public class PostgreSQLDbProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic for postgres
    }

    @Override
    public void disconnectFromDb() {
        //some logic for postgres
    }


    @Override
    public void encrytpData() {
        //some logic for postgres
    }
}
