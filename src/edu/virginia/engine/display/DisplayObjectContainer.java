package edu.virginia.engine.display;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class DisplayObjectContainer extends DisplayObject{
	ArrayList<DisplayObject> childrenList = new ArrayList<DisplayObject>();

	public DisplayObjectContainer() {
		
	}
	
	public DisplayObjectContainer(String id) {
		super(id);
	}
	
	public DisplayObjectContainer(String id, String imageFileName) {
		super(id, imageFileName);
	}
	public DisplayObjectContainer(String id, String imageFileName, boolean visible) {
		super(id, imageFileName);
		this.setVisible(visible);
	}

	public void addChild(DisplayObject child, DisplayObject parent) {
		childrenList.add(child);
		child.setParent(parent);
	}

	public ArrayList<DisplayObject> getAllChildren() {
		return childrenList;
	}

	public void removeChild(DisplayObject child) {
		childrenList.remove(child);
		child.setParent(null);
	}
	
	public void removeAllChildren() {
		childrenList.clear();
	}
	
	public boolean contains(DisplayObject ob) {
		return childrenList.contains(ob);
	}

	@Override
	public void draw (Graphics g) {
		super.draw(g);
		Graphics2D g2d = (Graphics2D) g;
		applyTransformations(g2d);
		for (DisplayObject child : childrenList) {
			child.draw(g);
		}
		reverseTransformations(g2d);
	}

	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		
		for (DisplayObject child : childrenList) {
			child.update(pressedKeys);
		}
	}



}
