package managementsystem;

import java.util.*;

class BankingSystem {
    private final Map<Integer, Double> accounts = new HashMap<>(); // AccountNumber -> Balance
    private final Queue<Integer> withdrawalQueue = new LinkedList<>(); // Queue for withdrawals

    // Add a new account
    public void addAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Deposit money into an account
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Request withdrawal (Added to queue)
    public void requestWithdrawal(int accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        withdrawalQueue.add(accountNumber);
    }

    // Process withdrawal requests
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Withdrawal of $" + amount + " processed for Account: " + accountNumber);
            } else {
                System.out.println("Insufficient funds in Account: " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }
        System.out.println("Accounts sorted by balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding accounts
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 3000);
        bank.addAccount(1003, 7000);

        // Deposits
        bank.deposit(1001, 1000);
        bank.deposit(1002, 500);

        // Withdrawal requests
        bank.requestWithdrawal(1001);
        bank.requestWithdrawal(1003);

        // Process withdrawals
        bank.processWithdrawals(2000);

        // Display sorted accounts
        bank.displaySortedAccounts();
    }
}

