package database;
import java.sql.*;
public class DBModificator {

    public static Connection connection = null;
    public static Statement statement;

    public static void Insert(String bankName , String adress , String phone , double loanAmount ,
                              double interestRate , int term , int IsEarlyRepaymentAllowed ,
                              int IsCreditLineIncreaseAllowed , int id) throws SQLException{
        try{
            connection = DataBaseConnection.getConnection();
        }catch (SQLException e){
            System.out.print("Error to get connection!");
            e.printStackTrace();
        }
        statement = connection.createStatement();
        String query = "INSERT INTO credits (bankName , adress , phone , interestRate , loanAmount , loanTerm , earlyRepayment " +
                ", creditLineIncrease , id) VALUES ('" + bankName + "' , '" + adress  + "' , '" + phone + "' , '" +
                interestRate + "' , '" + loanAmount + "' , '" + term + "' , '" + IsEarlyRepaymentAllowed + "' , '"
                +  IsCreditLineIncreaseAllowed + "' , '" + id + "')";

        statement.execute(query);
    }

    public static void Remove(int id) throws  SQLException{
        try{
            connection = DataBaseConnection.getConnection();
        }catch (SQLException e){
            System.out.println("Eror to get connection");
            e.printStackTrace();
        }

        statement = connection.createStatement();

        String query = "DELETE FROM credits WHERE id = " + id;
        statement.execute(query);
    }

    public static void CloseDB() {
        try {
            connection.close();
            statement.close();
            System.out.println("Database was closed");
        } catch (SQLException e) {
            System.out.println("Error with closing the database!");
        }
    }

}
