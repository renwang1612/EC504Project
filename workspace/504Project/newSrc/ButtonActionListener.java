import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;

public class ButtonActionListener implements ActionListener{							//Button action, build a new 
    private Socket socket ;
    private String content;
    ActionEventFrame observer;
    Map<String,Boolean> map ;
    private final static int PORT = 4563;//SET A CONSTANT VARIABLE PORT

    public ButtonActionListener ( ActionEventFrame observer, Map<String,Boolean> map ) {
        this.observer   = observer;
        this.map        = map ;
    }

	public void actionPerformed (ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String buttonName = e.getActionCommand();
		if (buttonName.equals("Send")) {
			//JOptionPane.showMessageDialog(null, "Button clicked!", "Message", JOptionPane.INFORMATION_MESSAGE);
			//call the communication function written by Bob here
            content = observer.getTextAndClean();
            observer.Address =  content;
        try {
            System.out.println("You are connecting to " + content);//IF CONNECTED THEN PRINT IT OUT
            socket = new Socket ( content , PORT ) ;
            System.out.println("You connected to " + content);//IF CONNECTED THEN PRINT IT OUT
        } catch ( Exception noServer ) {
            System.out.println("The server might not be up at this time.");
            System.out.println("Please try again later.");
        }

            Send send = new Send (socket, "test", map) ;
            Thread thread = new Thread ( send ) ;
            thread.start () ;
        }
	}
}
