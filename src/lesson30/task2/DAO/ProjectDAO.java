package lesson30.task2.DAO;

import lesson30.task2.DAO.CustomerDAO;
import lesson30.task2.Project;

import java.util.ArrayList;

public class ProjectDAO {
    private static ArrayList<Project> projects = new ArrayList<>();

    public static void fillProjects() {
        Project project1 = new Project("fName6", "lName6", CustomerDAO.getCustomers().get(0));
        Project project2 = new Project("fName6", "lName6", CustomerDAO.getCustomers().get(1));
        Project project3 = new Project("fName6", "lName6", CustomerDAO.getCustomers().get(2));
        Project project4 = new Project("fName7", "lName7", CustomerDAO.getCustomers().get(0));
        Project project5 = new Project("fName8", "lName8", CustomerDAO.getCustomers().get(0));

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        projects.add(project5);
    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }
}
