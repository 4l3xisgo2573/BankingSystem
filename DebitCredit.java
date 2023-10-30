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