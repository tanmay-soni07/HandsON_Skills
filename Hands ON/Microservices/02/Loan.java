public class Loan {

    private String loanNumber;
    private String type;
    private double amount;

    public Loan() {
    }

    public Loan(String loanNumber, String type, double amount) {
        this.loanNumber = loanNumber;
        this.type = type;
        this.amount = amount;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}