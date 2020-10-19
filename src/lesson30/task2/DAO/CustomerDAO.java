package lesson30.task2.DAO;

import lesson30.task2.Customer;

import java.util.ArrayList;

public class CustomerDAO {
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void fillCustomers() {
        Customer cust1 = new Customer("Tom", "Cruz", "USA", 10);
        Customer cust2 = new Customer("Sandra", "Bullok", "USA", 15);
        Customer cust3 = new Customer("Djeck", "Nikolson", "USA", 20);
        Customer cust4 = new Customer("Test1", "Test2", "Peru", 100);
        Customer cust5 = null;

        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
        customers.add(cust5);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
