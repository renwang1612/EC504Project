import javax.swing.*;

public abstract class Observer extends JFrame {										//Observer pattern, an abstract observer
	JTextField text = new JTextField ();
	public void getMessage (String message) {
		text.setText ("U've set the textfield!\n" + message);
	}
}
