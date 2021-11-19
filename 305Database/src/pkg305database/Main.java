/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305database;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
         
        try {
            //open server Socket
            System.out.println("Trying to connect to server");
            Server srv = new Server(); //Establish TCP connection through Server.java     
        } catch (IOException e) {
            System.out.println("Exception in establising server : " + e);
        }
        
    }
}
