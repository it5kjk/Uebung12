package draw3;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JPanel;

public class JMyPaintPanel extends JPanel {
	/**
	 * This panel contains an ArrayList<Drawobject>
	 * for storing items to draw on the UI
	 */
	private static final long serialVersionUID = -1737555594251366648L;
	private ArrayList<Drawobject> drawobjects;

	public JMyPaintPanel() {
		drawobjects = new ArrayList<Drawobject>();
	}

	public JMyPaintPanel(LayoutManager layout) {
		super(layout);
		drawobjects = new ArrayList<Drawobject>();
	}

	public JMyPaintPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		drawobjects = new ArrayList<Drawobject>();
	}

	public JMyPaintPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		drawobjects = new ArrayList<Drawobject>();
	}

	public void addDrawobject(Drawobject dobj) {
		drawobjects.add(dobj);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		for (Drawobject drwo : drawobjects) {
			g2d.setColor(drwo.getColor());
			BasicStroke stil = new BasicStroke(
					drwo.getLinewidth(),
					BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2d.setStroke(stil);
			drwo.paint(g2d);
		}
	}
}
