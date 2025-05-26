import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Bank bank = new Bank();
BalanceShow balanceViewer = new BalanceShow();
Scanner sc = new Scanner(System.in);    
while (true) {
    System.out.println("Bank Menu:");
    System.out.println("1. Create Account");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Show Balance");
    System.out.println("5. Show All Accounts");
    System.out.println("6. Exit");
    System.out.print("\nChoose: ");
    int choice = sc.nextInt();
    sc.nextLine();

    switch (choice) {
        case 1:
            System.out.print("Enter Account Type (1-Savings, 2-Current): ");
            int type = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double bal = sc.nextDouble();
            sc.nextLine();

            Account acc = (type == 1)
                    ? new SavingsAccount(accNo, name, bal)
                    : new CurrentAccount(accNo, name, bal);

            bank.createAccount(acc);
            break;

        case 2:
            System.out.print("Enter Account Number: ");
            String dNo = sc.nextLine();
            Account dAcc = bank.findAccount(dNo);
            if (dAcc != null) {
                System.out.print("Enter Amount to Deposit: ");
                double amt = sc.nextDouble();
                dAcc.deposit(amt);
                balanceViewer.showBalance(dAcc);
            } else {
                System.out.println("Account not found.");
            }
            break;

        case 3:
            System.out.print("Enter Account Number: ");
            String wNo = sc.nextLine();
            Account wAcc = bank.findAccount(wNo);
            if (wAcc != null) {
                System.out.print("Enter Amount to Withdraw: ");
                double amt = sc.nextDouble();
                wAcc.withdraw(amt);
                balanceViewer.showBalance(wAcc);
            } else {
                System.out.println("Account not found.");
            }
            break;

        case 4:
        	System.out.print("Enter Account Number: ");
            String sNo = sc.nextLine();
            Account sAcc = bank.findAccount(sNo);
            balanceViewer.showBalance(sAcc);
            break;

        case 5:
        	bank.showAllAccounts();
            break;
            
           

        case 6:
        	System.out.println("Signing Off!");
            return;
            

        default:
            System.out.println("Invalid choice. Try again.");
            sc.close();
    }
}
}
}