package bank;

import java.util.List;

public class CreditSearch {
    public Credit searchCredit(List<Credit> credits ,String name , String adress , String phone ,
                                double interestRate , double loanAmount , int loanTerm){
        Credit closestCredit = null;
        double minDifference = Double.MAX_VALUE;

        for (Credit credit : credits) {
            if(credit.getName().equals(name)) {
                double difference = Math.abs(credit.getMaxLoanAmount() - loanAmount)
                        + Math.abs(credit.getInterestRate() - interestRate)
                        + Math.abs(credit.getLoanTerm() - loanTerm);

                if (difference < minDifference) {
                    closestCredit = credit;
                    minDifference = difference;
                }
            }
        }

        return closestCredit;
    }

   /* @Override
    public String toString() {
        return "CreditSearch{" +
                "credit = " credit +
                '}';
    }*/
}
