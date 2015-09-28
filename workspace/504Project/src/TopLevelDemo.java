import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonActionListener implements ActionListener{
	public void actionPerformed (ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String buttonName = e.getActionCommand();
		if (buttonName.equals("Click")) {
			JOptionPane.showMessageDialog(null, "Button clicked!", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

public class TopLevelDemo {
	private static void createAndShowGUI() {
		JFrame frame = new JFrame ("504 Project");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//JMenuBar greenMenuBar = new JMenuBar ();
		//greenMenuBar.setOpaque (true);
		//greenMenuBar.setBackground (new Color (160, 160, 160));
		//greenMenuBar.setPreferredSize (new Dimension (200, 20));
		JPanel pane1 = new JPanel ();
		JPanel pane2 = new JPanel ();
		//pane.setOpaque (true);
		//pane.setBackground (new Color (255, 255, 255));
		//pane.setPreferredSize (new Dimension (200, 180));
		//pane.setLayout (new GridBagLayout());
		int [] a = {};
		JTextField text = new JTextField (Integer.toString(a.length));
		text.setPreferredSize (new Dimension (200, 50));
		pane1.add (text);
		JButton click = new JButton("Click");
		click.addActionListener(new ButtonActionListener());
		click.setPreferredSize (new Dimension (200, 40));
		pane2.add (click);
		//frame.setJMenuBar (greenMenuBar);
		pane1.add(click);
		pane2.add(text);
		frame.getContentPane ().add(pane1, BorderLayout.CENTER);
		frame.getContentPane ().add(pane2, BorderLayout.PAGE_START);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main (String [] args) {
		javax.swing.SwingUtilities.invokeLater (new Runnable () {
			public void run () {
				createAndShowGUI();
			}
		});
	}
}
