import java.util.Collection;
import java.util.concurrent.Callable;

public class Task implements Runnable {
    private Point point;

    public Task(Point point){
        this.point = point;
    }

    public void run() {
        //point.move(1, 1);
        point.move(point, 1, 1);
    }

}
