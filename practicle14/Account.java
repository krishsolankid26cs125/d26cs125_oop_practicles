public class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public Account(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() { return accountHolder; }
    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
