import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ForwardSocket implements Runnable {

    private Socket inputSocket;
    private Socket outputSocket;

    public ForwardSocket ( Socket inputSocket, Socket outputSocket ) {
        this.inputSocket         = inputSocket ;
        this.outputSocket        = outputSocket ;
    }
    
    public void run () {
        try {
            while ( true ) {
				// get input data
                Scanner in      = new Scanner(inputSocket.getInputStream());
				// go to next line next time
                String input    = in.nextLine();
				// What the input data is 
                System.out.println("Client Said: " + input);//PRINT IT OUT TO THE SCREEN
				// forwarding data
                System.out.println ( "forward msg:" + input ) ;
                // If there is input then make a new variable INPUT and read what they typed
                PrintWriter output = new PrintWriter(outputSocket.getOutputStream());
				// Forward data directly
                output.println ( input ) ;
                output.flush() ;
            }
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
    }

}
