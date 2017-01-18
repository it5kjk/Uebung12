package task1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class JMyButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668623465507586262L;
	
	public JMyButton() {
		super();
	}
	
	public JMyButton(Action a) {
		super(a);
	}

	public JMyButton(Icon icon) {
		super(icon);
	}

	public JMyButton(String text, Icon icon) {
		super(text, icon);
	}

	public JMyButton(String text) {
		super(text);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(3, 3, this.getWidth()-6, this.getHeight() -6);
	}
}