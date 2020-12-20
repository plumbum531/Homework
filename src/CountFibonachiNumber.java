import org.w3c.dom.ls.LSOutput;

public class CountFibonachiNumber extends Thread {
    private long number;
    private long previosNumber = 0;
    private long thisNumber = 1;
    public long result;

    public CountFibonachiNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        if (number > 0) {
            if (number == 0) {
                System.out.println(previosNumber);
            } else if (number == 1) {
                System.out.println(thisNumber);
            } else {
                System.out.println("0");
                System.out.println("1");
                for (int i = 2; i <= number; i++) {
                    if (!thread.isInterrupted()) {
                        result = previosNumber + thisNumber;
                        if (result > 0) {//защита от переполнения
                            System.out.println(result);
                            previosNumber = thisNumber;
                            thisNumber = result;
                        } else {
                            System.out.println("Stack overflow");
                            System.out.println("Breack at cicle is " + i);
                            System.out.println("Fibonachi number is " + (i - 1) + " " + thisNumber);
                            result = thisNumber;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            System.out.println("Negative number. Can not calculate.");
        }
    }
}
