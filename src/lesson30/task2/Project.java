package lesson30.task2;

import java.util.ArrayList;

public class Project {
    private String firstName; //Руководитель проекта
    private String lastName;
    private Customer customer;

    public Project(String firstName, String lastName, Customer customer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customer = customer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
