package mynewproject;
//Interface defining banking operations
interface BankingService {
 void deposit(double amount);
 void withdraw(double amount);
 void logTransaction(String type, double amount);
}


class Account implements BankingService {
 private double balance;

 public double getBalance() {
     return balance;
 }

 @Override
 public void deposit(double amount) {
     if (amount <= 0) {
         System.out.println("Invalid deposit amount.");
     } else {
         balance += amount;
         System.out.println("Deposited ₹" + amount + ". Balance = ₹" + balance);
         logTransaction("Deposit", amount);
     }
 }

 @Override
 public void withdraw(double amount) {
     if (amount <= 0) {
         System.out.println("Invalid withdrawal amount.");
     } else if (amount > balance) {
         System.out.println("Insufficient funds.");
     } else {
         balance -= amount;
         System.out.println("Withdrew ₹" + amount + ". Balance = ₹" + balance);
         logTransaction("Withdraw", amount);
     }
 }

 @Override
 public void logTransaction(String type, double amount) {
     Transaction t = new Transaction(type, amount);
     t.record();
 }
}

//Transaction class for logging
class Transaction {
 private String type;
 private double amount;

 public Transaction(String type, double amount) {
     this.type = type;
     this.amount = amount;
 }

 public void record() {
     System.out.println("Transaction recorded: " + type + " ₹" + amount);
 }
}

//Main class to test functionality
public class BankingSystemInterface {
 public static void main(String[] args) {
     BankingService service = new Account(); // Polymorphic reference
     System.out.println("Log manual transaction");
     service.logTransaction("Manual Entry", 300);
     System.out.println();
     System.out.println("Name: Gobikaa E");
     System.out.println("Reg no:2117240020106");
     
 }}

    /*System.out.println("\n Withdraw ₹500");
     service.withdraw(500); // Expected: Balance = ₹500

     System.out.println("\nTC3: Withdraw ₹1500");
     service.withdraw(1500); // Expected: Insufficient funds

     System.out.println("\nTC4: Deposit -₹200");
     service.deposit(-200); // Expected: Invalid deposit

     System.out.println("\nTC5: Log manual transaction");
     service.logTransaction("Manual Entry", 300); // Expected: Transaction recorded*/
 

















