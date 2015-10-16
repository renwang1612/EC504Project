import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ForwardSocket implements Runnable {

    private Socket inputSocket;
    private Socket outputSocket;

    public ForwardSocket ( Socket inputSocket, Socket outputSocket ) {
        inputSocket         = this.inputSocket ;
        outputSocket        = this.outputSocket ;
    }
    
    public void run () {
        try {
            while ( true ) {
                Scanner in      = new Scanner(inputSocket.getInputStream());
                String input    = in.nextLine();
                System.out.println("Client Said: " + input);//PRINT IT OUT TO THE SCREEN
                System.out.println ( "forward msg:" + input ) ;
                //IF THERE IS INPUT THEN MAKE A NEW VARIABLE input AND READ WHAT THEY TYPED
                PrintWriter output = new PrintWriter(outputSocket.getOutputStream());
                output.println ( input ) ;
                output.flush() ;
            }
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
    }

}
