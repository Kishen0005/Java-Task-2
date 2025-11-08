package student;

public class StudentThread extends Thread {

    private final StudentLogger logger;
    private final Student student;

    public StudentThread(StudentLogger logger, Student student) {
        this.logger = logger;
        this.student = student;
    }

    @Override
    public void run() {
        logger.log(student);


        System.out.println("USN: " + student.getRollNumber() + "| Name: " 
                           + student.getName() + "| Marks: " 
                           + student.getMarks());
    }
}
