package lesson30.task2;

import lesson30.task2.DAO.*;
import lesson30.task2.ENAM.DepartmentType;

public class Demo {
    public static void main(String[] args) throws Exception {
        // Создаем данные
        CustomerDAO.fillCustomers();
        ProjectDAO.fillProjects();
        EmployeeDAO.fillEmployees();
        DepartmentDAO.fillDepartments();
        FirmDAO.fillFirm();

        System.out.println("projectsByEmployee");
        System.out.println(EmployeeDAO.projectsByEmployee(EmployeeDAO.getEmployees().get(3)));
        System.out.println();

        System.out.println("employeesByDepartmentWithoutProject");
        System.out.println(EmployeeDAO.employeesByDepartmentWithoutProject(DepartmentType.B));
        System.out.println();

        System.out.println("employeesWithoutProject");
        System.out.println(EmployeeDAO.employeesWithoutProject());
        System.out.println();

        System.out.println("employeesByTeamLead");
        System.out.println(EmployeeDAO.employeesByTeamLead(EmployeeDAO.getEmployees().get(5)));
        System.out.println();

        System.out.println("teamLeadsByEmployee");
        System.out.println(EmployeeDAO.teamLeadsByEmployee(EmployeeDAO.getEmployees().get(2)));
        System.out.println();

        System.out.println("employeesByProjectEmployee");
        System.out.println(EmployeeDAO.employeesByProjectEmployee(EmployeeDAO.getEmployees().get(0)));
        System.out.println();

        System.out.println("projectsByCustomer");
        System.out.println(EmployeeDAO.projectsByCustomer(CustomerDAO.getCustomers().get(1)));
        System.out.println();

        System.out.println("employeesByCustomerProjects");
        System.out.println(EmployeeDAO.employeesByCustomerProjects(CustomerDAO.getCustomers().get(3)));
        System.out.println();
    }
}
