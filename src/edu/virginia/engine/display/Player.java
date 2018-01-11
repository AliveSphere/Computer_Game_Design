package edu.virginia.engine.display;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

public class Player extends AnimatedSprite{
    public double gravity = 0.15;
    private boolean isAlive = true;
    private boolean facingLeft = false;
    private int points = 0;
    
    public Player(String id, ArrayList<String> actionList, ArrayList<Point> coordList, int numImages) {
   	 super(id, actionList, coordList, numImages);

    }
    
    public boolean isAlive() {
    	return isAlive;
    }
    
    public void setAlive(boolean b) {
    	isAlive = b;
    	if (!isAlive)
    		this.setVisible(false);
    }
    
    public boolean isFacingLeft() {
    	return facingLeft;
    }
    
    public void setFacingLeft(boolean b) {
    	facingLeft = b;
    }
    
    public int getPoints() {
    	return points;
    }
    
    public void setPoints(int p) {
    	points = p;
    }
    
    @Override
    public Shape getGlobalHitbox() {
   	 return getGlobalTransform().createTransformedShape(new Rectangle
   			 (0 + getUnscaledWidth()/2, 0,
   					 getUnscaledWidth()/2 - 10, getUnscaledHeight()));
   	 
    }
    
    @Override
	public Shape getLocalHitbox(){
    	return getLocalTransform().createTransformedShape(new Rectangle(0 + getUnscaledWidth()/2, 0,
   			 getUnscaledWidth()/2 - 10, getUnscaledHeight()));
    }
}
