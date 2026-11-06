// Demonstrates race conditions in a shared seat booking system
class SeatBookingRace {
 
    static class BookingSystem {
        // Shared number of seats available for booking
        int seatsLeft = 5;
        // Tracks the number of successful bookings
        int successfulBookings = 0;
 
        // Booking without synchronization
        // Unsafe booking method: check and update are not protected
        void bookSeat() {
            if (seatsLeft > 0) {
                seatsLeft--;
                successfulBookings++;
                System.out.println(Thread.currentThread().getName()
                        + " booked a seat. Seats left: " + seatsLeft);
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not book. No seats available.");
            }
        }
 
        // Booking with synchronization
        // Synchronized booking method prevents overbooking
        synchronized void bookSeatSync() {
            if (seatsLeft > 0) {
                seatsLeft--;
                successfulBookings++;
                System.out.println(Thread.currentThread().getName()
                        + " booked a seat. Seats left: " + seatsLeft);
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not book. No seats available.");
            }
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
 
        final int THREADS = 10;
 
        // Test 1: booking without synchronization
        System.out.println("=== Without Synchronization ===");
 
        BookingSystem system1 = new BookingSystem();
        Thread[] threads = new Thread[THREADS];
 
        // Create and start threads for the unsynchronized test
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> system1.bookSeat(),
                    "Customer-" + (i + 1));
            threads[i].start();
        }
 
        // Wait until all threads finish before displaying the result
        for (Thread t : threads) {
            t.join();
        }
 
        System.out.println("Successful Bookings: "
                + system1.successfulBookings);
        System.out.println("Seats Remaining: " + system1.seatsLeft);
 
        // Test 2: booking with synchronization
        System.out.println("\n=== With Synchronization ===");
 
        BookingSystem system2 = new BookingSystem();
 
        // Create and start threads for the unsynchronized test
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> system2.bookSeatSync(),
                    "Customer-" + (i + 1));
            threads[i].start();
        }
 
        // Wait until all threads finish before displaying the result
        for (Thread t : threads) {
            t.join();
        }
 
        System.out.println("Successful Bookings: "
                + system2.successfulBookings);
        System.out.println("Seats Remaining: " + system2.seatsLeft);
    }
}
