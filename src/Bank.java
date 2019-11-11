public class Bank {

    private BankAccount[] accounts;

    public Bank(BankAccount[] accounts) {
        this.accounts = accounts;
    }

    public void transfer(FundTransfer[] transfers){
        for (FundTransfer transfer : transfers) {
            transfer(transfer);
        }
    }

    private void transfer(FundTransfer transfer){
        BankAccount fromAccount = findAccount(transfer.getFromId());
        if(fromAccount == null){
            System.out.println("From does not exist");
            return;
        }
        BankAccount toAccount = findAccount(transfer.getToId());
        if(toAccount == null){
            System.out.println("To does not exist");
            return;
        }
        if(fromAccount.getBalance() < transfer.getAmount()){
            System.out.println("From does not have enough funds");
            return;
        }
        System.out.println(String.format("transferring from %s to %s, amount: %f", fromAccount, toAccount, transfer.getAmount()));
        fromAccount.withdraw(transfer.getAmount());
        toAccount.topUp(transfer.getAmount());
    }

    private BankAccount findAccount(int id){
        for (BankAccount account : accounts) {
            if(account.getId() == id){
                return account;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BANK STATE:").append("\n");
        for (BankAccount account : accounts) {
            sb.append(account.toString()).append("\n");
        }
        return sb.toString();
    }
}