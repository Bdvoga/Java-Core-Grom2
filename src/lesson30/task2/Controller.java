package lesson30.task2;

import lesson30.task2.DAO.EmployeeDAO;
import lesson30.task2.DAO.ProjectDAO;
import lesson30.task2.ENAM.DepartmentType;
import lesson30.task2.ENAM.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controller {

    // список проектов, в которых участвует заданный сотрудник
    public static ArrayList<Project> projectsByEmployee(Employee employee) {
        ArrayList<Project> projects = new ArrayList<>();

        if (employee.getProjects() != null) {
            projects.addAll(employee.getProjects());
        }

        return projects;
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        ArrayList<Employee> employees = new ArrayList<>();

        for (Employee empl : EmployeeDAO.getEmployees()) {
            if (empl.getDepartment() == departmentType && empl.getProjects() == null) {
                employees.add(empl);
            }
        }

        return employees;
    }

    //список сотрудников, не участвующих ни в одном проекте
    public static ArrayList<Employee> employeesWithoutProject() {
        ArrayList<Employee> employees = new ArrayList<>();

        for (Employee empl : EmployeeDAO.getEmployees()) {
            if (empl.getProjects() == null) {
                employees.add(empl);
            }
        }

        return employees;
    }

    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public static Set<Employee> employeesByTeamLead(Employee lead) {
        Set<Employee> employees = new HashSet<>();

        for (Employee empl : EmployeeDAO.getEmployees()) {
            if (empl.getProjects() != null && empl.getPosition() != Position.TEAM_LEAD) {
                for (Project pr : empl.getProjects()) {
                    if (pr.getFirstName().equals(lead.getFirstName()) &&
                            pr.getLastName().equals(lead.getLastName())) {
                        employees.add(empl);
                    }
                }
            }
        }

        return employees;
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();

        int count = 0;
        if (employee.getProjects() != null) {
            for (Project pr : employee.getProjects()) {
                for (Employee empl : EmployeeDAO.getEmployees()) {
                    if (empl.getFirstName().equals(pr.getFirstName()) &&
                            empl.getLastName().equals(pr.getLastName()) &&
                            empl.getPosition() == Position.TEAM_LEAD) {
                        employees.add(EmployeeDAO.getEmployees().get(count));
                    }
                    count++;
                }
                count = 0;
            }
        }

        return employees;
    }

    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();

        int count = 0;
        if (employee.getProjects() != null) {
            for (Project pr : employee.getProjects()) {
                for (Employee empl : EmployeeDAO.getEmployees()) {
                    if (empl.getProjects() != null && !empl.equals(employee) && empl.getProjects().contains(pr)) {
                        employees.add(EmployeeDAO.getEmployees().get(count));
                    }
                    count++;
                }
                count = 0;
            }
        }

        return employees;
    }

    //список проектов, выполняемых для заданного заказчика
    public static ArrayList<Project> projectsByCustomer(Customer customer) {
        ArrayList<Project> projects = new ArrayList<>();

        for (Project pr : ProjectDAO.getProjects()) {
            if (pr.getCustomer().equals(customer)) {
                projects.add(pr);
            }
        }

        return projects;
    }

    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public static Set<Employee> employeesByCustomerProjects(Customer customer) {
        Set<Employee> employees = new HashSet<>();

        //массив проектов для заданного заказчика
        ArrayList<Project> projects = new ArrayList<>();
        for (Project pr : ProjectDAO.getProjects()) {
            if (pr.getCustomer().equals(customer))
                projects.add(pr);
        }
        if (projects.size() == 0)
            return employees;

        System.out.println(customer);
        System.out.println(projects);
        System.out.println();

        for (Employee empl : EmployeeDAO.getEmployees()) {
            if (empl.getProjects() != null) {
                for (Project pr : empl.getProjects()) {
                    if (projects.contains(pr)) {
                        System.out.println(empl);
                        employees.add(empl);
                    }
                }
            }
        }

        return employees;
    }

    //Собираем сотрудников одного отдела
    public static ArrayList<Employee> employeesFromDepartment(DepartmentType departmentType) {
        ArrayList<Employee> employees = new ArrayList<>();

        for (Employee empl : EmployeeDAO.getEmployees()) {
            if (empl.getDepartment() == departmentType) {
                employees.add(empl);
            }
        }

        return employees;
    }

}
