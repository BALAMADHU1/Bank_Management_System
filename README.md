Bank Management System Using OOPs Concept (Core java)
🎯 Features:
1.Create Savings or Current Account (up to 3 accounts) 
2.Deposit money
3.Withdraw money
4.View account details
5.Show balance after each transaction
6.View balance by account number

🧱 Technologies Used:
*Java (JDK 8+)
*Console/Terminal (Command Prompt, Bash, etc.)
*No collections, no databases, no external libraries

📁 Project Structure
File	                        Description
Account.java	            Abstract class for common account fields
SavingsAccount.java	      Inherits from Account
CurrentAccount.java	      Inherits from Account with overdraft
Bank.java               	Manages up to 3 accounts manually
BalanceShow.java        	Displays balance for any account
Main.java	                Entry point, displays menu and handles input

▶️ How to Compile and Run
1. Open terminal or command prompt.
2. Navigate to the folder where you saved the files.
   cd path/to/BankManagementSystem
3. Compile all Java files:
   javac *.java
4. Run the application:

java Main
📜 Menu Options
You will see a menu like this:
Bank Menu:
1. Create Account
2. Deposit
3. Withdraw
4. Show Balance
5. Show All Accounts
6. Exit
   
📌 Notes
#SavingsAccount allows withdrawal only up to available balance.
#CurrentAccount allows overdraft up to ₹1000.
#Shows balance after every deposit or withdrawal.
#All logic is implemented using basic OOP concepts only.
