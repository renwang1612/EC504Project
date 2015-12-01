import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.Socket;
import java.io.PrintWriter;

public class ReadActionListener  implements ActionListener{
	private ActionEventFrame actioneventframe;
	public ReadActionListener (ActionEventFrame actioneventframe) {
		this.actioneventframe = actioneventframe;
	}
	
	public void actionPerformed (ActionEvent e) {
		//fullfill the data structure
        String line = "";
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("\t");// assume tab separated
            map.put(parts[0], parts[1]); // (parts[0], int)
        }
        in.close();
	}
}
