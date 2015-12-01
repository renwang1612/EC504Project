import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.Socket;
import java.io.PrintWriter;

public class ReadActionListener  implements ActionListener{
	private Observer observer;
	public ReadActionListener (Observer observer) {
		this.observer = observer;
	}
	
	public void actionPerformed (ActionEvent e) {
		//fullfill the data structure
	}
}
