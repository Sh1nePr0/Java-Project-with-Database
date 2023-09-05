package database;

import java.sql.*;
import bank.*;
import database.DataBaseConnection;

import java.util.ArrayList;
import java.util.List;

public class DBControl {
        public static List<Credit> scanInformationFromDatabase(){
            List<Credit> credits = new ArrayList<>();

            try{
                DataBaseConnection dbConnection = new DataBaseConnection("jdbc:mysql://localhost:3306/CreditsDB" ,
                        "root","1234");
                Connection connection = dbConnection.getConnection();

                Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery("SELECT * FROM creditsdb.credits");


                while(resultSet.next()){
                    String name = resultSet.getString("bankName");
                    String adress = resultSet.getString("adress");
                    String phone = resultSet.getString("phone");
                    double interestRate = resultSet.getDouble("interestRate");
                    double loanAmount = resultSet.getDouble("loanAmount");
                    int loanTerm = resultSet.getInt("loanTerm");
                    boolean isEarlyRepayment = resultSet.getBoolean("earlyRepayment");
                    boolean isCreditLineIncrease = resultSet.getBoolean("creditLineIncrease");
                    int id = resultSet.getInt("id");

                    Credit credit = new Credit(name, adress ,phone ,id ,interestRate , loanAmount
                            ,loanTerm , isEarlyRepayment , isCreditLineIncrease);
                    credits.add(credit);
                }

                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

           return credits;
        }


}
