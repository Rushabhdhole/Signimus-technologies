import java.io.*;
import java.util.Scanner;

// File Reader Utility
class FileReaderUtil {
    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

// Student class for Serialization and Deserialization
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    public static void serializeStudent(Student student, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(student);
            System.out.println("Student serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error serializing student: " + e.getMessage());
        }
    }

    public static Student deserializeStudent(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing student: " + e.getMessage());
            return null;
        }
    }
}

// Word Counter Program
class WordCounter {
    public static int countWords(String filePath) {
        int wordCount = 0;
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return wordCount;
    }
}

public class FileReaderUtilityApp {
    public static void main(String[] args) {
        String filePath = "sample.txt";

        // File Reader Utility
        System.out.println("Reading File:");
        FileReaderUtil.readFile(filePath);

        // Serialization and Deserialization
        Student student = new Student("John Doe", 20);
        String studentFile = "student.ser";
        Student.serializeStudent(student, studentFile);

        Student deserializedStudent = Student.deserializeStudent(studentFile);
        System.out.println("Deserialized Student: " + deserializedStudent);

        // Word Counter
        int wordCount = WordCounter.countWords(filePath);
        System.out.println("Word count in file: " + wordCount);
    }
}
