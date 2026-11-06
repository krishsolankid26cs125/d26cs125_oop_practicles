// Demonstrates task execution and worker-thread reuse with ExecutorService
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
 
public class ThreadPoolRunner {
 
    public static void main(String[] args) {
 
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
 
        // Submit 10 tasks to the thread pool
        for (int i = 1; i <= 10; i++) {
 
            final int taskId = i;
 
            Runnable task = () -> {
                System.out.println("Task " + taskId +
                        " is running on " +
                        Thread.currentThread().getName());
 
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task interrupted");
                }
 
                System.out.println("Task " + taskId + " completed");
            };
 
            executor.submit(task);
        }
 
        // Stop accepting new tasks
        executor.shutdown();
 
        try {
            // Wait for all submitted tasks to finish
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All tasks completed successfully.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Executor interrupted.");
        }
    }
}
