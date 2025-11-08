package student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StudentLogger {

    private final Object lock = new Object();
    private final String filePath = "students.csv";

    public void log(Student student) {
        synchronized (lock) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(student.toString());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
