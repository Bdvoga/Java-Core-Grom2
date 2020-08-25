package lesson8.ex2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Course course = new Course(null, "Math", 10, "Tom", null);

    }

    public Student createHighestParent() {
        Student student = new Student("A", "B", 1, null);
        return student;
    }

    public SpecialStudent createLowestChild() {
        SpecialStudent specialStudent = new SpecialStudent("A", "B", 1, null, 123456, "1@1.com");
        return specialStudent;
    }
}



