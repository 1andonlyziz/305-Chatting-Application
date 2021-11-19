/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package pkg305database;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Main {

//tcp server
    Server() throws IOException, ClassNotFoundException, SQLException {
        ServerSocket srv = new ServerSocket(1951);
        while (true) {
            System.out.println("Server : server connection established");
            Socket soc = srv.accept();
            new receiver(soc).start();

        }
    }

}

// reciever and sender Thread
class receiver extends Thread {

    Socket soc;

    receiver(Socket s) {
        soc = s;
    }

    boolean login(String username, String password, String ip, int port) throws ClassNotFoundException, SQLException {

        db_handler db = new db_handler();

        boolean auth = db.authenticate(username, password, ip, port);

        return auth;

    }

    boolean register(String username, String password) throws SQLException {

        db_handler db = new db_handler();

        boolean registeration = db.registerUser(username, password);

        return registeration;
    }

    public void run() {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = soc.getInputStream(); //fis
            os = soc.getOutputStream();
            Scanner scan = new Scanner(is);
            PrintWriter wrt = new PrintWriter(os, true);

            String line;

            while (true) {

                try {

                    line = scan.nextLine();
                    System.out.println("From " + soc.toString() + " : " + line);

                    switch (line) {
                        case "1": //--- Account login
                        {
                            System.out.println("Server : i'm checking credintials");
                            String username = scan.nextLine();
                            String password = scan.nextLine();

                            boolean login = login(username, password, soc.getInetAddress().toString(), soc.getPort());

                            if (login) {

                                wrt.println("1");
                                System.out.println("Server : LoggedIn");

                                break;

                            } else if (!login) {

                                wrt.println("2");
                                System.out.println("Serverr : couldnt login wrong credintials");
                                break;
                            }

                        }
                        case "2": //--- Account creation
                        {
                            System.out.println("Server : i'm registering the account");

                            String username = scan.nextLine();
                            String password = scan.nextLine();

                            // System.out.println(username + "?" + password); debug message
                            boolean register = register(username, password);

                            if (register) {
                                System.out.println("Server : Account Created " + username + " , " + password);
                                wrt.println("2"); // message 2  username created successfully to client reciever
                            } else if (!register) {
                                System.out.println("Server : Account Already Created.");
                                wrt.println("3"); // message 3 usernameAlready Reigsterd to client reciever
                            }
                            break;
                        }
                        case "3": // in case of requesting chatting information;
                            wrt.println(soc.getPort());
                            System.out.println(soc.getPort());
                            wrt.println(soc.getInetAddress());
                            System.out.println(soc.getInetAddress());
                            break;
                        default:
                            break;
                    }

                } catch (NoSuchElementException ex) {

                    break;

                } catch (ClassNotFoundException ex) {

                } catch (SQLException ex) {

                }

            }
            soc.shutdownInput();
        } catch (IOException ex) {

        } finally {
            try {
                is.close();
            } catch (IOException ex) {

            }
        }
    }
}
