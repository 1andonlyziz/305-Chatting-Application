/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static java.lang.String.valueOf;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ContactList extends javax.swing.JFrame {

    public static int port; //connected to port
    public static int myPort;//myPort
    static DefaultTableModel tblModel;

    
    public static int getPort() {
        return port;
    }

    public static int getMyPort() {
        return myPort;
    }
    
    

    public ContactList() {

        initComponents();
        LoggedInUserNameLbl.setText(Main.userName.getText());

        refreshList();
        
         try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project", "root", "");
            Statement stmt = con.createStatement();
            String sql = "select port from account where email ='" + LoggedInUserNameLbl.getText() + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                myPort = Integer.parseInt(rs.getString("port"));

            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error in retrieving port number");
            System.out.println(e);
        }
        
        
        TextFieldUserName.setVisible(false);
        userNameBtn.setVisible(false);
        usernameLabel.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextFieldUserName = new javax.swing.JTextField();
        userNameBtn = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LoggedInUserNameLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setText("Add User");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Contact List");

        TextFieldUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldUserName.setToolTipText("Username");

        userNameBtn.setText("Confirm");
        userNameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameBtnActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username : ");

        jLabel2.setText("Logged In As : ");

        LoggedInUserNameLbl.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(LoggedInUserNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userNameBtn)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LoggedInUserNameLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        TextFieldUserName.setVisible(true);
        userNameBtn.setVisible(true);
        usernameLabel.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    //confirm button when user Added
    private void userNameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameBtnActionPerformed

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project", "root", "");
            Statement stmt = con.createStatement();

            PreparedStatement prestmt = con.prepareStatement("insert into added_user(user,added_user) values(?,?)");

            prestmt.setString(1, LoggedInUserNameLbl.getText());
            prestmt.setString(2, TextFieldUserName.getText());

            prestmt.execute();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        refreshList();

    }//GEN-LAST:event_userNameBtnActionPerformed

    public static void refreshList() {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project", "root", "");
            Statement stmt = con.createStatement();
            String sql = "select added_user from added_user where user ='" + LoggedInUserNameLbl.getText() + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String username = rs.getString("added_User");

                String lstData[] = {username, "offline"};
                tblModel = (DefaultTableModel) jTable1.getModel();

                tblModel.addRow(lstData);
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //contact list on mouse clicked
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int selectedChat = jTable1.getSelectedRow();
        System.out.println(jTable1.getSelectedRow());
        tblModel.getValueAt(selectedChat, 0).toString();
        
        //-------------------------------------------------
         try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/project", "root", "");
            Statement stmt = con.createStatement();
            String sql = "select port from account where email ='" + tblModel.getValueAt(selectedChat, 0).toString() + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                port = Integer.parseInt(rs.getString("port"));

            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error in retrieving port number");
            System.out.println(e);
        }
        
        

        Chat clientchat;
        try {
            clientchat = new Chat();
            clientchat.setVisible(true);
        } catch (SocketException ex) {
            Logger.getLogger(ContactList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ContactList.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel LoggedInUserNameLbl;
    public static javax.swing.JTextField TextFieldUserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JButton userNameBtn;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
