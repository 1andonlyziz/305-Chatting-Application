
package GUI;

import static GUI.Chat.jTextArea1;
import static GUI.Chat.jTextField1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class udpSender extends Thread {

    DatagramSocket soc;
    int port;

    udpSender(DatagramSocket so, int port) {
        this.soc = so;

        this.port = port;
    }

    public void run() {

        DatagramPacket pkt = null;
        InetAddress inet = null;

        Scanner scan = new Scanner(System.in);
        byte[] B;
        String line = "";
        
            try {
                inet = InetAddress.getLocalHost();
                
                line = ContactList.LoggedInUserNameLbl.getText() + " : " + jTextField1.getText();
                B = line.getBytes();
                pkt = new DatagramPacket(B, B.length, inet, this.port); //whom you want to send information
                
                soc.send(pkt);

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

class udpReceiver extends Thread {

    DatagramSocket soc;
    public static String message;

    udpReceiver(DatagramSocket so) {
        soc = so;
    }

    public void run() {

        DatagramPacket pkt = null;
        byte[] B;
        String line = "";
        while (true) {
            B = new byte[100];
            pkt = new DatagramPacket(B, B.length);
            try {
                soc.receive(pkt);
                line = bytetoString(pkt.getData(), pkt.getLength());
                String message = line;
                jTextArea1.setText(jTextArea1.getText() + '\n' + message);
               // jTextField1.setText("");
                if (line.equalsIgnoreCase("bye")) {
                    break;
                }

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    String bytetoString(byte[] B, int l) {
        String s = "";
        for (int i = 0; i < l; i++) {
            s += (char) B[i];
        }
        return s;
    }
}
