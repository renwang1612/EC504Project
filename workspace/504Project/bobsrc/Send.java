import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;

class Send implements Runnable {

    private Socket socket ;
    Map<String,Boolean> map ;
    ActionEventFrame actioneventframe;

    public Send (ActionEventFrame actioneventframe, Socket s, Map<String,Boolean> map ) {
    	this.actioneventframe = actioneventframe;
        socket              = s ;
        this.map            = map ;
    }

    public void run () {
        try { 
            //while ( true ) {
            //Scanner chat        = new Scanner ( System.in ) ;
            PrintWriter out     = new PrintWriter(socket.getOutputStream());
            //String serverTalk   = chat.nextLine () ;
            //File file = new File ( "temp.txt" ) ;
            //File file2 = new File ( "tempcheck.txt" ) ;
            // This will reference one line at a time
            //String line = null;
            String buffer = "";

            //String serverTalk     = this.content ;
            //try {
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
                buffer += iterateBuffer + "/t" ;
                //System.out.println(iterateBuffer);
                //BufferedWriter writer2 = new BufferedWriter ( new FileWriter ( file2, true ));
                //writer2.write (iterateBuffer) ;
                //writer2.newLine ( ) ;
                //writer2.flush () ;
                //writer2.close() ;
                
            }
            //BufferedWriter writer1 = new BufferedWriter ( new FileWriter ( file, true ));
            //writer1.write (buffer) ;
            //writer1.newLine ( ) ;
            //writer1.flush () ;
            //writer1.close() ;
            actioneventframe.sentamount += buffer.length();
            out.println(buffer);//RESEND IT TO THE CLIENT
            out.flush();//FLUSH THE STREAM
            out.close();
                // Always close files.
                //bufferedReader.close();         
            //}
            //catch(FileNotFoundException ex) {
            //    System.out.println( "Unable to open file '" + fileName + "'");                
            //}
            //catch(IOException ex) {
            //    System.out.println( "Error reading file '" + fileName + "'");                  
            //    // Or we could just do this: 
            //    // ex.printStackTrace();
            //}
    
            // out.println("Server send: " + serverTalk);//RESEND IT TO THE CLIENT
            //}
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
        
    }

}
