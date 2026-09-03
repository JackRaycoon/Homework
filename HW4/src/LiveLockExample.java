import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample {
    private static final int THREAD_SLEEP_MS = 100;
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    if (lock1.tryLock()) {
                        try {
                            System.out.println("Thread 1: Locked lock1");
                            Thread.sleep(THREAD_SLEEP_MS);

                            if (lock2.tryLock()) {
                                try {
                                    System.out.println("Thread 1: Locked both locks: SUCCESS!");
                                    return;
                                } finally {
                                    lock2.unlock();
                                }
                            } else {
                                System.out.println("Thread 1: Can't lock lock2, releasing lock1");
                            }
                        } finally {
                            lock1.unlock();
                        }
                    }
                    Thread.sleep(THREAD_SLEEP_MS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    if (lock2.tryLock()) {
                        try {
                            System.out.println("Thread 2: Locked lock2");
                            Thread.sleep(THREAD_SLEEP_MS);

                            if (lock1.tryLock()) {
                                try {
                                    System.out.println("Thread 2: Locked both locks: SUCCESS!");
                                    return;
                                } finally {
                                    lock1.unlock();
                                }
                            } else {
                                System.out.println("Thread 2: Can't lock lock1, releasing lock2");
                            }
                        } finally {
                            lock2.unlock();
                        }
                    }
                    Thread.sleep(THREAD_SLEEP_MS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}