import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.Socket;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StatusActionListener implements ActionListener{
	private ActionEventFrame actioneventframe;
	
	public StatusActionListener (ActionEventFrame actioneventframe) {
		this.actioneventframe = actioneventframe;
	}
	
	public void actionPerformed (ActionEvent e) {
		File statusfile = new File ("status.txt");
		try {
			BufferedWriter writer = new BufferedWriter ( new FileWriter ( statusfile ));
			writer.write("Total data size: " + actioneventframe.sentamount + " characters, data size in the beginning: " + actioneventframe.readamount + ", final data size: " + actioneventframe.finalamount);
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			System.out.println("File cannot be read!");
		}
		
	}
}
