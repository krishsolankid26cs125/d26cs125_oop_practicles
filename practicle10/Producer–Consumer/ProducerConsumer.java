// Demonstrates producer-consumer coordination using a shared bounded buffer
import java.util.LinkedList;
import java.util.Queue;
 
class SharedBuffer {
 
    // Shared FIFO buffer with a fixed capacity
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;
 
    // Producer adds items to the buffer
    public synchronized void produce(int item) throws InterruptedException {
 
        // Wait while the buffer is full
        while (buffer.size() == capacity) {
            wait();
        }
 
        buffer.add(item);
        System.out.println("Produced: " + item);
 
        // Notify the consumer that an item is available
        notify();
    }
 
    // Consumer removes items from the buffer
    public synchronized int consume() throws InterruptedException {
 
        // Wait while the buffer is empty
        while (buffer.isEmpty()) {
            wait();
        }
 
        int item = buffer.remove();
        System.out.println("Consumed: " + item);
 
        // Notify the producer that buffer space is available
        notify();
 
        return item;
    }
}
 
public class ProducerConsumer {
 
    public static void main(String[] args) {
 
        SharedBuffer sharedBuffer = new SharedBuffer();
 
        // Producer thread creates numbers from 1 to 10
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    sharedBuffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");
 
        // Consumer thread consumes 10 items in FIFO order
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    sharedBuffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");
 
        // Start both threads
        producer.start();
        consumer.start();
 
        try {
            // Wait for both threads to finish
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
 
        System.out.println("Producer-Consumer completed successfully.");
    }
}
