public class CinemaShow {
 
    private String title;
    private int seatsAvailable;
    private final int capacity;
 
    private static int totalBooked = 0;
 
    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }
 
    public CinemaShow(String title) {
        this(title, 100);
    }
 
    public boolean book(int n) {
        if (n <= 0) {
            return false;
        }
 
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        } else {
            return false;
        }
    }
 
    public boolean cancel(int n) {
        if (n <= 0) {
            return false;
        }
 
        if (seatsAvailable + n <= capacity) {
            seatsAvailable += n;
            return true;
        } else {
            return false;
        }
    }
 
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
 
    public static int getTotalBooked() {
        return totalBooked;
    }
 
    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("Avengers", 50);
 
        System.out.println("Movie: Avengers");
        System.out.println("Initial available seats: " + show.getSeatsAvailable());
 
        System.out.println("Booking 10 seats: " + show.book(10));
        System.out.println("Available seats: " + show.getSeatsAvailable());
 
        System.out.println("Booking 30 seats: " + show.book(30));
        System.out.println("Available seats: " + show.getSeatsAvailable());
 
        System.out.println("Booking 20 seats: " + show.book(20));
        System.out.println("Available seats: " + show.getSeatsAvailable());
 
        System.out.println("Cancelling 5 seats: " + show.cancel(5));
        System.out.println("Available seats: " + show.getSeatsAvailable());
 
        System.out.println("Cancelling 20 seats: " + show.cancel(20));
        System.out.println("Available seats: " + show.getSeatsAvailable());
 
        System.out.println("Total booked: " + CinemaShow.getTotalBooked());
    }
}
