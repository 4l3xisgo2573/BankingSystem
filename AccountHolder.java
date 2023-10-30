import java.util.Scanner;
class Debit {
    private double amountInAccount;
    private double amountLoaned;
    private String date;
    void makeLoan(double loanAmount, String loanDate) {
        amountLoaned += loanAmount;
        date = loanDate;
        System.out.println("Loan of $" + loanAmount + " made on " + loanDate + ".");
    }

    void payNextPayment(double paymentAmount) {
        if (amountLoaned == 0) {
            System.out.println("There is no loan amount available.");
        } else {
            amountLoaned -= paymentAmount;
            System.out.println("$" + paymentAmount + " paid. Remaining loan amount: $" + amountLoaned + ".");
        }
    }

    void setAmountInAccount(double amount) {
        this.amountInAccount = amount;
    }

    double getAmountInAccount() {
        return this.amountInAccount;
    }

}

class Credit {
    private double amountInAccount;
    private double amountLoaned;
    private String date;
    void makeLoan(double loanAmount, String loanDate) {
        amountLoaned += loanAmount;
        date = loanDate;
        System.out.println("Loan of $" + loanAmount + " made on " + loanDate + ".");
    }

    void payNextPayment(double paymentAmount) {
        if (amountLoaned == 0) {
            System.out.println("There is no loan amount available.");
        } else {
            amountLoaned -= paymentAmount;
            System.out.println("$" + paymentAmount + " paid. Remaining loan amount: $" + amountLoaned + ".");
        }
    }
    void setAmountInAccount(double amount) {
        this.amountInAccount = amount;
    }
    double getAmountInAccount() {
        return this.amountInAccount;
    }

}
public class AccountHolder {
    String cardType;
    void whichCard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter account number: ");
        System.out.println("Which type of card would you like to use today:");
        System.out.println("1. Debit Card");
        System.out.println("2. Credit Card");
        int typeOption = scan.nextInt();
        if (typeOption == 1) {
            Debit debitCard = new Debit();
            System.out.println("You chose Debit.");
            System.out.println("Do you like to make a loan? (yes/no)");
            String mloan = scan.next();
            if (mloan.equals("yes")) {
                System.out.print("Enter the loan amount: $");
                double loanAmount = scan.nextDouble();
                System.out.print("Enter the loan date: ");
                String loanDate = scan.next();
                debitCard.makeLoan(loanAmount, loanDate);
            } else {
                System.out.print("You are not getting a loan.");
            }
            System.out.println("\nDo you want to make a loan payment? (yes/no)");
            String makePayment = scan.next();
            if (makePayment.equals("yes")) {
                System.out.print("Enter the payment amount: $");
                double paymentAmount = scan.nextDouble();
                debitCard.payNextPayment(paymentAmount);
            } else {
                System.out.println("No payment made.");
            }
        } else if (typeOption == 2) {
            Credit creditCard = new Credit();
            System.out.println("You chose Credit.");
            System.out.println("Do you like to make a loan? (yes/no)");
            String mloan = scan.next();
            if (mloan.equals("yes")) {
                System.out.print("Enter the loan amount: $");
                double loanAmount = scan.nextDouble();
                System.out.print("Enter the loan date: ");
                String loanDate = scan.next();
                creditCard.makeLoan(loanAmount, loanDate);
            } else {
                System.out.print("You are not getting a loan.");
            }
            System.out.println("\nDo you want to make a loan payment? (yes/no)");
            String makePayment = scan.next();
            if (makePayment.equals("yes")) {
                System.out.print("Enter the payment amount: $");
                double paymentAmount = scan.nextDouble();
                creditCard.payNextPayment(paymentAmount);
            } else {
                System.out.println("No payment made today.");
            }
        } else {
            System.out.println("Not an option, please try again.");
        }
        scan.close();
    }
    public static void main(String[] args) {
        AccountHolder ah = new AccountHolder();
        ah.whichCard();
    }
}
