package draw3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineDrawobject extends Drawobject {

	public LineDrawobject(int x1, int y1, int x2, int y2,
			Color color, float linewidth) {
		super(x1, y1, x2, y2, color, linewidth);
	}

	@Override
	void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Line2D.Float line = new Line2D.Float(getX1(),getY1(),getX2(),getY2());
		g2d.draw(line);
	}

}
