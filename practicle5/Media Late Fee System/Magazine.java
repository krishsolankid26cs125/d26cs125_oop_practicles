class Magazine extends Media {
 
    Magazine(String title, int lateDays) {
        super(title, lateDays);
    }
 
    @Override
    double calculateLateFee() {
        return lateDays * 3;
    }
}
