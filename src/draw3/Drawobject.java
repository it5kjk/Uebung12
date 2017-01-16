package draw3;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Drawobject {
	protected int x1;
	protected int x2;
	protected int y1;
	protected int y2;
	protected Color color;
	protected float linewidth;
	
	Drawobject() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		color = Color.white;
		linewidth = 1.0f;
	}

	Drawobject(int x1, int y1, int x2, int y2, Color color, float linewidth) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.linewidth = linewidth;
	}
	
	abstract void paint(Graphics g);
	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getLinewidth() {
		return linewidth;
	}

	public void setLinewidth(float linewidth) {
		this.linewidth = linewidth;
	}
}
