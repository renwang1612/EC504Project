import javax.swing.*;

public abstract class Observer extends JFrame {										//Observer pattern, an abstract observer
	JButton Click = new JButton();
	JTextField Text = new JTextField ();
	JLabel label = new JLabel();
	public void getMessage (String message) {
		//Text.setText (message);
		label.setText (message);
		//Click.setText ("succeed!" +message);
	}
    
    String getTextAndClean () {
    	String content = Text.getText();
    	Text.setText("");
    	label.setText ("");
    	return content;
    }
}
