class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Student extends Person {
    private String studentId;
    private String course;

    public Student(String name, int age, String studentId, String course) {
        super(name, age);
        this.studentId = studentId;
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", Course: " + course;
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 20, "S12345", "Computer Science");
        System.out.println(student);
    }
}
