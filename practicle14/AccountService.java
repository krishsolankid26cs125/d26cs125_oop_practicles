import java.util.ArrayList;

public class AccountService {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }
        accounts.add(account);
        System.out.println("Account added successfully!");
    }

    public int getAccountCount() {
        return accounts.size();
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        for (Account account : accounts) {
            account.displayAccount();
            System.out.println("--------------------");
        }
    }
}
