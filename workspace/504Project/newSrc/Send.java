import java.io.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Send implements Runnable {

    private Socket socket ;
    private String content ;

    public Send ( Socket s , String content) {
        socket              = s ;
        this.content 		= content;
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
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    buffer = buffer + "\\n" ;
                    buffer = buffer + line ;
                    System.out.println(buffer);
                }   
                System.out.println(buffer);
                out.println(buffer);//RESEND IT TO THE CLIENT
                out.flush();//FLUSH THE STREAM

                // Always close files.
                bufferedReader.close();         
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
