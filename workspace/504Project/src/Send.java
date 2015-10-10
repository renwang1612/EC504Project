import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Send implements Runnable {

    private Socket socket ;
    private String content ;

    public Send ( Socket s , String content) {
        socket              = s ;
        this.content 		= content;
    }

    public void run () {
        try { 
            //while ( true ) {
            Scanner chat        = new Scanner ( System.in ) ;
            PrintWriter out     = new PrintWriter(socket.getOutputStream());
            //String serverTalk   = chat.nextLine () ;
            String serverTalk     = this.content ;
            // out.println("Server send: " + serverTalk);//RESEND IT TO THE CLIENT
            out.println(serverTalk);//RESEND IT TO THE CLIENT
            out.flush();//FLUSH THE STREAM
            //}
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
        
    }

}
