import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
// Read from file
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;

class ActionEventFrame extends Observer {										//build window, 1 button and 1 Text field
	//JButton Click = new JButton();												//extend observer, because try to show message received from
	JTextField text = new JTextField ();										//another data center, so use a observer pattern
	JButton Clickread = new JButton();
	JButton Status = new JButton();
	String Address = null;
	int sentamount = 0;
	int readamount = 0;
	int finalamount = 0;
    boolean ifsent = false ;
    // construct a data structure that holds all values
    Map<String, Boolean> map = new HashMap<String, Boolean>();//<String, int> better
    BufferedReader in ;

    ActionEventFrame () {
        super ();
        try{
            in = new BufferedReader(new FileReader("DC2-sampleQueries.txt"));
        }
        catch(IOException ex) {
            System.out.println( "Error reading file");
        }
        setTitle ("540Project");
        setBounds (100, 100, 300, 200);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        Click.setText ("Send");
        try {
                int PORT = 4563 ;
                ServerSocket server = new ServerSocket ( PORT ) ;
                text.setPreferredSize (new Dimension (200, 50));
                //text.setText("abcdefg");
                //JPanel pane1 = new JPanel ();
                Click.addActionListener (new ButtonActionListener(this,map));
                Clickread.setText("Read");
                Clickread.addActionListener (new ReadActionListener(this,in,map));
                Status.setText("Check Status");
                Status.addActionListener (new StatusActionListener(this));
                this. getContentPane() .add (Click, BorderLayout.EAST);
                this. getContentPane() .add (Clickread, BorderLayout.WEST);
                this. getContentPane() .add (Status, BorderLayout.SOUTH);
                this. getContentPane() .add (Text, BorderLayout.CENTER);
                this. getContentPane() .add (label, BorderLayout.NORTH);
                this.setVisible (true);
                System.out.println ( "Waiting for client. " ) ;
                Socket s = server.accept () ;
                System.out.println ( "Client connected from " + s.getLocalAddress().getHostName() ) ;
                Address = s.getInetAddress().toString();
                Address = Address.substring(1, Address.length());
                System.out.println(Address);
                Receive receive = new Receive (this, s, map) ;
                receive.attach (this) ;
                Thread thread = new Thread ( receive ) ;
                thread.start() ;
        } catch ( Exception e ) {
                System.out.println ( "No server. " ) ;
        }

            // Bob's code for receive msg
        //} catch ( Exception noServer ) {
        //    System.out.println("The server might not be up at this time.");
        //    System.out.println("Please try again later.");
        //}

    }
}

public class FrameTest {											//main function
	public static void main (String [] args) {
		ActionEventFrame actionEventFrame = new ActionEventFrame ();
		//Sub sub = new Sub();										
		//sub.attach (actionEventFrame);
	}
}
