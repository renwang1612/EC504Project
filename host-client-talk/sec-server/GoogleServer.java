import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
 
public class GoogleServer {

    private int portNumber ;

    public GoogleServer ( int portNumber )  {
    
        portNumber = this.portNumber ;

        //final int PORT = 4563;
        //SET NEW CONSTANT VARIABLE: PORT
        ServerSocket server = new ServerSocket(portNumber); 
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


    }
}

