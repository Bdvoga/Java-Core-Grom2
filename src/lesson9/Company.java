package lesson9;

public class Company {
    public static void main(String[] args) {
        Company company = new Company("Oracl", "USA");
    }
    private String name;
    private String countryFound;

    protected String code;

    public int someField;

    public Company(String name, String countryFound) {
        this.name = name;
        this.countryFound = countryFound;
    }

    // Getter and Setter for name, Setter удалили в ходе разбора
    public String getName() {
        return name;
    }

    // Getter and Setter for getCountryFound
    public String getCountryFound() {
        return countryFound;
    }

    public void setCountryFound(String countryFound) {
        this.countryFound = countryFound;
    }
}
