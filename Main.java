package student;

public class Main {
    public static void main(String[] args) {
        StudentLogger logger = new StudentLogger();

        Thread t1 = new StudentThread(logger, new Student("Chaman", 101, 83));
        Thread t2 = new StudentThread(logger, new Student("Baman", 202, 92));
        Thread t3 = new StudentThread(logger, new Student("Raman", 143, 70));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All students submitted their marks.");
    }
}
