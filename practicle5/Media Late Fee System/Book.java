class Book extends Media {
 
    Book(String title, int lateDays) {
        super(title, lateDays);
    }
 
    @Override
    double calculateLateFee() {
        return lateDays * 5;
    }
}
