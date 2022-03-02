public class CheckingAccount {

    private double balance;
    private String accountNo;
    private double amount;

    public CheckingAccount(){
        this.balance = 0;
        this.accountNo = "ACC123";
        this.amount = 0;
    }

    public double getBalance(){
        // returns the balance
        return balance;
    }

    public String getAccountNo(){
        // returns the accountNo
        return accountNo;
    }

    public double getAmount(){
        // returns the amount
        return amount;
    }

    public double deposit(double amountDeposit){
        // returns the new balance
        this.balance = this.balance + amountDeposit;
        return this.balance;
    }

    public double withdraw(double amountWithdraw) throws InsufficientFundsException{

        // withdraw unsuccessful
        if (amountWithdraw > this.balance) {
            this.amount = amountWithdraw - this.balance;
            throw new InsufficientFundsException(amountWithdraw);
        }

        // withdraw successful
        this.balance = this.balance - amountWithdraw;
        return this.balance;
    }
}
