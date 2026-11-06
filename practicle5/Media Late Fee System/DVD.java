class DVD extends Media {
 
    DVD(String title, int lateDays) {
        super(title, lateDays);
    }
 
    @Override
    double calculateLateFee() {
        return lateDays * 10;
    }
}
