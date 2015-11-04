import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ActionEventFrame extends Observer {										//build window, 1 button and 1 Text field
	//JButton Click = new JButton();												//extend observer, because try to show message received from
	JTextField text = new JTextField ();										//another data center, so use a observer pattern

    ActionEventFrame () {
        super ();
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
                Click.addActionListener (new ButtonActionListener(this));
                this. getContentPane() .add (Click, BorderLayout.SOUTH);
                this. getContentPane() .add (Text, BorderLayout.CENTER);
                this. getContentPane() .add (label, BorderLayout.NORTH);
                this.setVisible (true);
                System.out.println ( "Waiting for client. " ) ;
                Socket s = server.accept () ;
                System.out.println ( "Client connected from " + s.getLocalAddress().getHostName() ) ;
                Receive receive = new Receive (s) ;
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
