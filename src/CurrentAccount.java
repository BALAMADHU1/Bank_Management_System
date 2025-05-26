public class CurrentAccount extends Account {
private double overdraftLimit = 1000;
public CurrentAccount(String accountNumber, String holderName, double balance) {
    super(accountNumber, holderName, balance);
}

@Override
public void withdraw(double amount) {
    if (balance + overdraftLimit >= amount) {
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    } else {
        System.out.println("Overdraft limit exceeded in current account.");
    }
}
}