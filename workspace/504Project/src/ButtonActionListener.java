import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonActionListener implements ActionListener{							//Button action, build a new 
	public void actionPerformed (ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String buttonName = e.getActionCommand();
		if (buttonName.equals("Send")) {
			JOptionPane.showMessageDialog(null, "Button clicked!", "Message", JOptionPane.INFORMATION_MESSAGE);
			//call the communication function written by Bob here
		}
	}
}
