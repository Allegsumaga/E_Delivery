import java.net.*;
import java.io.*;

public class Login {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4999);
            System.out.println("Connected to the server!");

            // To send data to the server
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("Hello, server!");

            // To receive data from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("Server says: " + serverResponse);

            // Close the streams and socket
            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Launch the GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
}
