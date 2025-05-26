public class Bank {
private Account acc1;
private Account acc2;
private Account acc3;
public void createAccount(Account acc) {
    if (acc1 == null) acc1 = acc;
    else if (acc2 == null) acc2 = acc;
    else if (acc3 == null) acc3 = acc;
    else System.out.println("Cannot create more than 3 accounts.");
}

public Account findAccount(String accNo) {
    if (acc1 != null && acc1.getAccountNumber().equals(accNo)) return acc1;
    if (acc2 != null && acc2.getAccountNumber().equals(accNo)) return acc2;
    if (acc3 != null && acc3.getAccountNumber().equals(accNo)) return acc3;
    return null;
}

public void showAllAccounts() {
    if (acc1 != null) acc1.displayDetails();
    if (acc2 != null) acc2.displayDetails();
    if (acc3 != null) acc3.displayDetails();
}
}