package mynewproject;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 1234;

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("Hello from client!");
            String serverResponse = input.readLine();
            System.out.println("Received from server: " + serverResponse);

            socket.close();
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}