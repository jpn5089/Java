//*********************************************************************************************************************
//                                                     JP Nicola
//                                                      CPMA 535
//                                           Tic Tac Toe Game - Client Portion 
//*********************************************************************************************************************

import java.io.*;
import java.net.*;

public class TicTacToeClient {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try {
            Socket tttSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(tttSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(tttSocket.getInputStream()));
        
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            
            // read message from server
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: \n" + fromServer.replace("\t","\n"));
                if (fromServer.equals("The game is a tie!") || fromServer.equals("The winner is X!")
                      || fromServer.equals("The winner is O!")) {
                    break;
                }
                // read user input move 
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Player: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}
