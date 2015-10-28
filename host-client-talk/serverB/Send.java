import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Send implements Runnable {

    private Socket socket ;

    public Send ( Socket s ) {
        socket              = s ;
    }

    public void run () {
        try { 
            while ( true ) {
				// system input
                Scanner chat        = new Scanner ( System.in ) ;
				// send out the message
                PrintWriter out     = new PrintWriter(socket.getOutputStream());
				// input the next line
                String serverTalk   = chat.nextLine () ;
				//print the server send in data
                out.println(serverTalk);
				//flush the stream
                out.flush();
            }
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
        
    }

}
