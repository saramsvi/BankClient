package Configurations;

import Controllers.Loaner;
import Controllers.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Configurations.DBHandler.getDbConnection;

public class LoanerHandler extends Configs{

    public void NewLoanUser(Loaner loaner)
    {
        String insertt = "INSERT INTO " + ConstLoaner.LOAN_TABLE+ "(" +
                ConstLoaner.LOAN_USERNAME +","+
                ConstLoaner.LOAN_REASON+","+
                ConstLoaner.LOAN_AMOUNT+","+
                ConstLoaner.LOAN_TIME+","+
                ConstLoaner.LOAN_OCCUPATION+","+
                ConstLoaner.LOAN_SALARY+","+
                ConstLoaner.LOAN_MSTATUS+","+
                ConstLoaner.LOAN_KIDS+")"+
                "VALUES(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement prStt = getDbConnection().prepareStatement(insertt);
            prStt.setString(1, loaner.getLUsername());
            prStt.setString(2, loaner.getLReason());
            prStt.setString(3, loaner.getLAmount());
            prStt.setString(4, loaner.getLTime());
            prStt.setString(5, loaner.getLOccupation());
            prStt.setString(6, loaner.getLSalary());
            prStt.setString(7, loaner.getLMstatus());
            prStt.setString(8, loaner.getLKids());

//добавить данные
            prStt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
