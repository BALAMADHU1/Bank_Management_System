public class BalanceShow {
public void showBalance(Account account) {
if (account != null) {
System.out.println("Current Balance" + ": ₹" + account.balance);
} else {
System.out.println("Account not found.");
}
}
}