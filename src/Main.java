import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Point point = new Point();
        Collection<Task> taskList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2000);

        try {
            for (int i = 0; i < 2000; i++) {
                executor.submit(new Task(point));
            }
            Thread.sleep(200);

            System.out.println("x" + point.x + ", y " + point.y);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}
