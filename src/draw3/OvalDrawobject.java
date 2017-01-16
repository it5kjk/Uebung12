package draw3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class OvalDrawobject extends Drawobject {
	private boolean filled;
	
	public OvalDrawobject(int x1, int y1, int x2, int y2,
			Color color, float linewidth, boolean filled)
	{
		super(x1, y1, x2, y2, color, linewidth);
		this.filled = filled;
	}
	
	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Ellipse2D.Float oval = 
			new Ellipse2D.Float(getX1(), getY1(), getX2(), getY2());
		if (filled) {
			g2d.fill(oval);
		} else {
			g2d.draw(oval);
		}
	}

}
