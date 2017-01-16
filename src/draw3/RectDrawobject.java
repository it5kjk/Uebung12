package draw3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class RectDrawobject extends Drawobject {
	private boolean isFilled;
	
	public RectDrawobject(int x1, int y1, int x2, int y2,
		Color color, float linewidth, boolean isFilled)
	{
		super(x1, y1, x2, y2, color, linewidth);
		this.isFilled = isFilled;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	@Override
	void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Rectangle2D.Float rect =
			new Rectangle2D.Float(getX1(),getY1(),getX2(),getY2());        
		if (isFilled) {
			g2d.fill(rect);
		} else {
			g2d.draw(rect);
		}
	}
}
