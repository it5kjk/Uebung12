package task5;

import task3.JMyFontChooser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;


public class DrawATextV2 extends JFrame {

	/*
	 * Input text can be drawn on a JPanel per mouseClick. 
	 * Text color red and switching fonts is  optional.
	 * All inputs are stored and will be redrawn.
	 */
	private static final long serialVersionUID = -2598460274397292275L;
	private JPanel contentPane;
	private JPanel drawPanel;
	private JPanel controlPanel;
	private JLabel lblInputText;
	private JTextField tfInputText;
	private JRadioButton rdbtnTxtColorBlack;
	private JRadioButton rdbtnTxtColorRed;
	private final ButtonGroup btnGrpControls = new ButtonGroup();
	private Color txtColor = Color.black;
	private Font font = null;
	private JButton btnSelectFont;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					DrawATextV2 frame = new DrawATextV2();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//frame constructor
	public DrawATextV2() {
		setTitle("DrawATextV2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][]", "[grow]"));
		
		drawPanel = new JMyPaintPanel();
		drawPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		drawPanel.setBackground(Color.WHITE);
		drawPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = tfInputText.getText();
				if (input.trim().isEmpty()) {
					JOptionPane.showMessageDialog(
						drawPanel, "Input text is empty!",
						"Empty input", JOptionPane.ERROR_MESSAGE);
				} else if (e.getButton() != MouseEvent.BUTTON3){
					int x = e.getX();
					int y = e.getY();
					Graphics g = drawPanel.getGraphics();
					Graphics2D g2d = (Graphics2D)g;
					g2d.setColor(txtColor);
					g2d.setFont(font);
					g2d.drawString(input, x, y);
				}
				super.mouseClicked(e);
			}
		});
		contentPane.add(drawPanel, "cell 0 0,grow");
		
		controlPanel = new JPanel();
		contentPane.add(controlPanel, "cell 1 0,grow");
		controlPanel.setLayout(new MigLayout("", "[grow]", "[][][][][]"));
		
		lblInputText = new JLabel("input text");
		lblInputText.setFont(new Font("Tahoma", Font.BOLD, 11));
		controlPanel.add(lblInputText, "cell 0 0");
		
		tfInputText = new JTextField();
		controlPanel.add(tfInputText, "cell 0 1");
		tfInputText.setColumns(10);
		
		rdbtnTxtColorBlack = new JRadioButton("black");
		btnGrpControls.add(rdbtnTxtColorBlack);
		rdbtnTxtColorBlack.setSelected(true);
		rdbtnTxtColorBlack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtColor = Color.black;
			}
		});
		controlPanel.add(rdbtnTxtColorBlack, "cell 0 2");
		
		rdbtnTxtColorRed = new JRadioButton("red");
		btnGrpControls.add(rdbtnTxtColorRed);
		rdbtnTxtColorRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtColor = Color.red;
			}
		});
		controlPanel.add(rdbtnTxtColorRed, "cell 0 3");
		
		btnSelectFont = new JButton("Select font");
		btnSelectFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				font = JMyFontChooser.showDialog(contentPane);
			}
		});
		controlPanel.add(btnSelectFont, "cell 0 4");
	}
}
