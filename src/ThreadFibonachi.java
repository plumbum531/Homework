public class ThreadFibonachi {
    public static void main(String[] args) {
        new ThreadFibonachi().run();
    }

    void run() {
        int calculateNumber = 100;
        CountFibonachiNumber countFibonachiNumber = new CountFibonachiNumber(calculateNumber);
        Thread thread = new Thread(countFibonachiNumber);
        thread.start();
        try {
            thread.join();
            System.out.println("Result in main thread is " + countFibonachiNumber.result);
        } catch (InterruptedException e) {
            System.out.println("Calculatoin is interrupted" + e.getMessage());
        }
    }
}
