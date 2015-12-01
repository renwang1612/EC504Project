import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Receive extends Subject implements Runnable {

    private Socket socket;

    public Receive ( Socket s ) {
        socket          = s ;
    }
    
    public void run () {
        try {
            File file = new File ( "Result.txt" ) ;
            BufferedWriter writer = new BufferedWriter ( new FileWriter ( file ));
            writer.write ("" ) ;
            writer.flush () ;
            writer.close() ;
            while ( true ) {
                Scanner in      = new Scanner(socket.getInputStream());
                String input    = in.nextLine();
                //IF THERE IS INPUT THEN MAKE A NEW VARIABLE input AND READ WHAT THEY TYPED
                System.out.println("Server Said: " + input);//PRINT IT OUT TO THE SCREEN
                this.notify ( "Server Said: " + input ) ;
                BufferedWriter writer1 = new BufferedWriter ( new FileWriter ( file, true ));
                writer1.write (input ) ;
                writer1.newLine ( ) ;
                writer1.flush () ;
                writer1.close() ;
            }
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
    }
}
