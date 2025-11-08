Student Exam Score Logger (Java)

A simple multi-threaded Java program where multiple students submit their exam scores at the same time. Each student runs in a separate thread, and the scores are saved safely into a CSV file using synchronization.
JUnit test cases are included to verify file writing and thread completion.

--> Features:

- Multi-threaded student score submission

- Thread-safe file writing using synchronized

- Simple CSV storage (students.csv)

- JUnit 5 test cases

- Easy, clean code for learning threads & I/O

--> Project Structure:

student/
│── Main.java
│── Student.java
│── StudentLogger.java
│── StudentThread.java
test/
│── StudentLoggerTest.java
students.csv   (created at runtime)
