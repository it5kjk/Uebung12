package task3;

/*
 * Klasse JMyFontChooser
 * Die Klasse ist von der Standardkomponente JComponent abgeleitet.
 * Sie dient als Auswahldialog für Schriftart und Schriftattribute.
 * 
 * Hans-Peter Habelitz
 * 2011-12-26
 */

import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JMyFontChooser extends Component
{

	private static final long serialVersionUID = 3834487885310131770L;
	private static JDialog jDialog;
	private static JLabel lblSchriftart;
	private static JComboBox<String> combobxSchriftart;
	private static DefaultComboBoxModel<String> combobxSchriftartModel;
	private static JLabel lblSchriftgroesse;
	private static JLabel lblStil;
	private static JScrollPane scrollPane1;
	private static JList<String> listSchriftprobe;
	private static JButton btnAbbrechen;
	private static JButton btnOK;
	private static JLabel lblSchriftprobe;
	private static JCheckBox chckbxKursiv;
	private static JCheckBox chckbxFett;
	private static JSpinner spinSchriftgroesse;
	private static SpinnerNumberModel spinSchriftgroesseModel;
	private static Font schrift;
	
	@SuppressWarnings("unused")
	public static Font showDialog(Component comp, Font font)
	{
		if (font==null)
		{
			font = new Font("Arial",0,12);
		}
	schrift=font;	
	JFrame frame = new JFrame();
	jDialog = new JDialog(frame, "Schriftart wählen", true);
	jDialog.addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent evt)
		{
			thisWindowClosing(evt);
		}
	});
	
	if (font == null)
		font = new Font("Dialog", Font.BOLD, 12);

	ActionListener al = new ActionListener()
	{
		public void actionPerformed(ActionEvent aevt)
		{
			String ac = aevt.getActionCommand();
			if (ac.equals("Schriftart"))
			{
				listSchriftprobe.setFont(schriftfestlegen());
			} else if (ac.equals("fett"))
			{
				listSchriftprobe.setFont(schriftfestlegen());
			} else if (ac.equals("kursiv"))
			{
				listSchriftprobe.setFont(schriftfestlegen());
			} else if (ac.equals("OK"))
			{
				schrift = schriftfestlegen();
				jDialog.setVisible(false);
			} else if (ac.equals("Abbrechen"))
			{
				schrift = null;
				jDialog.setVisible(false);
			}
		}
	};
	try {
		{
			jDialog.getContentPane().setLayout(null);
			jDialog.setTitle("Schriftart wählen");
			jDialog.setModal(true);
			jDialog.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				lblSchriftart = new JLabel();
				jDialog.getContentPane().add(lblSchriftart);
				lblSchriftart.setText("Schriftart");
				lblSchriftart.setBounds(10, 11, 60, 14);
			}
			{
				GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String[] fonts = ge.getAvailableFontFamilyNames();
				combobxSchriftartModel = new DefaultComboBoxModel<String>(
							fonts);
				combobxSchriftart = new JComboBox<String>();
				combobxSchriftart.setActionCommand("Schriftart");
				jDialog.getContentPane().add(combobxSchriftart);
				combobxSchriftart.setModel(combobxSchriftartModel);
				combobxSchriftart.setBounds(10, 31, 160, 20);
				if (schrift!=null){combobxSchriftartModel.setSelectedItem(schrift.getFontName());}
				combobxSchriftart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						combobxSchriftartActionPerformed(evt);
					}
				});
				if (schrift!=null){combobxSchriftartModel.setSelectedItem(schrift.getFontName());}
			}
			{
				lblSchriftgroesse = new JLabel();
				jDialog.getContentPane().add(lblSchriftgroesse);
				lblSchriftgroesse.setText("Schriftgröße");
				lblSchriftgroesse.setBounds(187, 11, 80, 14);
			}
			{
				if (schrift!=null) {spinSchriftgroesseModel = 
					new SpinnerNumberModel(schrift.getSize(),1,120,1);}
				else {spinSchriftgroesseModel = 
						new SpinnerNumberModel(12,1,120,1);}
				if (schrift!=null) spinSchriftgroesseModel.setValue(schrift.getSize());
				spinSchriftgroesse = new JSpinner();
				jDialog.getContentPane().add(spinSchriftgroesse);
				spinSchriftgroesse.setModel(spinSchriftgroesseModel);
				spinSchriftgroesse.setBounds(187, 31, 71, 20);
				spinSchriftgroesse.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						spinSchriftgroesseStateChanged(evt);
					}
				});
			}
			{
				chckbxFett = new JCheckBox("fett", schrift.isBold());
				jDialog.getContentPane().add(chckbxFett);
				chckbxFett.setText("fett");
				chckbxFett.setBounds(275, 30, 80, 23);
				if (schrift!=null)
				{
					if (schrift.isBold()) chckbxFett.setSelected(true);
					else chckbxFett.setSelected(false);
					chckbxFett.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							chckbxFettActionPerformed(evt);
						}
					});
					
				}
			}
			{
				chckbxKursiv = new JCheckBox("kursiv", schrift.isItalic());
				jDialog.getContentPane().add(chckbxKursiv);
				chckbxKursiv.setText("kursiv");
				chckbxKursiv.setBounds(275, 55, 80, 23);
				if (schrift!=null)
				{
					if (schrift.isItalic()) {chckbxKursiv.setSelected(true);}
					else {chckbxKursiv.setSelected(false);}
					chckbxKursiv.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							chckbxKursivActionPerformed(evt);
						}
					});
				}
			}
			{
				lblStil = new JLabel();
				jDialog.getContentPane().add(lblStil);
				lblStil.setText("Stil");
				lblStil.setBounds(275, 11, 25, 14);
			}
			{
				lblSchriftprobe = new JLabel();
				jDialog.getContentPane().add(lblSchriftprobe);
				lblSchriftprobe.setText("Schriftprobe");
				lblSchriftprobe.setBounds(15, 87, 80, 14);
			}
			{
				btnOK = new JButton();
				jDialog.getContentPane().add(btnOK);
				btnOK.setText("OK");
				btnOK.setBounds(55, 232, 77, 23);
				btnOK.addActionListener(al);
			}
			{
				btnAbbrechen = new JButton();
				jDialog.getContentPane().add(btnAbbrechen);
				btnAbbrechen.setText("Abbrechen");
				btnAbbrechen.setBounds(258, 232, 100, 23);
				btnAbbrechen.addActionListener(al);
			}
			{
				scrollPane1 = new JScrollPane();
				jDialog.getContentPane().add(scrollPane1);
				scrollPane1.setBounds(15, 107, 362, 104);
				{
					ListModel<String> listSchriftprobeModel = 
						new DefaultComboBoxModel<String>(
								new String[] {
										"ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜ",
										"abcdefghijklmnopqrstuvwxyzäöüß",
										",.;:+-*/(){}[]!§$%&/\\#~"});
					listSchriftprobe = new JList<String>();
					scrollPane1.setViewportView(listSchriftprobe);
					listSchriftprobe.setModel(listSchriftprobeModel);
					listSchriftprobe.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					if (schrift!=null) listSchriftprobe.setFont(schrift);
				}
			}
		}
		jDialog.setSize(400, 300);
		jDialog.setLocationRelativeTo(comp);
		jDialog.setVisible(true);
		jDialog.dispose();

		
	} catch (Exception e) {
		e.printStackTrace();}
	return schrift;
	}
	
	private static void chckbxFettActionPerformed(ActionEvent evt) {
		schriftfestlegen();
	}
	
	private static void chckbxKursivActionPerformed(ActionEvent evt) {
		schriftfestlegen();
	}
	
	private static void spinSchriftgroesseStateChanged(ChangeEvent evt) {
		schriftfestlegen();
	}
	
	private static void combobxSchriftartActionPerformed(ActionEvent evt) {
		schriftfestlegen();
	}
	
	private static void thisWindowClosing(WindowEvent evt) {
		schrift=null;
	}
	
	public static Font showDialog(Component comp)
	{
		return showDialog(comp, comp.getFont());
	}

	private static Font schriftfestlegen()
	{
		String name = (String) combobxSchriftart.getSelectedItem();
		int stil = (chckbxFett.isSelected() ? Font.BOLD : Font.PLAIN)
				| (chckbxKursiv.isSelected() ? Font.ITALIC : Font.PLAIN);
		int groesse = spinSchriftgroesseModel.getNumber().intValue();
		Font nf = new Font(name, stil, groesse);
		listSchriftprobe.setFont(nf);
		return nf;
	}
}
