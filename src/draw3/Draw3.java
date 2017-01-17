package draw3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
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

public class Draw3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1588690295579889742L;
	private JPanel contentPane;
	private JMyPaintPanel panelDrawPanel;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private JTextField textFieldX1;
	private JTextField textFieldY1;
	private JTextField textFieldX2;
	private JTextField textFieldY2;
	private JRadioButton rdbtnCircle;
	private JRadioButton rdbtnRectangle;
	private JRadioButton rdbtnOval;
	private JRadioButton rdbtnLine;
	private JCheckBox chckbxDrawFilled;
	private JLabel lblX1;
	private JLabel lblX2;
	private JLabel lblY1;
	private JLabel lblY2;
	private final ButtonGroup drawingShapes = new ButtonGroup();
	private char itemID;
	private Color color = Color.black;
	private Drawobject drwo;
	private JButton btnChooseColor;
	private JLabel lblCoords;
	
	private MouseAdapter ma = new MouseAdapter() {
		boolean draw = false;
		@Override
		public void mouseEntered(MouseEvent e) {
			//show label for mouse coords on draw panel
			lblCoords.setVisible(true);
			super.mouseEntered(e);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// hide label for mouse coords
			lblCoords.setVisible(false);
			super.mouseExited(e);
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			//add mouse coordinates to label
			lblCoords.setText(
					"x: " + e.getX() + " y: " + e.getY());
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			draw = true;
			super.mouseDragged(e);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			super.mousePressed(e);
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			if (draw && drawingShapes.getSelection() != null) {
				int xend = e.getX();
				int yend = e.getY();
				x2 = xend - x1;
				y2 = yend - y1;
				drawWithMouse(x1, y1, x2, y2, xend, yend);
				draw = false;
				super.mouseReleased(e);
			} else {
				JOptionPane.showMessageDialog(
					panelDrawPanel, "No item selected!", "No selection",
					JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Draw3 frame = new Draw3();
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
	public Draw3() {
		setTitle("Draw3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,fill][]", "[][grow]"));
		
		JLabel lblDrawPanelTitle = new JLabel("draw panel");
		contentPane.add(lblDrawPanelTitle, "flowx,cell 0 0");
		
		panelDrawPanel = new JMyPaintPanel();
		panelDrawPanel.addMouseListener(ma);
		panelDrawPanel.addMouseMotionListener(ma);
		
		panelDrawPanel.setBackground(new Color(255, 255, 255));
		panelDrawPanel.setBorder(new LineBorder(Color.black));
		contentPane.add(panelDrawPanel, "cell 0 1,grow");
		
		JPanel panelControls = new JPanel();
		contentPane.add(panelControls, "cell 1 1,grow");
		panelControls.setLayout(new MigLayout("", "[][grow][][][grow]", "[][][][][][][][][][]"));
		
		lblX1 = new JLabel("Position x:");
		panelControls.add(lblX1, "cell 0 0,alignx trailing");
		
		textFieldX1 = new JTextField();
		panelControls.add(textFieldX1, "cell 1 0,growx");
		textFieldX1.setColumns(10);
		
		lblY1 = new JLabel("y:");
		panelControls.add(lblY1, "cell 3 0,alignx trailing");
		
		textFieldY1 = new JTextField();
		panelControls.add(textFieldY1, "cell 4 0,growx");
		textFieldY1.setColumns(10);
		
		lblX2 = new JLabel("Width:");
		panelControls.add(lblX2, "cell 0 1,alignx trailing");
		
		textFieldX2 = new JTextField();
		panelControls.add(textFieldX2, "cell 1 1,growx");
		textFieldX2.setColumns(10);
		
		lblY2 = new JLabel("Height:");
		panelControls.add(lblY2, "cell 3 1,alignx trailing");
		
		textFieldY2 = new JTextField();
		panelControls.add(textFieldY2, "cell 4 1,growx");
		textFieldY2.setColumns(10);
		
		rdbtnRectangle = new JRadioButton("Rectangle");
		rdbtnRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLabelTexts();
				lblY2.setVisible(true);
				textFieldY2.setVisible(true);
				chckbxDrawFilled.setVisible(true);
				itemID = 'R';
			}
		});
		drawingShapes.add(rdbtnRectangle);
		panelControls.add(rdbtnRectangle, "cell 1 3");
		
		chckbxDrawFilled = new JCheckBox("filled");
		panelControls.add(chckbxDrawFilled, "cell 4 3");
		
		rdbtnCircle = new JRadioButton("Circle");
		rdbtnCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLabelTexts();
				lblY2.setVisible(false);
				textFieldY2.setVisible(false);
				chckbxDrawFilled.setVisible(true);
				itemID = 'C';
			}
		});
		drawingShapes.add(rdbtnCircle);
		panelControls.add(rdbtnCircle, "cell 1 4");
		
		rdbtnOval = new JRadioButton("Oval");
		rdbtnOval.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLabelTexts();
				lblY2.setVisible(true);
				textFieldY2.setVisible(true);
				chckbxDrawFilled.setVisible(true);
				itemID = 'O';
			}
		});
		drawingShapes.add(rdbtnOval);
		panelControls.add(rdbtnOval, "cell 1 5");
		
		btnChooseColor = new JButton("Choose color");
		btnChooseColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(
					panelControls, "Colorpicker", Color.black);
				btnChooseColor.setBackground(color);
			}
		});
		panelControls.add(btnChooseColor, "cell 4 4");
		
		rdbtnLine = new JRadioButton("Line");
		rdbtnLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setLabelTexts();
				lblY2.setVisible(true);
				textFieldY2.setVisible(true);
				chckbxDrawFilled.setVisible(false);
				itemID = 'L';
			}
		});
		drawingShapes.add(rdbtnLine);
		panelControls.add(rdbtnLine, "cell 1 6");
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//get parameter
					x1 = Integer.parseInt(textFieldX1.getText());
					y1 = Integer.parseInt(textFieldY1.getText());
					x2 = Integer.parseInt(textFieldX2.getText());
					y2 = Integer.parseInt(textFieldY2.getText());
					drawItem(x1, y1, x2, y2);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
						"Die Eingaben sind ungültig!",
						"Ungültige Parameter", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelControls.add(btnDraw, "cell 1 8,alignx center");
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelDrawPanel.clear();
			}
		});
		panelControls.add(btnClear, "cell 4 8,alignx center");
		
		lblCoords = new JLabel("x: y:");
		lblCoords.setVisible(false);
		contentPane.add(lblCoords, "cell 0 0");
		
	}
	private void setLabelTexts() {
		//change label text based on selected radio button
		if (rdbtnLine.isSelected()) {
			lblX1.setText("Start x:");
			lblX2.setText("End x:");
			lblY1.setText("y:");
			lblY2.setText("y:");
		} else {
			lblX1.setText("Position x:");
			if (rdbtnCircle.isSelected()) {
				lblX2.setText("Diameter:");
			} else {
				lblX2.setText("Width:");
			}
			lblY2.setText("Height:");
		}
	}
	private void drawWithMouse(
		int x1, int y1, int x2, int y2, int xend, int yend) {
		boolean fill = chckbxDrawFilled.isSelected();
		switch (itemID) {
		case 'R':
			drwo = new RectDrawobject(x1, y1, x2, y2,
				color, 1.0f, fill);
			break;
		case 'C':
			drwo = new CircleDrawobject(x1, y1, x2, x2,
				color, 1.0f, fill);
			break;
		case 'O':
			drwo = new OvalDrawobject(x1, y1, x2, y2,
				color, 1.0f, fill);
			break;
		case 'L':
			drwo = new LineDrawobject(x1, y1, xend, yend,
				color, 1.0f);
			break;
		}
		panelDrawPanel.addDrawobject(drwo);
		panelDrawPanel.repaint();
	}
	
	private void drawItem(int x1, int y1, int x2, int y2) {
		boolean fill = chckbxDrawFilled.isSelected();
		switch (itemID) {
		case 'R':
			drwo = new RectDrawobject(x1, y1, x2, y2,
				color, 1.0f, fill);
			break;
		case 'C':
			drwo = new CircleDrawobject(x1, y1, x2, x2,
				color, 1.0f, fill);
			break;
		case 'O':
			drwo = new OvalDrawobject(x1, y1, x2, y2,
				color, 1.0f, fill);
			break;
		case 'L':
			drwo = new LineDrawobject(x1, y1, x2, y2,
				color, 1.0f);
			break;
		}
		panelDrawPanel.addDrawobject(drwo);
		panelDrawPanel.repaint();
	}
}
