abstract class Media {
    String title;
    int lateDays;
 
    Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }
 
    abstract double calculateLateFee();
}
