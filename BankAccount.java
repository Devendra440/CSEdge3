import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    // Deposit funds
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    // Withdraw funds
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }

    // Transfer funds
    public boolean transfer(BankAccount recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            transactionHistory.add("Transferred $" + amount + " to account: " + recipient.getAccountNumber());
            return true;
        }
        return false;
    }

    // View balance
    public void viewBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Transaction History
    public void showTransactionHistory() {
        System.out.println("Transaction history for " + accountNumber + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
}
