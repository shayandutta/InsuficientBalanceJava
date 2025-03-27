import java.util.Scanner;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Your current balance is: Rs." + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! New balance: Rs." + balance);
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(500.00);

        try {
            System.out.print("Enter the amount to withdraw: Rs.");
            double amount = scanner.nextDouble();

            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {
            // Handling custom insufficient balance exception
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            // Handling invalid input (like non-numeric values)
            System.out.println("Error: Invalid input. Please enter a valid amount.");

        } 
    }
}
