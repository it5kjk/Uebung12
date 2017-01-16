package draw3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class CircleDrawobject extends Drawobject {
	private boolean filled;
	
	public CircleDrawobject(int x1, int y1, int x2, int y2,
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
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Ellipse2D.Float circle =
			new Ellipse2D.Float(getX1(), getY1(), getX2(), getX2());
		if (filled) {
			g2d.fill(circle);
		} else {
			g2d.draw(circle);
		}
	}
}
