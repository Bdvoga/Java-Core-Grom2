package lesson30.task2.DAO;

import lesson30.task2.ENAM.DepartmentType;
import lesson30.task2.Employee;
import lesson30.task2.ENAM.Position;
import lesson30.task2.Project;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeDAO {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void fillEmployees() {

        ArrayList<Project> pr1 = new ArrayList<>(); // 1-й набор проектов
        pr1.add(ProjectDAO.getProjects().get(0));
        ArrayList<Project> pr2 = new ArrayList<>(); // 2-й набор проектов
        pr2.add(ProjectDAO.getProjects().get(0));
        pr2.add(ProjectDAO.getProjects().get(1));
        ArrayList<Project> pr3 = new ArrayList<>(); // 3-й набор проектов
        pr3.add(ProjectDAO.getProjects().get(0));
        pr3.add(ProjectDAO.getProjects().get(1));
        pr3.add(ProjectDAO.getProjects().get(2));
        ArrayList<Project> pr4 = new ArrayList<>(); // 4-й набор проектов
        pr4.add(ProjectDAO.getProjects().get(3));

        Employee empl1 = new Employee("fName1", "lName1", new Date(), Position.ANALYST, DepartmentType.A, pr1);
        Employee empl2 = new Employee("fName2", "lName2", new Date(), Position.DESIGNER, DepartmentType.A, pr1);
        Employee empl3 = new Employee("fName3", "lName3", new Date(), Position.FINANCE, DepartmentType.B, pr2);
        Employee empl4 = new Employee("fName4", "lName4", new Date(), Position.FINANCE, DepartmentType.B, null);
        Employee empl5 = new Employee("fName5", "lName5", new Date(), Position.DEVELOPER, DepartmentType.C, pr4);
        Employee empl6 = new Employee("fName6", "lName6", new Date(), Position.TEAM_LEAD, DepartmentType.C, pr3);
        Employee empl7 = new Employee("fName7", "lName7", new Date(), Position.TEAM_LEAD, DepartmentType.C, pr3);
        Employee empl8 = null;

        employees.add(empl1);
        employees.add(empl2);
        employees.add(empl3);
        employees.add(empl4);
        employees.add(empl5);
        employees.add(empl6);
        employees.add(empl7);

    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
