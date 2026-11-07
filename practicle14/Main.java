import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountService service = new AccountService();
        int choice;

        do {
            System.out.println("\n===== ACCOUNT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Show Account Count");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    int number = sc.nextInt();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();

                    Account account = new Account(name, number, balance);
                    service.addAccount(account);
                    break;
                case 2:
                    service.displayAllAccounts();
                    break;
                case 3:
                    System.out.println("Total Accounts: " + service.getAccountCount());
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
