package lesson14;

public class Test implements Cloneable { //имплементим интерфес Cloneable для работы clone
    private int someNumber;
    private String name;

    public Test(int someNumber, String name) {
        this.someNumber = someNumber;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException { // переопределяем метод clone
        return super.clone(); // вызываем метод clone из Object. Метод без реализации, реализация в другом месте
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test(10000, "name");
        System.out.println(test);
        System.out.println(test.hashCode());

        Test test1 = (Test) test.clone();
        System.out.println(test1);
        System.out.println(test1.hashCode());

        Test test2 = new Test(test.getSomeNumber(), test.getName()); // Можно создать копию test по другому
    }

    public int getSomeNumber() { // Для создания test2 from test
        return someNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() { // переопределяем toString для вывода на печать <Alt> + <Insert>
        return "Test{" +
                "someNumber=" + someNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
