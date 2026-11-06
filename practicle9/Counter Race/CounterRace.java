// Demonstrates a race condition and its synchronized solution
class CounterRace {
 
    // Shared counter accessed by all threads
    static int counter = 0;
    // Number of concurrent threads
    static final int THREADS = 10;
    // Number of increments performed by each thread
    static final int INCREMENTS = 100000;
 
    // Increment without synchronization
    // Unsafe increment: multiple threads may overwrite each other's updates
    static void increment() {
        counter++;
    }
 
    // Increment with synchronization
    // Synchronized increment: only one thread can update the counter at a time
    static synchronized void incrementSync() {
        counter++;
    }
 
    public static void main(String[] args) throws InterruptedException {
 
        // Test 1: booking without synchronization
        counter = 0;
 
        Thread[] threads = new Thread[THREADS];
 
        // Create and start threads for the unsynchronized test
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    increment();
                }
            });
 
            threads[i].start();
        }
 
        // Wait until all threads finish before displaying the result
        for (Thread t : threads) {
            t.join();
        }
 
        System.out.println("Expected Counter: " + (THREADS * INCREMENTS));
        System.out.println("Without Synchronization: " + counter);
 
        // Test 2: booking with synchronization
        counter = 0;
 
        // Create and start threads for the unsynchronized test
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    incrementSync();
                }
            });
 
            threads[i].start();
        }
 
        // Wait until all threads finish before displaying the result
        for (Thread t : threads) {
            t.join();
        }
 
        System.out.println("With Synchronization: " + counter);
    }
}
