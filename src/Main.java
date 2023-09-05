import java.util.ArrayList;
import java.util.Scanner;
import bank.*;
import database.DBControl;
import database.DBModificator;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean leave = false;
        while (!leave) {
            List<Credit> credits = DBControl.scanInformationFromDatabase();
            OffersMenu();
            System.out.print("Enter option number: ");

            int option = scan.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    for(int i =0 ; i < credits.size(); i++)
                    {
                        System.out.println(credits.get(i).toString());
                    }
                    break;
                case 2:
                    BestCreditSelection selection = new BestCreditSelection();
                    Credit bestCredit = selection.selectBestCredit(credits);
                    System.out.println("Your the best credit : ");
                    System.out.println(bestCredit.toString());
                    break;
                case 3:
                    System.out.println("All credits: ");
                    for(int i =0 ; i < credits.size(); i++)
                    {
                        System.out.println(credits.get(i).toString());
                    }
                    System.out.print("Enter the credit number you want to select: ");
                    int creditNumber = scan.nextInt();
                    Credit selectedOffer = credits.get(creditNumber - 1);
                    System.out.println("You select this credit : ");
                    System.out.println(selectedOffer.toString());
                    break;
                case 4:
                    System.out.println("Enter your criteria : ");
                    System.out.print("Input name of bank : ");
                    String name = scan.next();
                    System.out.print("Input adress of bank : ");
                    String adress = scan.next();
                    System.out.print("Input phone of bank : ");
                    String phone = scan.next();
                    System.out.print("Input amount of the credit : ");
                    double loanAmount = scan.nextDouble();
                    System.out.print("Input interest rate of the credit : ");
                    double interestRate = scan.nextDouble();
                    System.out.print("Input credit term(in months) : ");
                    int term = scan.nextInt();
                    CreditSearch searchingCredit = new CreditSearch();
                    Credit findingCredit = searchingCredit.searchCredit(credits, name, adress, phone,
                            interestRate, loanAmount, term);
                    System.out.println("Your finding credit : ");
                    System.out.println(findingCredit);
                    break;
                case 5:
                    boolean exit_from_modify_menu = false;
                    while(!exit_from_modify_menu) {
                        DBModificator modificator = new DBModificator();
                        ModifyMenu();
                        System.out.print("Enter option number : ");
                        int new_option = scan.nextInt();
                        switch (new_option) {
                            case 1:
                                System.out.print("Input name of bank : ");
                                String new_name = scan.next();
                                System.out.print("Input adress of bank : ");
                                String new_adress = scan.next();
                                System.out.print("Input phone of bank : ");
                                String new_phone = scan.next();
                                System.out.print("Input amount of the credit : ");
                                double new_loanAmount = scan.nextDouble();
                                System.out.print("Input interest rate of the credit : ");
                                double new_interestRate = scan.nextDouble();
                                System.out.print("Input credit term(in months) : ");
                                int new_term = scan.nextInt();
                                System.out.print("Is early repayment possible(true/false) : ");
                                boolean earlyRepayment = scan.nextBoolean();
                                int IsEarlyRepaymentAllowed;
                                if (earlyRepayment) {
                                    IsEarlyRepaymentAllowed = 1;
                                } else {
                                    IsEarlyRepaymentAllowed = 0;
                                }
                                System.out.print("Is credit line increase possible(true/false) : ");
                                boolean creditLineIncrease = scan.nextBoolean();
                                int IsCreditLineIncreaseAllowed;
                                if (creditLineIncrease) {
                                    IsCreditLineIncreaseAllowed = 1;
                                } else {
                                    IsCreditLineIncreaseAllowed = 0;
                                }
                                Credit new_credit = new Credit(new_name, new_adress, new_phone, credits.size() + 1,
                                        new_interestRate, new_loanAmount, new_term, earlyRepayment,
                                        creditLineIncrease);
                                credits.add(new_credit);
                                try {
                                    modificator.Insert(new_name, new_adress, new_phone, new_loanAmount, new_interestRate,
                                            new_term, IsEarlyRepaymentAllowed, IsCreditLineIncreaseAllowed
                                            , credits.size());
                                    System.out.println("Credit insert successfully");
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                for(int i =0 ; i < credits.size(); i++)
                                {
                                    System.out.println(credits.get(i).toString());
                                }
                                System.out.print("Enter id of the element you want to remove from database : ");
                                int delete_id = scan.nextInt();
                                try{
                                    modificator.Remove(delete_id);
                                    System.out.println("Credit removed successfully");
                                }catch (SQLException e){
                                    System.out.println("Error with deleting the element from database");
                                    e.printStackTrace();
                                }
                                IntComparator comparator = new IntComparator();
                                for(Credit credit: new ArrayList<>(credits)){
                                    if(comparator.compare(credit.getId(), delete_id) == 0){
                                        credits.remove(credit);
                                    }
                                }
                                break;
                            case 3:
                                exit_from_modify_menu = true;
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                    break;
                case 6:
                    DBModificator.CloseDB();
                    leave = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void OffersMenu() {
        System.out.println("Menu:");
        System.out.println("1. View all credits");
        System.out.println("2. Find the best credit for you");
        System.out.println("3. Select certain credit");
        System.out.println("4. Find a credit according to your criteria");
        System.out.println("5. Modify Database");
        System.out.println("6. Exit");
    }

    public static void ModifyMenu() {
        System.out.println("Modify Menu:");
        System.out.println("1. Insert in Database");
        System.out.println("2. Remove from Database");
        System.out.println("3. Exit from modify menu");
    }
}
