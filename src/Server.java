import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 4999
            ServerSocket ss = new ServerSocket(4999);
            System.out.println("Server is running and waiting for a client to connect...");

            // Accept a client connection
            Socket s = ss.accept();
            System.out.println("Client connected");

            // To receive data from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            // To send data to the client
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("Hello, client!");

            // Close the streams and socket
            in.close();
            out.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
