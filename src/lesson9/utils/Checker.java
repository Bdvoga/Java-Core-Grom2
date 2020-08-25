package lesson9.utils;

public class Checker {
    //области видимости в Java
    //public - доступно везде в рамках данного проекта
    //private - только внутри текущего класса
    //default (package-private) - доступно внутри текущего пакета
    //protected = default + наследники текущего класса

    //по областям доступа по возрастанию
    //private
    //default (package-private)
    //protected
    //public

    int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName) {
//        if (companyName == "Google" || companyName == "Amazon")
//            return false;
//        return true;
        if (companyNamesValidatedCount > 10)
            return false;

        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
