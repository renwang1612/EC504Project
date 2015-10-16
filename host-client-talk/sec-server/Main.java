import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
 
public class Main {

    public static void main(String[] args) throws IOException {

        try {

            final int PORT = 4562;
            //SET NEW CONSTANT VARIABLE: PORT
            ServerSocket server = new ServerSocket(PORT); 
            //SET PORT NUMBER
            System.out.println("Waiting for clients...");
            //AT THE START PRINT THIS

            Socket s        = server.accept();
            System.out.println("Client connected from " + s.getLocalAddress().getHostName());   

            // This port is facing the other server
            final int SERVERPORT = 4564 ;
            ServerSocket ServerServer       = new ServerSocket ( SERVERPORT ) ;
            Socket serverS                  = ServerServer.accept () ;
            System.out.println("Another Server is connected from " + serverS.getLocalAddress().getHostName() ) ;

            readFromCmd cmdline             = new readFromCmd ( s ) ;
            msgSentFromClient readClient    = new msgSentFromClient ( s ) ;
            ForwardSocket forwardsocket     = new ForwardSocket ( s , serverS ) ;
            Thread thread1                  = new Thread ( cmdline ) ;
            Thread thread2                  = new Thread ( readClient ) ;
            Thread thread3                  = new Thread ( forwardsocket ) ;
            thread1.start () ;
            thread2.start () ;
            thread3.start () ;
        
         
            // while (true) {
            //WHILE THE PROGRAM IS RUNNING 

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
        }

        catch (Exception e) {
            System.out.println("An error occured.");
            //IF AN ERROR OCCURED THEN PRINT IT
            e.printStackTrace();
        }
    }
}

