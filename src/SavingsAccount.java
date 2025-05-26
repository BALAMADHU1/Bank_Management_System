public class SavingsAccount extends Account {
public SavingsAccount(String accountNumber, String holderName, double balance) {
super(accountNumber, holderName, balance);
}
@Override
public void withdraw(double amount) {
    if (amount <= balance) {
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    } else {
        System.out.println("Insufficient balance.");
    }
}
}