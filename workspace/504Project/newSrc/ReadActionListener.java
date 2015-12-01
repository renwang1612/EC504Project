import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.Socket;
import java.io.*;
import java.util.HashMap;
// import java.util.LinkedHashMap;
import java.util.Map;

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
        File testFile = new File ( "sampletest.txt" );
        try {
	        BufferedWriter writer = new BufferedWriter ( new FileWriter ( testFile ));
	        writer.write("");
	        writer.flush();
	        writer.close();
        } catch (IOException ex)
        {}
        try {
            BufferedWriter writer1 = new BufferedWriter ( new FileWriter ( testFile, true));
            
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("\t");// assume tab separated
                map.put(parts[0], parts[1]); // (parts[0], int)
                //map.put(line, line); // (parts[0], int)
                //System.out.println(parts[0]+" "+parts[1]);
            }
            
            for ( String buffer: map.keySet()) {
            	System.out.println(buffer);
                writer1.write ( buffer + "\n" ) ;
            }
            
            writer1.flush () ;
            writer1.close() ;
            in.close();
        } catch ( IOException ex ) {
            System.out.println ("file close failed") ;
        }
	}
}
