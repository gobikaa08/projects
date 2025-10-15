package mynewproject;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1234;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage = input.readLine();
            System.out.println("Received from client: " + clientMessage);

            output.println("Hello from server!");

            clientSocket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}