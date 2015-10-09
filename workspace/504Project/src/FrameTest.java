import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ActionEventFrame extends Observer {										//build window, 1 button and 1 text field
	JButton Click = new JButton();												//extend observer, because try to show message received from
	JTextField text = new JTextField ();										//another data center, so use a observer pattern
	ActionEventFrame () {
		super ();
		setTitle ("540Project");
		setBounds (100, 100, 300, 200);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Click.setText ("Send");
		Click.addActionListener (new ButtonActionListener());
		text.setPreferredSize (new Dimension (200, 50));
		getContentPane () .add (Click, BorderLayout.SOUTH);
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
