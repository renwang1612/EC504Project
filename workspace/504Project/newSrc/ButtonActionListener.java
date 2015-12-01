import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.Socket;
import java.io.PrintWriter;

public class ButtonActionListener implements ActionListener{							//Button action, build a new 
    private Socket socket ;
    private String content;
    Observer observer;
    private final static int PORT = 4563;//SET A CONSTANT VARIABLE PORT

    public ButtonActionListener ( Observer observer) {
        this.observer = observer;
    }

	public void actionPerformed (ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String buttonName = e.getActionCommand();
		if (buttonName.equals("Send")) {
			//JOptionPane.showMessageDialog(null, "Button clicked!", "Message", JOptionPane.INFORMATION_MESSAGE);
			//call the communication function written by Bob here
            content = observer.getTextAndClean();

        try {
            System.out.println("You are connecting to " + content);//IF CONNECTED THEN PRINT IT OUT
            socket = new Socket ( content , PORT ) ;
            System.out.println("You connected to " + content);//IF CONNECTED THEN PRINT IT OUT
        } catch ( Exception noServer ) {
            System.out.println("The server might not be up at this time.");
            System.out.println("Please try again later.");
        }

            Send send = new Send (socket, "test") ;
            Thread thread = new Thread ( send ) ;
            thread.start () ;
        }
	}
}
