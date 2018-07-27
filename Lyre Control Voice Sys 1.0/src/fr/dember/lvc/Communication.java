package fr.dember.lvc;

import fr.dember.lvc.voice.Detection;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Communication {
    
    static Socket socket;
    static PrintWriter pred;
    
    public static void onConnect(){
        String ip = "192.168.1.23";
        int port = 3332;

        try {
            socket = new Socket(ip, port);

            pred = new PrintWriter(
                   new BufferedWriter(
                   new OutputStreamWriter(socket.getOutputStream())),true);
            
            System.out.println("Connection ok !");
            Detection.DetectVocal(Main.main_args);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Connection error !");
        }
    }
    
    public static void onDisconnect(){
        try {
            pred.close();
            socket.close();
            System.out.println("Disconnection ok !");
            Main.label_load.setVisible(false);
            Main.label_detect.setText("Press the connection button to start");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Disconnection error !");
        }
    }
    
    public static void onSendData(String data){
        pred.print(data);
        pred.flush();
    }
    
    public static String getControlsFromNumber(String nb) {
        String t = "";
        for (int i = 0; i != nb.length(); i++) {
            switch (nb.substring(i, i+1)) {
                case "0":
                    t += "FSOC" + (320 + 0 - 1) + "255";
                    break;
                case "1":
                    t += "FSOC" + (320 + 1 - 1) + "255";
                    break;
                case "2":
                    t += "FSOC" + (320 + 2 - 1) + "255";
                    break;
                case "3":
                    t += "FSOC" + (320 + 3 - 1) + "255";
                    break;
                case "4":
                    t += "FSOC" + (320 + 4 - 1) + "255";
                    break;
                case "5":
                    t += "FSOC" + (320 + 5 - 1) + "255";
                    break;
                case "6":
                    t += "FSOC" + (320 + 6 - 1) + "255";
                    break;
                case "7":
                    t += "FSOC" + (320 + 7 - 1) + "255";
                    break;
                case "8":
                    t += "FSOC" + (320 + 8 - 1) + "255";
                    break;
                case "9":
                    t += "FSOC" + (320 + 9 - 1) + "255";
                    break;

            }
        }
        return t;
    }
    
}
