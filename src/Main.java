import java.util.Random;

public class Main {

    private static Random random = new Random();
    private static String[] names = {"Mike", "Sara", "John", "Alice"};

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = createRandomAccount(i);
        }

        Bank bank = new Bank(accounts);

        System.out.println(bank);
        System.out.println("TRANSFERRING MONEY:");

        FundTransfer[] transfers = new FundTransfer[10];
        for (int i = 0; i < transfers.length; i++) {
            transfers[i] = createFT(accounts.length);
        }

        bank.transfer(transfers);

        System.out.println();
        System.out.println(bank);

    }

    private static FundTransfer createFT(int accountsSize){
        int fromId = random.nextInt(accountsSize);
        int toId = random.nextInt(accountsSize);
        double amount = random.nextDouble() * 1000.00;
        return new FundTransfer(fromId, toId, amount);
    }

    private static BankAccount createRandomAccount(int id){
        String name = names[random.nextInt(names.length)];
        double balance = random.nextDouble() * 10000.00;
        return new BankAccount(id, name, balance);
    }
}