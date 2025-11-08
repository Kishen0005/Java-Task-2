package test;
import student.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.*;

public class StudentLoggerTest {

    private StudentLogger logger;
    private final String filePath = "students.csv";

    @BeforeEach
    public void setup() throws IOException {
        logger = new StudentLogger();
        new FileWriter(filePath, false).close(); // clear file
    }

    @Test
    public void testFileWrite() throws Exception {
        Student s = new Student("TestUser", 999, 77);
        logger.log(s);

        List<String> lines = new BufferedReader(new FileReader(filePath))
                .lines().collect(Collectors.toList());

        assertTrue(lines.contains("TestUser,999,77"));
    }

    @Test
    public void testThreadCompletion() throws InterruptedException, IOException {
        Student s1 = new Student("A", 1, 50);
        Student s2 = new Student("B", 2, 60);

        Thread t1 = new StudentThread(logger, s1);
        Thread t2 = new StudentThread(logger, s2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        List<String> lines = new BufferedReader(new FileReader(filePath))
                .lines().collect(Collectors.toList());

        assertEquals(2, lines.size());
    }
}
