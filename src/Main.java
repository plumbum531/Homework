import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Point point = new Point();
        ExecutorService executor = Executors.newFixedThreadPool(2000);

        for (int i = 0; i < 2000; i++) {
            executor.submit(new Task(point));
        }
        try {
            executor.awaitTermination(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();

        }
        System.out.println("x=" + point.x + ", y=" + point.y);
    }
}
