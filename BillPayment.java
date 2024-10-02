public class BillPayment {
    private String biller;
    private double amount;

    public BillPayment(String biller, double amount) {
        this.biller = biller;
        this.amount = amount;
    }

    public boolean payBill(BankAccount account) {
        if (account.withdraw(amount)) {
            System.out.println("Paid $" + amount + " to " + biller);
            return true;
        }
        return false;
    }
}
