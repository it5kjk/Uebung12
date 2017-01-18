package task2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JZielPanel extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7268796772376665227L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(getWidth()/2, (int) (getHeight()*0.1), getWidth()/2, (int) (getHeight()*0.9));
		g.drawLine((int) (getWidth()*0.1), (getHeight()/2), (int) (getWidth()*0.9), (getHeight()/2));
		g.drawOval((getWidth()/2 -30),(getHeight()/2 -30) , 30, 30);
	}
	
}
