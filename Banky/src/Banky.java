import java.util.*;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully into account " + accountNumber);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully from account " + accountNumber);
        } else {
            System.out.println("Insufficient balance in account " + accountNumber);
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            recipient.deposit(amount);
            System.out.println(amount + " transferred successfully from account " + accountNumber + " to account "
                    + recipient.getAccountNumber());
        } else {
            System.out.println("Insufficient balance in account " + accountNumber + " for transfer");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
}

public class Banky {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account1 = new BankAccount(762004, "Jay pandya", 1000.0);
        BankAccount account2 = new BankAccount(2362004, "Milan", 500.0);

        while (true) {
            System.out.println("\nBankY Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter account number to deposit into: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAccountNumber == account1.getAccountNumber()) {
                        account1.deposit(depositAmount);
                    } else if (depositAccountNumber == account2.getAccountNumber()) {
                        account2.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid account number");
                    }
                    break;
                case 2:
                    System.out.print("Enter account number to withdraw from: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAccountNumber == account1.getAccountNumber()) {
                        account1.withdraw(withdrawAmount);
                    } else if (withdrawAccountNumber == account2.getAccountNumber()) {
                        account2.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid account number");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number to transfer from: ");
                    int transferFromAccountNumber = scanner.nextInt();
                    System.out.print("Enter account number to transfer to: ");
                    int transferToAccountNumber = scanner.nextInt();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    if (transferFromAccountNumber == account1.getAccountNumber()
                            && transferToAccountNumber == account2.getAccountNumber()) {
                        account1.transfer(account2, transferAmount);
                    } else if (transferFromAccountNumber == account2.getAccountNumber()
                            && transferToAccountNumber == account1.getAccountNumber()) {
                        account2.transfer(account1, transferAmount);
                    } else {
                        System.out.println("Invalid account numbers for transfer");
                    }
                    break;
                case 4:
                    System.out.println("Exiting BankY. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}