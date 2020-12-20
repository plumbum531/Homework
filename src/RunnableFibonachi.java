import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableFibonachi {
    public static void main(String[] args) {
        new RunnableFibonachi().run();
    }

    void run() {
        int calculateNumber = 100;
        CountRunnableFibonachiNumber counter = new CountRunnableFibonachiNumber(calculateNumber);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(counter);

        try {
            executorService.awaitTermination(200, TimeUnit.MILLISECONDS);
            System.out.println("Result is = " + counter.result);
        } catch (InterruptedException e) {
            System.out.println("Calculation is interrapted" + e.getMessage());
        }finally{
            executorService.shutdown();
        }
    }
}
