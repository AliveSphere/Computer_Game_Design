package edu.virginia.engine.display;
//
import java.awt.Point;
import java.util.ArrayList;
//
public class PhysicsSprite extends AnimatedSprite {

	// Constructors
	public PhysicsSprite(String id) {
		super(id);
	}
	public PhysicsSprite(String id, String imageFileName) {
		super(id, imageFileName);
	}
	public PhysicsSprite(String id, String imageFileName, boolean visible) {
		super(id, imageFileName);
		this.setVisible(visible);
	}
	public PhysicsSprite(String id, ArrayList <String> actionList, ArrayList <Point> coordList, int numImages) {
		super(id);
	}
	
	
}
