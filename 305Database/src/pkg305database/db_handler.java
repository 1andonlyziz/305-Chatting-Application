/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305database;

import java.sql.*;

public class db_handler {

    Connection con;
    Statement stmt;
    ResultSet rs;

    db_handler() throws SQLException {

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
        stmt = con.createStatement();
        rs = null;

    }

    boolean authenticate(String username, String password,String ip,int port) throws SQLException {

        rs = stmt.executeQuery("select email,password from account where email ='" + username + "'");

        while (rs.next()) {

            if (rs.getString("email").equalsIgnoreCase(username) && rs.getString("password").equalsIgnoreCase(password)) {
                System.out.println("DB : Email and password Correct");
              
                try {
                PreparedStatement pstmt = con.prepareStatement("Update account set ip=?, port=?, status=? where email=?");
                pstmt.setString(1, ip);
                pstmt.setInt(2, port);
                pstmt.setBoolean(3,true);
                pstmt.setString(4, username);
                pstmt.execute();
                
               }catch(Exception e){
                   
                   System.out.println("DB : Error updateing user information after login");
                    System.out.println("DB : " + e);
               }
                return true;
            }
        }

        return false;

    }

    boolean registerUser(String username, String password) throws SQLException {
        System.out.println("DB : !!!! ");

        try {
            PreparedStatement stmt = con.prepareStatement("insert into account(email,password) values(?,?)");

            System.out.println("DB : " + username);
            System.out.println("DB : " + password);

            stmt.setString(1, username);
            stmt.setString(2, password);

            if (stmt.executeUpdate() > 0) {
                System.out.println("DB : " + username + " ? " + password + "\nregistered into account table");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    //this method update account status in database when somebody login which is called by authenticate
    void login() throws SQLException {

        rs.updateBoolean("status", true);
    }

    void logout() {

    }

    boolean addUser(String username, String addedUserName) throws SQLException {

        PreparedStatement stmt = con.prepareStatement("insert into added_users(user,addedUser) values(?,?)");
        stmt.setString(1, username);
        stmt.setString(1, addedUserName);

        try {
            if (stmt.executeUpdate() > 0) {
                System.out.println("DB : UserName " + username + "has added : " + addedUserName);
                return true;
            } else {
                System.out.println("DB : Failed to add a userName ");
                return false;
            }
        } catch (Exception e) {
            System.out.println("DB : Exceptio Occuerd while adding a Username");
        }
        return false;

    }

    public void userList(String userName) throws SQLException {

        rs = stmt.executeQuery("select * from added users where email = '" + userName);
        while(rs.next()){
            
        }
    }
}
