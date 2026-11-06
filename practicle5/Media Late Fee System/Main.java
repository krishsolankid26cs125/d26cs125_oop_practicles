public class Main {
    public static void main(String[] args) {
 
        Media[] mediaItems = {
            new Book("Java Programming", 4),
            new DVD("Inception", 3),
            new Magazine("Tech Today", 5)
        };
 
        double totalLateFee = 0;
 
        for (Media media : mediaItems) {
 
            double fee = media.calculateLateFee();
 
            System.out.println("Media Title: " + media.title);
            System.out.println("Late Days: " + media.lateDays);
            System.out.println("Late Fee: Rs. " + fee);
            System.out.println();
 
            totalLateFee += fee;
        }
 
        System.out.println("Total Late Fee: Rs. " + totalLateFee);
    }
}
