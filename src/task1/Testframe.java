package task1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import task2.JZielPanel;

public class Testframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6164832045668251551L;
	private JPanel contentPane;
	private JZielPanel tPanel;
	@SuppressWarnings("unused")
	private JMyButton mbtnHallo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testframe frame = new Testframe();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Testframe() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setSize(this.getSize().width, this.getSize().height);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
//		mbtnHallo = new JMyButton("Testbutton");
//		mbtnHallo.setText("Hallo");
//		mbtnHallo.setBounds(222, 78, 89, 23);
//		contentPane.add(mbtnHallo);
		
		tPanel = new JZielPanel();
//		tPanel.setBounds(contentPane.getX(),contentPane.getY(),contentPane.getSize().width,contentPane.getSize().height);
		contentPane.add(tPanel);
	}
}
