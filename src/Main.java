import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Point point = new Point();
        Collection<Task> taskList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2000);
        for(int i = 0; i<2000; i++){
            taskList.add(new Task(point));
        }
        System.out.println(taskList.size());
        try {
            executor.invokeAll(taskList);
            System.out.println("x" + point.x + ", y " + point.y);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

    }
}
