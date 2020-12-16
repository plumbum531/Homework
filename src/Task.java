import java.util.Collection;
import java.util.concurrent.Callable;

public class Task implements Callable<Object> {
    private Point point;

    public Task(Point point){
        this.point = point;
    }

    public Object call() {
        point.move(1, 1);
        return null;
    }

}
