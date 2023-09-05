package bank;

import java.util.List;
public class BestCreditSelection {

    public Credit selectBestCredit(List<Credit> credits){
        Credit bestCredit = null;
        double bestInterestRate = Double.MAX_VALUE;
        double bestLoanTerm = 0;

        for(Credit credit : credits) {
            double interestRate = credit.getInterestRate();
            double loanTerm = credit.getLoanTerm();
            if(interestRate < bestInterestRate && loanTerm > bestLoanTerm){
                bestCredit = credit;
                bestInterestRate = interestRate;
                bestLoanTerm = loanTerm;
            }
        }

        return bestCredit;
    }
}
