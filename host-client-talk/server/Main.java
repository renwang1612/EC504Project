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

            Socket s        = server.accept();
            System.out.println("Client connected from " + s.getLocalAddress().getHostName());   

            readFromCmd cmdline             = new readFromCmd ( s ) ;
            msgSentFromClient readClient    = new msgSentFromClient ( s ) ;
            Thread thread1                  = new Thread ( cmdline ) ;
            Thread thread2                  = new Thread ( readClient ) ;
            thread1.start () ;
            thread2.start () ;
         
            // while (true) {//WHILE THE PROGRAM IS RUNNING 

            //     Socket s        = server.accept();
            //     //ACCEPT SOCKETS(CLIENTS) TRYING TO CONNECT
            //     System.out.println("Client connected from " + s.getLocalAddress().getHostName());   
            //     //  TELL THEM THAT THE CLIENT CONNECTED

            //     Client chat     = new Client(s);
            //     //CREATE A NEW CLIENT OBJECT
            //     Thread t        = new Thread(chat);
            //     //MAKE A NEW THREAD
            //     t.start();
            //     //START THE THREAD
            // }
            
            Socket ServerClient             = new Socket ( HOST , ServerClientPORT ) ;
            System.out.println("Server connected");   

            msgSentFromClient receive       = new msgSentFromClient ( ServerClient ) ;
            Thread thread3                  = new Thread ( receive ) ;
            thread3.start () ;

        }

        catch (Exception e) {
            System.out.println("An error occured.");
            //IF AN ERROR OCCURED THEN PRINT IT
            e.printStackTrace();
        }
    }
}

