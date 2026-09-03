public class SequenceExample {
    private static final int THREAD_SLEEP_MS = 500;
    private static final Object monitor = new Object();
    private static boolean isThread1Turn = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    while (!isThread1Turn) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print("1 ");
                    isThread1Turn = false;
                    monitor.notifyAll();

                    try {
                        Thread.sleep(THREAD_SLEEP_MS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    while (isThread1Turn) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print("2 ");
                    isThread1Turn = true;
                    monitor.notifyAll();

                    try {
                        Thread.sleep(THREAD_SLEEP_MS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}