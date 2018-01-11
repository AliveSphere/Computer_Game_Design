package edu.virginia.engine.display;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.virginia.engine.util.GameClock;

public class AnimatedSprite extends Sprite {

	public ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>();
	private Map <String, Point> dict= new HashMap<String, Point>();
	public String curPosition;
	
	private int start;
	private int current;
	private int end;
	
	private GameClock clock = new GameClock();
	public int animationSpeed = 100; //milliseconds between frames
	
	public boolean looping = false;
	private String curAnimation = "";
	
	// Constructors
	public AnimatedSprite(String id) {
		super(id);
	}
	public AnimatedSprite(String id, String imageFileName) {
		super(id, imageFileName);
	}
	public AnimatedSprite(String id, String imageFileName, boolean visible) {
		super(id, imageFileName);
		this.setVisible(visible);
	}
	public AnimatedSprite(String id, ArrayList <String> actionList, ArrayList <Point> coordList, int numImages) {
		super(id);
		for (int x = 0; x < numImages; x++) {
			String file = (id + x + ".png");
			BufferedImage image = this.readImage(file);
			imageList.add(image);
			
		}
		
		for (int i = 0; i < actionList.size(); i++) {
			this.dict.put(actionList.get(i), coordList.get(i));
		}
		
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	// Update
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
		
		//Animate between frames
		if(clock.getElapsedTime() >= animationSpeed){
			current++;
			if(current >= end) current = start;
			this.setImage(imageList.get(current));
			clock.resetGameClock();
		}
	}
	
	public void animate(String action) {
		if(action.equals(curAnimation)) return;
		
		curAnimation = action;
		start = this.dict.get(action).x;
		end = this.dict.get(action).y;
		current = start;
		this.setImage(imageList.get(current));
		clock.resetGameClock();
	}
}
