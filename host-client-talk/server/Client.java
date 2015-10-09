import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
 
public class Client implements Runnable{

    private Socket socket;
    //SOCKET INSTANCE VARIABLE

    public Client(Socket s) {
        socket = s; 
        //INSTANTIATE THE SOCKET
    }

    @Override
    public void run() { 
        //(IMPLEMENTED FROM THE RUNNABLE INTERFACE)
    
        try { 
            while (true) {
                readFromCmd cmdline             = new readFromCmd (socket) ;
                msgSentFromClient readClient    = new msgSentFromClient (socket) ;
                Thread writeThread              = new Thread ( cmdline ) ;
                Thread readThread               = new Thread ( readClient ) ;
                readThread.start() ;
                writeThread.start() ;
            }
/******************************************************************************************************************************
            // Here is my modification: the server can also talk to the client
            Scanner chat  = new Scanner(System.in) ;
            //HAVE TO HAVE THIS FOR THE in AND out VARIABLES
            Scanner in = new Scanner(socket.getInputStream());
            //GET THE SOCKETS INPUT STREAM (THE STREAM THAT YOU WILL GET WHAT THEY TYPE FROM)
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //GET THE SOCKETS OUTPUT STREAM (THE STREAM YOU WILL SEND INFORMATION TO THEM FROM)

            while (true) { 
                //WHILE THE PROGRAM IS RUNNING
                String serverTalk = chat.nextLine();
                //System.out.println("Server Said: " + serverTalk);//PRINT IT OUT TO THE SCREEN
                if (in.hasNext()) {
                    String input = in.nextLine();//IF THERE IS INPUT THEN MAKE A NEW VARIABLE input AND READ WHAT THEY TYPED
                    System.out.println("Client Said: " + input);//PRINT IT OUT TO THE SCREEN
                    out.println("Server send: " + serverTalk);//RESEND IT TO THE CLIENT
                    out.flush();//FLUSH THE STREAM
                }
            }
******************************************************************************************************************************/
        }

        catch (Exception e) {
            e.printStackTrace();//MOST LIKELY THERE WONT BE AN ERROR BUT ITS GOOD TO CATCH
        }  
    }
}


