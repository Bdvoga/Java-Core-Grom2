package lesson9;

public class Employee {
    public static void main(String[] args) {
        Employee employee = new Employee("Nick", null, 2);
    }

    String name;
    Company company;
    int monthlySalary;

    public Employee(String name, Company company, int monthlySalary) {
        this.name = name;
        this.company = company;
        this.monthlySalary = monthlySalary;
    }
}
