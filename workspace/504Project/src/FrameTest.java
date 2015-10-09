import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

class ActionEventFrame extends Observer {										//build window, 1 button and 1 text field
	JButton Click = new JButton();												//extend observer, because try to show message received from
	JTextField text = new JTextField ();										//another data center, so use a observer pattern

    private final static int PORT = 6677;//SET A CONSTANT VARIABLE PORT
    private final static String HOST = "localhost";//SET A CONSTANT VARIABLE HOST
    
    try {
        Socket s = new Socket ( HOST , PORT ) ;
        System.out.println("You connected to " + HOST);//IF CONNECTED THEN PRINT IT OUT

	ActionEventFrame () {
		super ();
		setTitle ("540Project");
		setBounds (100, 100, 300, 200);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Click.setText ("Send");
		Click.addActionListener (new ButtonActionListener(s));
		text.setPreferredSize (new Dimension (200, 50));
		getContentPane () .add (Click, BorderLayout.SOUTH);
		this.setVisible (true);
	}
    } catch ( Exception noServer ) {
        System.out.println("The server might not be up at this time.");
        System.out.println("Please try again later.");
    }
}

public class FrameTest {											//main function
	public static void main (String [] args) {
		ActionEventFrame actionEventFrame = new ActionEventFrame ();
		//Sub sub = new Sub();										
		//sub.attach (actionEventFrame);
	}
}
