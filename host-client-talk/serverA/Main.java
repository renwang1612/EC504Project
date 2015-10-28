import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
 
public class Main {

    public static void main(String[] args) throws IOException {
        
        try {

            final String HOST        = "localhost" ;
            // This port is facing the other clients
            final int PORT                  = 4563;
            // This port is facing the other server
            final int ServerClientPORT      = 4564;
            //SET NEW CONSTANT VARIABLE: PORT
            ServerSocket server = new ServerSocket(PORT); 
            //SET PORT NUMBER
            System.out.println("Waiting for clients...");
            //AT THE START PRINT THIS

          	// Once the server is successfully connected with client
		    Socket s        = server.accept();
            System.out.println("Client connected from " + s.getLocalAddress().getHostName());   

            Send send             			= new Send ( s ) ;
            Receive receive    				= new Receive ( s ) ;
            Thread thread1                  = new Thread ( send ) ;
            Thread thread2                  = new Thread ( receive ) ;
            thread1.start () ;
            thread2.start () ;
            
            Socket ServerClient             = new Socket ( HOST , ServerClientPORT ) ;
            System.out.println("Server connected");   

            Receive receiveFromServerB      = new Receive ( ServerClient ) ;
            Thread thread3                  = new Thread ( receiveFromServerB ) ;
            thread3.start () ;

        }

        catch (Exception e) {
            System.out.println("An error occured.");
            //If an error occured then print it
            e.printStackTrace();
        }
    }
}

