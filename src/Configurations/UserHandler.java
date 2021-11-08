package Configurations;

import Controllers.Loaner;
import Controllers.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Configurations.DBHandler.getDbConnection;

public class UserHandler extends Configs{

    public void signUpUser(User user)
    {
        String insert = "INSERT INTO " + ConstUser.USERS_TABLE + "(" +
                ConstUser.USERS_USERNAME +","+
                ConstUser.USERS_NAME +","+
                ConstUser.USERS_SURNAME+","+
                ConstUser.USERS_GENDER+","+
                ConstUser.USERS_PASSPORT+","+
                ConstUser.USERS_BIRTHDAY+","+
                ConstUser.USERS_BIRTHPLACE+","+
                ConstUser.USERS_PHONENUMBER+","+
                ConstUser.USERS_ADDRESS+","+
                ConstUser.USERS_PASSWORD +","+
                ConstUser.USERS_BALANCE +")"+
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getName());
            prSt.setString(3, user.getSurname());
            prSt.setString(4, user.getGender());
            prSt.setString(5, user.getPassportNumber());
            prSt.setString(6, user.getBirthday());
            prSt.setString(7, user.getPlaceofBirth());
            prSt.setString(8, user.getPhoneNumber());
            prSt.setString(9, user.getAddress());
            prSt.setString(10, user.getPassword());
            prSt.setString(11, user.getBalance());
//добавить данные
            prSt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //массив всех значения
    //checking users existence
    public ResultSet getUser(User user){
        ResultSet resSet= null;
        //checking where username and passport are =
        String select =" SELECT * FROM " + ConstUser.USERS_TABLE +" WHERE " + ConstUser.USERS_USERNAME + "=? AND "+ ConstUser.USERS_PASSWORD+"=?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());
            //получить данные
            resSet=prSt.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
    /*
//ino dobare kamelbenevis
 public ResultSet getallusersinfo(User user){
        ResultSet resSet= null;
        //checking where username and passport are =
        String select =" SELECT * FROM " + Const.USERS_TABLE +" WHERE " + Const.USERS_USERNAME + "=? AND "+
                Const.USERS_NAME + "=? AND "+
                Const.USERS_SURNAME+ "=? AND "+ Const.USERS_GENDER++ "=? AND "+ Const.USERS_PASSPORT+ "=? AND "+
                Const.USERS_BIRTHDAY+ "=? AND "+
                Const.USERS_BIRTHPLACE + "=? AND "+
                Const.USERS_PHONENUMBER+ "=? AND "+
                Const.USERS_ADDRESS+ "=? AND "+
                Const.USERS_BALANCE + "=? AND "+
                Const.USERS_PASSWORD+"=?";

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getName());
            prSt.setString(3, user.getSurname());
            prSt.setString(4, user.getGender());
            prSt.setString(5, user.getPassportNumber());
            prSt.setString(6, user.getBirthday());
            prSt.setString(7, user.getPlaceofBirth());
            prSt.setString(8, user.getPhoneNumber());
            prSt.setString(9, user.getAddress());
            prSt.setString(10, user.getBalance());
            prSt.setString(11, user.getPassword());
            //получить данные
            resSet=prSt.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }

*/

    public static boolean delete(User user, String id){

        String delete = "DELETE FROM " + ConstUser.USERS_TABLE + " WHERE "
                + ConstUser.USERS_ID  + " = " + "?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);

            //prSt = user.prepareStatement(delete);
            prSt.setInt(1,Integer.valueOf(id));
            prSt.executeUpdate(delete);
        } catch (SQLException | ClassNotFoundException e) {
            return false;
        }
        return true;
    }


    public static boolean update(User user, String username,String phonenumber, String address, String id){
        String update = "UPDATE"+ ConstUser.USERS_TABLE + "SET"+ ConstUser.USERS_USERNAME + "=?"+ConstUser.USERS_PHONENUMBER+ "=?"+
                ConstUser.USERS_USERNAME +"=?"+ "WHERE"+ ConstUser.USERS_ID  + " = " + "?";
        try {

            PreparedStatement prSt =  getDbConnection().prepareStatement(update);
            //prSt = user.prepareStatement(update);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPhoneNumber());
            prSt.setString(3, user.getAddress());
            prSt.setInt(4, Integer.valueOf(id));
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            return false;
        }
        return true;
    }



    public static List<String> searchUsername(User user, String username){
        List<String> users = new ArrayList<>();
        String query = "SELECT * FROM "+ ConstUser.USERS_TABLE+ " WHERE "+ConstUser.USERS_USERNAME+ " LIKE '" + username + "'";
        System.out.println(username);
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);

            // prSt = user.prepareStatement(query);
            ResultSet rs = prSt.executeQuery(query);

            while(rs.next()){
                StringBuilder str = new StringBuilder();
                str.append(rs.getInt("iduser")).append("|").
                        append(rs.getString("username")).append("|").
                        append(rs.getString("name")).append("|").
                        append(rs.getString("surname"));
                users.add(str.toString());
            }
        } catch (SQLException e) {
            System.out.println(username);
            e.printStackTrace();
        }finally{
            return users;
        }
    };

}
