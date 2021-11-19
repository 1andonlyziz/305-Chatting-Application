package GUI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {
    public static  Main mm;
    static int choice = 0;
    
    public static int getChoice() {
        return choice;
    }

    public static void setChoice(int choice) {
        Main.choice = choice;
    }

    public Main() throws IOException {
        initComponents();
        ErrorLoginLbl.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        userName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        ErrorLoginLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username :");

        jLabel2.setText("Password : ");

        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ErrorLoginLbl.setForeground(new java.awt.Color(255, 0, 0));
        ErrorLoginLbl.setText("Wrong Username / password please check your information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(165, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(password))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ErrorLoginLbl)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addComponent(ErrorLoginLbl)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Login Button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            choice = 1;
            Socket soc = new Socket("localhost", 1951);
            new receiver(soc).start();
            new sender(soc).start();
        } catch (IOException ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //register button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

      mm =this;
         this.setVisible(false);
        new Register1(this).setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel ErrorLoginLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPasswordField password;
    public static javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}

class receiver extends Thread {

    Socket soc;

    receiver(Socket s) {
        soc = s;
    }

    public void run() {
        InputStream is = null;

        try {
            is = soc.getInputStream(); //fis
            Scanner sc = new Scanner(is);
            String line;
            while (true) {

                switch (Main.choice) {

                    case 1: //----- thiss is coming from server in case of login 
                        line = sc.nextLine();
                        System.out.println(line);
                        if (line.equals("1")) { // in case of true
                            System.out.println("Logged IN ");
                            new ContactList().setVisible(true);
                            Main.ErrorLoginLbl.setVisible(false);

                        } else {

                            System.out.println("ERROR LOGIN ");
                            Main.ErrorLoginLbl.setVisible(true);
                        }
                        break;

                    case 2: //------ this is coming from server in case of registeration
                        String input = sc.nextLine(); // take input from server

                        if (input.equals("2")) {

                            Register1.userCreated.setVisible(true);
                        } else {

                            Register1.usernameRegistered.setVisible(true);
                        }

                        break;
                    case 3: //addUser

                        input = sc.nextLine();

                        if (input.equals("1")) {
                            System.out.println("Client : User Added");
                        } else if (input.equals("2")) {
                            System.out.println("Client : User not added");
                        }
                    case 4: //get chatting information port and inetAddress
                          
                        String port =sc.nextLine();
                        String ip = sc.nextLine();

                }
                break;
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

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class sender extends Thread {

    Socket soc;

    sender(Socket s) {
        soc = s;
    }

    public void run() {
        try {
            OutputStream os = soc.getOutputStream();//fos
            PrintWriter wrt = new PrintWriter(os, true);
            switch (Main.choice) {
                case 1: //login button
                    wrt.println("1");
                    wrt.println(Main.userName.getText());
                    wrt.println(Main.password.getText());
                    break;
                case 2: //register button

                    wrt.println("2"); // send to the server choice 2 which is account creation
                    //System.out.println(Register1.getUsername().getText()); // debug message
                    // System.out.println(Register1.getPassword().getText()); // debug message
                    wrt.println(Register1.username.getText()); // send to the server username and password
                    wrt.println(Register1.password.getText());
                    break;
                case 3: //ContactList -> AddUser Button  - > Confirm Button;

                    wrt.println("3");
                    wrt.println(ContactList.LoggedInUserNameLbl.getText());
                    wrt.println(ContactList.TextFieldUserName.getText());   
            }

        } catch (IOException ex) {
            System.out.println("Client Sender Excpetion : " + ex);
        }
    }
}
