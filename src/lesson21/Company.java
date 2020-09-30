package lesson21;

public class Company {
    private int numberOfEmployees;
    private String name;

    private static String license;

    private static int maxNumberOfEmployees = 100;

    public Company(int numberOfEmployees, String name) throws Exception {
        if (numberOfEmployees > maxNumberOfEmployees) {
            throw new Exception("Company can have max " + maxNumberOfEmployees + " employees");
        }
        this.numberOfEmployees = numberOfEmployees;
        this.name = name;
    }

    public static void validate() throws Exception{
        if (!license.equals("TTT111"))
            throw new Exception("Wrong license" + license);
    }

    public static void setLicense(String license) {
        Company.license = license;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }
}
