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

            String serverTalk       = "This is Client." ;
            PrintWriter out         = new PrintWriter(socket.getOutputStream());
            out.println(serverTalk);//RESEND IT TO THE CLIENT
            out.flush();//FLUSH THE STREAM
		}
	}
}
