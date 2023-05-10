package cn4000.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 5678);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String input;

            while((input = keyboard.readLine()) != null){
                out.println(input);
                String serverResponse = in.readLine();
                System.out.println("Server response is: " + serverResponse);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
