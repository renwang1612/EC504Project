import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Receive implements Runnable {

    private Socket socket;

    public Receive ( Socket s ) {
        socket          = s ;
    }
    
    public void run () {
        try {
            while ( true ) {
				// Receive input data
                Scanner in      = new Scanner(socket.getInputStream());
				// Read in the next line
                String input    = in.nextLine();
                // If there is input then make a new variable INPUT and read what they typed
                // Print it out to the screen 
				System.out.println("Client Said: " + input);
            }
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
    }

}
