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
            PrintWriter out     = new PrintWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter ( new FileWriter ( file ));
            writer.write ("" ) ;
            writer.flush () ;
            writer.close() ;
            while ( true ) {
                String buffer = null;
                Scanner in      = new Scanner(socket.getInputStream());
                BufferedWriter writer1 = new BufferedWriter ( new FileWriter ( file, true ));
                String input    = in.nextLine();
                //IF THERE IS INPUT THEN MAKE A NEW VARIABLE input AND READ WHAT THEY TYPED
                System.out.println("Server Said: " + input);//PRINT IT OUT TO THE SCREEN
                this.notify ( "Server Said: " + input ) ;
                // update the map
                String parts[] = input.split("/t");
                for ( String substring: parts ) {
                    if ( map.containsKey ( substring ) ) {
                        map.remove ( substring ) ;
                        map.put ( substring, true ) ;
                    } else {
                        map.put ( substring, true ) ;
                    }
                }
                for ( String iterateBuffer: map.keySet() ) {
                    writer1.write ( substring ) ;
                    writer1.newLine () ;
                	if (map.get(iterateBuffer) == false) {
                		System.out.println(iterateBuffer);
                		buffer += iterateBuffer + "/t" ;
                	}
                }
                writer1.flush () ;
                writer1.close() ;
                if (buffer != null) {
                	out.println(buffer);
                	out.flush();
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
    }
}
