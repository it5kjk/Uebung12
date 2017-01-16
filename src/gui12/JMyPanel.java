package gui12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class JMyPanel extends JPanel {
	private static final long serialVersionUID = -8063273134051128991L;

	public JMyPanel() {
	}

	public JMyPanel(LayoutManager layout) {
		super(layout);
	}

	public JMyPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public JMyPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
	}
}
