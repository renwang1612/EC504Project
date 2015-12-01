import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;

public class Receive extends Subject implements Runnable {

    private Socket socket;
    private Map<String,Boolean> map ;

    public Receive ( Socket s, Map<String,Boolean> map) {
        socket          = s ;
        this.map        = map ;
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
                // update the map
                String parts[] = input.split("\\t");
                for ( String substring: parts ) {
                    if ( map.containsKey ( substring ) ) {
                        map.remove ( substring ) ;
                        map.put ( substring, true ) ;
                    }
                }
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
