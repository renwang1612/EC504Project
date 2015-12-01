import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;
import java.io.IOException;

public class ReadActionListener  implements ActionListener{
	private ActionEventFrame actioneventframe;
    private BufferedReader in ;
    private Map<String,String> map ;
	public ReadActionListener (ActionEventFrame actioneventframe, BufferedReader in,
                                    Map<String,String> map) {
		this.actioneventframe   = actioneventframe;
        this.in                 = in ;
        this.map                = map ;
	}
	
	public void actionPerformed (ActionEvent e) {
		//fullfill the data structure
        String line = "";
        try {
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("\t");// assume tab separated
                map.put(parts[0], parts[1]); // (parts[0], int)
            }
            in.close();
        } catch ( IOException ex ) {
            System.out.println ("file close failed") ;
        }
	}
}
