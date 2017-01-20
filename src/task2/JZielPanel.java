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
		g.drawLine(getWidth()/2, (int) (getHeight()*0.1), getWidth()/2, (int) (getHeight()*0.9)); //vLine
		//g.drawLine(getWidth()/2, getHeight(), getWidth()/2, getHeight());
		g.drawLine((int) (getWidth()*0.1), (getHeight()/2), (int) (getWidth()*0.9), (getHeight()/2));		
		//g.drawLine(getWidth(), getHeight()/2, getWidth(), (getHeight()/2));
		
		//three concentric circles with center at x,y and radius r
//		int r = 60;
		int r = (int) (((getWidth()*0.9) - (getWidth()*0.1)) *0.15);
		g.drawOval(
				((getWidth()/2) - (r/2)),
				((getHeight()/2) - (r/2)),
				r,
				r);
		g.drawOval(
				((getWidth()/2) - (r)),
				((getHeight()/2) - (r)),
				2*r, 
				2*r);
		g.drawOval(
				((getWidth()/2) - (int)(1.5*r)),
				((getHeight()/2) - (int)(1.5*r)),
				3*r,
				3*r);
	}
}
