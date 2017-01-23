package task5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JMyPaintPanel extends JPanel {

	/**
	 * JPanel extending class to store draw items
	 */
	private static final long serialVersionUID = 3115189205698337928L;
	private ArrayList<TextDrawItem> itemList;
	
	public JMyPaintPanel() {
		itemList = new ArrayList<TextDrawItem>();
	}

	public JMyPaintPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		itemList = new ArrayList<TextDrawItem>();
	}

	public JMyPaintPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		itemList = new ArrayList<TextDrawItem>();
	}

	public JMyPaintPanel(LayoutManager layout) {
		super(layout);
		itemList = new ArrayList<TextDrawItem>();
	}
	
	public void addTextDrawItem(TextDrawItem item) {
		itemList.add(item);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		for (TextDrawItem drawItem : itemList) {
			g2d.setColor(drawItem.getColor());
			g2d.setFont(drawItem.getFont());
			drawItem.paint(g2d);
		}
	}
}
