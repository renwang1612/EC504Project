import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class readFromCmd implements Runnable {

    private Socket socket ;

    public readFromCmd ( Socket s ) {
        Thread thread       = new Thread ( this ) ;
        socket              = s ;
        thread.start () ;
    }

    public void run () {
        try { 
            Scanner chat        = new Scanner ( System.in ) ;
            PrintWriter out     = new PrintWriter(socket.getOutputStream());
            String serverTalk   = chat.nextLine () ;
            out.println("Server send: " + serverTalk);//RESEND IT TO THE CLIENT
            out.flush();//FLUSH THE STREAM
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
        
    }

}
