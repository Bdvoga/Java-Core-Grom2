package lesson30.task2.DAO;

import lesson30.task2.Customer;
import lesson30.task2.ENAM.DepartmentType;
import lesson30.task2.Employee;
import lesson30.task2.ENAM.Position;
import lesson30.task2.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
