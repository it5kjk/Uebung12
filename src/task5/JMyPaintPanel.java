package task5;

import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JMyPaintPanel extends JPanel {

	/**
	 * JPanel extending class to store draw items
	 */
	private static final long serialVersionUID = 3115189205698337928L;
	private ArrayList<DrawItem> itemList;
	
	public JMyPaintPanel() {
		itemList = new ArrayList<DrawItem>();
	}

	public JMyPaintPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		itemList = new ArrayList<DrawItem>();
	}

	public JMyPaintPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		itemList = new ArrayList<DrawItem>();
	}

	public JMyPaintPanel(LayoutManager layout) {
		super(layout);
		itemList = new ArrayList<DrawItem>();
	}
	
	
}
