package lesson30.task2.DAO;

import lesson30.task2.Controller;
import lesson30.task2.Department;
import lesson30.task2.ENAM.DepartmentType;

import java.util.ArrayList;

public class DepartmentDAO {
    private static ArrayList<Department> departments = new ArrayList<>();

    public static void fillDepartments() {
        Department depA = new Department(DepartmentType.A, EmployeeDAO.employeesFromDepartment(DepartmentType.A));
        Department depB = new Department(DepartmentType.B, EmployeeDAO.employeesFromDepartment(DepartmentType.B));


    }

    public static ArrayList<Department> getDepartments() {
        return departments;
    }
}
