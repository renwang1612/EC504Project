import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class msgSentFromClient implements Runnable {

    private Socket socket;

    public msgSentFromClient ( Socket s ) {
        socket  = s ;
    }
    
    public void run () {
        Scanner in = new Scanner(socket.getInputStream());
        String input = in.nextLine();//IF THERE IS INPUT THEN MAKE A NEW VARIABLE input AND READ WHAT THEY TYPED
        System.out.println("Client Said: " + input);//PRINT IT OUT TO THE SCREEN
    }

}
