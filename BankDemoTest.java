import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemoTest {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        CheckingAccount ca = new CheckingAccount();

        try{
            // ask for user input
            System.out.print("Amount to deposit: ");
            double amountDeposit = sc.nextDouble();

            // if input is not a positive number, catch invalid input
            if (amountDeposit < 0)
                throw new IllegalArgumentException("Input must be a positive number");

            // deposit amount
            ca.deposit(amountDeposit);
            System.out.println("Deposit $" + String.format("%.2f", amountDeposit) + " into the account\n");

            // ask for user input
            System.out.print("Amount to withdraw: ");
            double amountWithdraw = sc.nextDouble();

            // if input is not a positive number, catch invalid input
            if (amountWithdraw < 0)
                throw new IllegalArgumentException("Input must be a positive number");

            // withdraw amount
            System.out.println("Withdraw $" + String.format("%.2f", amountWithdraw) + " from the account\n");

            // withdrawal successful
            System.out.println("The balance after withdraw is: $" + String.format("%.2f", ca.withdraw(amountWithdraw)));

        } catch (InputMismatchException e) {
            // if input is not a number, catch invalid input
            System.out.println("Input must be a number");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            // withdrawal unsuccessful
            System.out.println("Sorry, but your account is short by: $" + String.format("%.2f", ca.getAmount()));
        }
    }
}
