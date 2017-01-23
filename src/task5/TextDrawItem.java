package task5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TextDrawItem {
	protected Font font;
	protected Color color;
	protected String text;
	protected int x;
	protected int y;
	
	public TextDrawItem(String s, Font f, Color c, int x, int y) {
		text = s;
		font = f;
		color = c;
		this.x = x;
		this.y = y;
	}
	
	void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString(text, x, y);
	}
	
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
