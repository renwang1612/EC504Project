import java.io.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;

class Send implements Runnable {

    private Socket socket ;
    private String content ;
    Map<String,String> map ;

    public Send ( Socket s , String content, Map<String,String> map ) {
        socket              = s ;
        this.content 		= content ;
        this.map            = map ;
    }

    public void run () {
        try { 
            //while ( true ) {
            //Scanner chat        = new Scanner ( System.in ) ;
            PrintWriter out     = new PrintWriter(socket.getOutputStream());
            //String serverTalk   = chat.nextLine () ;
            String fileName = "temp.txt";

            // This will reference one line at a time
            String line = null;
            String buffer = null;

            String serverTalk     = this.content ;
            try {
            	// traverse the data structure and out the comment of each node to another UI
                // FileReader reads text files in the default encoding.
                // FileReader fileReader = new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                // BufferedReader bufferedReader = new BufferedReader(fileReader);

                /*while((line = bufferedReader.readLine()) != null) {
                    buffer = buffer + "\\n" ;
                    buffer = buffer + line ;
                    System.out.println(buffer);
                } */
                //System.out.println(buffer);
                for ( String iterateBuffer: map.keySet() ) {
                    buffer = iterateBuffer ;
                }
                out.println(buffer);//RESEND IT TO THE CLIENT
                out.flush();//FLUSH THE STREAM

                // Always close files.
                //bufferedReader.close();         
            }
            catch(FileNotFoundException ex) {
                System.out.println( "Unable to open file '" + fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println( "Error reading file '" + fileName + "'");                  
                // Or we could just do this: 
                // ex.printStackTrace();
            }
    
            // out.println("Server send: " + serverTalk);//RESEND IT TO THE CLIENT
            //}
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
        
    }

}
