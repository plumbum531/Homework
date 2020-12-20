public class Point {
    int x;
    int y;
    private final Object lock = new Object();
    private final static Object lock1 = new Object();
    private Point point;


//    public synchronized void move(int dx, int dy){
//        x +=dx;
//        y +=dy;
//    }

//    public void move(int dx, int dy) {
//        synchronized (lock) {
//            x += dx;
//            y += dy;
//        }
//    }

//    public static synchronized void move(Point point, int dx, int dy) {
//        point.x += dx;
//        point.y += dy;
//    }

    public static void move(Point point, int dx, int dy) {
        synchronized (lock1) {
            point.x += dx;
            point.y += dy;
        }
    }
}
