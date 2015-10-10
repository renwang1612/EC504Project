import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Receive extends Subject implements Runnable {

    private Socket socket;

    public Receive ( Socket s ) {
        socket          = s ;
    }
    
    public void run () {
        try {
            while ( true ) {
                Scanner in      = new Scanner(socket.getInputStream());
                String input    = in.nextLine();
                //IF THERE IS INPUT THEN MAKE A NEW VARIABLE input AND READ WHAT THEY TYPED
                System.out.println("Server Said: " + input);//PRINT IT OUT TO THE SCREEN
                this.notify ( "Server Said: " + input ) ;
            }
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
    }
}
