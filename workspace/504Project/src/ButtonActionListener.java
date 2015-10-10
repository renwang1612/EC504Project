import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.Socket;
import java.io.PrintWriter;

public class ButtonActionListener implements ActionListener{							//Button action, build a new 
    private Socket socket ;

    public ButtonActionListener ( Socket s ) {
        socket          = s ;
    }

	public void actionPerformed (ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String buttonName = e.getActionCommand();
		if (buttonName.equals("Send")) {
			JOptionPane.showMessageDialog(null, "Button clicked!", "Message", JOptionPane.INFORMATION_MESSAGE);
			//call the communication function written by Bob here
            
            Send send = new Send (socket) ;
            Thread thread = new Thread ( send ) ;
            thread.start () ;
        }
	}
}
