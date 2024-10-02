import java.util.Scanner;

public class OnlineBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();
        BankAccount account1 = new BankAccount("123456789", "Alice", 1000);
        BankAccount account2 = new BankAccount("987654321", "Bob", 500);

        // Simulate registration
        auth.register("alice", "password123");
        auth.register("bob", "password456");

        System.out.println("Welcome to Online Banking System");

        // Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (auth.login(username, password)) {
            BankAccount loggedInAccount = username.equals("alice") ? account1 : account2;

            // User is authenticated
            int choice;
            do {
                System.out.println("\n1. View Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer Funds");
                System.out.println("5. Pay Bills");
                System.out.println("6. View Transaction History");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        loggedInAccount.viewBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        loggedInAccount.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        loggedInAccount.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient account number: ");
                        String recipientAccNumber = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        BankAccount recipient = recipientAccNumber.equals("987654321") ? account2 : account1;
                        loggedInAccount.transfer(recipient, transferAmount);
                        break;
                    case 5:
                        System.out.print("Enter biller name: ");
                        String biller = scanner.next();
                        System.out.print("Enter bill amount: ");
                        double billAmount = scanner.nextDouble();
                        BillPayment billPayment = new BillPayment(biller, billAmount);
                        billPayment.payBill(loggedInAccount);
                        break;
                    case 6:
                        loggedInAccount.showTransactionHistory();
                        break;
                    case 7:
                        System.out.println("Exiting the system. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 7);
        }

        scanner.close();
    }
}
