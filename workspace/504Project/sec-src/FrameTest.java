import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

class ActionEventFrame extends Observer {										//build window, 1 button and 1 Text field
	//JButton Click = new JButton();												//extend observer, because try to show message received from
	JTextField text = new JTextField ();										//another data center, so use a observer pattern

    private final static int PORT = 4563;//SET A CONSTANT VARIABLE PORT
    //private final static String HOST = "155.41.73.64";//SET A CONSTANT VARIABLE HOST
    private final static String HOST = "localhost";//SET A CONSTANT VARIABLE HOST
    
    ActionEventFrame () {
        super ();
        setTitle ("540Project");
        setBounds (100, 100, 300, 200);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        Click.setText ("Send");
        try {
            Socket s = new Socket ( HOST , PORT ) ;
            System.out.println("You connected to " + HOST);//IF CONNECTED THEN PRINT IT OUT
            Click.addActionListener (new ButtonActionListener(s, this));
            // Bob's code for receive msg
            Receive receive = new Receive ( s ) ;
            receive.attach (this);
            Thread thread = new Thread ( receive ) ;
            thread.start () ;
        } catch ( Exception noServer ) {
            System.out.println("The server might not be up at this time.");
            System.out.println("Please try again later.");
        }
        text.setPreferredSize (new Dimension (200, 50));
        //text.setText("abcdefg");
        //JPanel pane1 = new JPanel ();
        this. getContentPane() .add (Click, BorderLayout.SOUTH);
        this. getContentPane() .add (Text, BorderLayout.CENTER);
        this. getContentPane() .add (label, BorderLayout.NORTH);
        this.setVisible (true);

    }
}

public class FrameTest {											//main function
	public static void main (String [] args) {
		ActionEventFrame actionEventFrame = new ActionEventFrame ();
		//Sub sub = new Sub();										
		//sub.attach (actionEventFrame);
	}
}
