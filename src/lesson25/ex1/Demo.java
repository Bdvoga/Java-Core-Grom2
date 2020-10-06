package lesson25.ex1;

public class Demo {

    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();

        Order order = new Order(2);
        generalDAO.validate(order);

        TestClass<String, Order, Long> testClass = new TestClass<>();
        System.out.println(testClass.doSomething("rrr"));

        // Классы обертки
        //long - Long
        //int - Int
        //short - Short

        long variable = 111;

        Long variable2 = new Long(222);

        generalDAO.validate(variable2);

        generalDAO.validate(variable); // автоматическое приведение к типу объекта

    }
}
