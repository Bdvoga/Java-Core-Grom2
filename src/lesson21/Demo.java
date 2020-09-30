package lesson21;

public class Demo {
    public static void main(String[] args) throws Exception {
        Company company = new Company(100, "Nokia");
        //company.setLicense("GTP9999"); // вызываем через объек, кот создали выше
        Company.setLicense("GTP9999"); // статические методы можно вызвать без создания объекта


        System.out.println(company.getLicense());

        Company company1 = new Company(9, "Test");

        System.out.println(company1.getLicense());

        company.setLicense("TTT111");

        System.out.println(company.getLicense());
        System.out.println(company1.getLicense());

        Company.validate();

        //demo utils

//        ArrayUtils arrayUtils = new ArrayUtils(); //так писать плохо, нужно использовать статик
//        arrayUtils.minElement();

        int min = ArrayUtils.minElement(new int[] {1, 10, 40});

    }
}
