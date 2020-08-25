package lesson9;

import lesson9.utils.Checker;

import java.util.concurrent.Callable;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company("Oracl", "USA");
        //System.out.println(company.countryFound);
        System.out.println(company.getName());

        company.code = "NewValue";

        //company.name = "IBM";

        Checker checker = new Checker();
        //System.out.println(checker.checkCompanyName(company.name));
        //System.out.println(checker.companyNamesValidatedCount);
        
    }
}
