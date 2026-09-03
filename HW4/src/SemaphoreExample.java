import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final int THREAD_SLEEP_MS = 500;
    private static final Semaphore semaphore1 = new Semaphore(1);
    private static final Semaphore semaphore2 = new Semaphore(0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    semaphore1.acquire();
                    System.out.print("1 ");
                    Thread.sleep(THREAD_SLEEP_MS);
                    semaphore2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                semaphore2.acquire();
                System.out.print("2 ");
                Thread.sleep(THREAD_SLEEP_MS);
                semaphore1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}