package bank;

public class Credit extends Bank{
    private int id;
    private double interestRate;
    private double maxLoanAmount;
    private int loanTerm;
    private boolean earlyRepayment;
    private boolean creditLineIncrease;


    public Credit(String name ,String adress , String phone, int id,double interestRate , double maxLoanAmount ,
                  int loanTerm , boolean earlyRepayment , boolean creditLineIncrease){
        super( name, adress , phone);
        this.id = id;
        this.interestRate = interestRate;
        this.maxLoanAmount = maxLoanAmount;
        this.loanTerm = loanTerm;
        this.earlyRepayment = earlyRepayment;
        this.creditLineIncrease = creditLineIncrease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(double maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public boolean isCreditLineIncrease() {
        return creditLineIncrease;
    }

    public void setCreditLineIncrease(boolean creditLineIncrease) {
        this.creditLineIncrease = creditLineIncrease;
    }

    public boolean isEarlyRepayment() {
        return earlyRepayment;
    }

    public void setEarlyRepayment(boolean earlyRepayment) {
        this.earlyRepayment = earlyRepayment;
    }

    @Override
    public String toString() {
        return id + ".LoanOffer : " + "\n" +
                        "\tBank : \n" +
                        "\t\tName=" + getName() + "\n" +
                        "\t\tAdress=" + getAdress() + "\n" +
                        "\t\tPhone=" + getPhone() + "\n" +
                "\tCredit : " + "\n" +
                "\t\tInterestRate=" + interestRate + "\n"+
                "\t\tMaxLoanAmount=" + maxLoanAmount + "\n"+
                "\t\tLoanTerm=" + loanTerm + "\n" +
                "\t\tEarlyRepayment : " + earlyRepayment +"\n"+
                "\t\tCreditLineIncrease :  " + creditLineIncrease + "\n";
    }
}
