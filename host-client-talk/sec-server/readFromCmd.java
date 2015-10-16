import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class readFromCmd implements Runnable {

    private Socket socket ;

    public readFromCmd ( Socket s ) {
        socket              = s ;
    }

    public void run () {
        try { 
            while ( true ) {
                Scanner chat        = new Scanner ( System.in ) ;
                PrintWriter out     = new PrintWriter(socket.getOutputStream());
                String serverTalk   = chat.nextLine () ;
                //out.println("Server send: " + serverTalk);//RESEND IT TO THE CLIENT
                out.println(serverTalk);//RESEND IT TO THE CLIENT
                out.flush();//FLUSH THE STREAM
            }
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
        
    }

}
