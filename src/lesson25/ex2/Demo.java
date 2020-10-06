package lesson25.ex2;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();

        generalDAO.save("abc");
        generalDAO.save("test1");
        generalDAO.save("test2");
        generalDAO.save("test3");
        generalDAO.save("test4");
        generalDAO.save("test5");
        //generalDAO.save("test6");
        //generalDAO.save("test7");
        //generalDAO.save("111");

        generalDAO.save(1234);

        generalDAO.save(false);

        User user1 = new User(1, "Vasya");
        generalDAO.save(user1);

        System.out.println(Arrays.deepToString(generalDAO.getAll()));

        for (Object el : generalDAO.getAll()) {
            if (el != null) {
                System.out.println(el.toString());
            }
        }
    }
}