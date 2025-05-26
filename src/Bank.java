public class Bank {
private final int MAX_ACCOUNTS = 100;
private Account[] accounts = new Account[MAX_ACCOUNTS];
private int count = 0;
public void createAccount(Account acc) {
    if (count < MAX_ACCOUNTS) {
        accounts[count++] = acc;
        System.out.println("Account created successfully.");
    } else {
        System.out.println("Bank is full. Cannot add more accounts.");
    }
}

public Account findAccount(String accountNumber) {
    for (int i = 0; i < count; i++) {
        if (accounts[i].getAccountNumber().equals(accountNumber)) {
            return accounts[i];
        }
    }
    return null;
}

public void showAllAccounts() {
    if (count == 0) {
        System.out.println("No accounts found.");
        return;
    }
    for (int i = 0; i < count; i++) {
        System.out.println("\nAccount #" + (i + 1));
        accounts[i].displayDetails();
    }
}
}
