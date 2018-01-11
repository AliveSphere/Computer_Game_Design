package edu.virginia.engine.display;


import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import edu.virginia.engine.events.EventDispatcher;

/**
 * A very basic display object for a java based gaming engine
 * 
 * */
public class DisplayObject extends EventDispatcher {

	/* All DisplayObject have a unique id */
	private String id;
	private DisplayObject parent;
	
	/* The image that is displayed by this object */
	private BufferedImage displayImage;
	public boolean visible = true;
	public double xpivot, ypivot;
	public double scaleX = 1;
	public double scaleY = 1;
	public double rotation;
	public float alpha = 1.0f;
	public int xpos;
	public int ypos;
	int timeCount = 3600;
	int health = 200;
	private int pastX;
	private int pastY;
	public double maxSpeed=5.0;

	boolean hasPhysics = false;
	public double mass;
	public double velocity;
	public double acceleration;
	public boolean jumping = true;
	
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	/**
	 * Constructors: can pass in the id OR the id and image's file path and
	 * position OR the id and a buffered image and position
	 */
	public DisplayObject() {
	}
	public DisplayObject(String id) {
		this.setId(id);
	}
	public DisplayObject(String id, String fileName) {
		this.setId(id);
		this.setImage(fileName);
	}
	
	public boolean isJumping() {
		return jumping;
	}
	
	/**
	 * Getters and Setters
	 * 
	 */
	public DisplayObject getParent() {
		return parent;
	}
	
	public void setParent (DisplayObject parent) {
		this.parent = parent;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public double getXpivot() {
		return xpivot;
	}

	public void setXpivot(double xpivot) {
		this.xpivot = xpivot;
	}

	public double getYpivot() {
		return ypivot;
	}

	public void setYpivot(double ypivot) {
		this.ypivot = ypivot;
	}

	public double getScaleX() {
		return scaleX;
	}

	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}

	public double getScaleY() {
		return scaleY;
	}

	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	/** New Physics getters and setters **/
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	public double getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	
	public int getPastX() {
		return pastX;
	}
	public void setPastX(int pastX) {
		this.pastX = pastX;
	}
	public int getPastY() {
		return pastY;
	}
	public void setPastY(int pastY) {
		this.pastY = pastY;
	}
	/**
	 * Returns the unscaled width and height of this display object
	 * */
	public int getUnscaledWidth() {
		if(displayImage == null) return 0;
		return displayImage.getWidth();
	}

	public int getUnscaledHeight() {
		if(displayImage == null) return 0;
		return displayImage.getHeight();
	}

	public BufferedImage getDisplayImage() {
		return this.displayImage;
	}

	protected void setImage(String imageName) {
		if (imageName == null) {
			return;
		}
		displayImage = readImage(imageName);
		if (displayImage == null) {
			System.err.println("[DisplayObject.setImage] ERROR: " + imageName + " does not exist!");
		}
	}


	/**
	 * Helper function that simply reads an image from the given image name
	 * (looks in resources\\) and returns the bufferedimage for that filename
	 * */
	public BufferedImage readImage(String imageName) {
		BufferedImage image = null;
		try {
			String file = ("resources" + File.separator + imageName);
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			System.out.println("[Error in DisplayObject.java:readImage] Could not read image " + imageName);
			e.printStackTrace();
		}
		return image;
	}

	public void setImage(BufferedImage image) {
		if(image == null) return;
		displayImage = image;
	}
	
	
	/** Begin Lab6 collision detection **/
	public Rectangle getHitbox() {
		Rectangle r = new Rectangle(this.xpos, this.ypos, 
				(int) (this.getUnscaledWidth()*this.scaleX), 
				(int) (this.getUnscaledHeight()*this.scaleY));
		return r;
	}
	
	public boolean collidesWith(DisplayObject other) {
		Area a = new Area(this.getGlobalHitbox());
		a.intersect(new Area(other.getGlobalHitbox()));
		return !a.isEmpty();
	}

	public boolean landsOn(DisplayObject other) {
    		Area a = new Area(this.getLocalHitbox());
    		a.intersect(new Area(other.getLocalHitbox()));
    		return (!a.isEmpty() && ((this.ypos + this.getUnscaledHeight()) < other.ypos + 10));
	}
	
	/** Has Physics **/
	public boolean hasPhysics () {
		return hasPhysics;
	}
	

	/**
	 * Invoked on every frame before drawing. Used to update this display
	 * objects state before the draw occurs. Should be overridden if necessary
	 * to update objects appropriately.
	 * */
	protected void update(ArrayList<Integer> pressedKeys) {
		
	}

	/**
	 * Draws this image. This should be overloaded if a display object should
	 * draw to the screen differently. This method is automatically invoked on
	 * every frame.
	 * */
	public void draw(Graphics g) {
		
		if (displayImage != null) {
			/*
			 * Get the graphics and apply this objects transformations
			 * (rotation, etc.)
			 */
			Graphics2D g2d = (Graphics2D) g;
			
			if (visible == false) {
				this.alpha = 0.0f;
			}
			if (alpha == 0.0f) {
				this.visible = false;
			}
			else {
				this.visible = true;
			}
			
			((Graphics2D)g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, this.getAlpha()));
			applyTransformations(g2d);
			
			/* Actually draw the image, perform the pivot point translation here */
			g2d.translate((int) -xpivot, (int) -ypivot);
			g2d.drawImage(displayImage, 0, 0,
					(int) (getUnscaledWidth()),
					(int) (getUnscaledHeight()), null);
			//g2d.drawRect(0, 0, this.getLocalHitbox().getBounds().width, this.getLocalHitbox().getBounds().height);
			
			/*
			 * undo the transformations so this doesn't affect other display
			 * objects
			 */
			g2d.translate((int) xpivot, (int) ypivot);
			reverseTransformations(g2d);
		}
	}

	/**
	 * Applies transformations for this display object to the given graphics
	 * object
	 * */
	protected void applyTransformations(Graphics2D g2d) {
		g2d.translate(xpos, ypos);
		g2d.rotate(rotation);
		g2d.scale(scaleX, scaleY);
		
	}

	/**
	 * Reverses transformations for this display object to the given graphics
	 * object
	 * */
	
	protected void reverseTransformations(Graphics2D g2d) {
		g2d.scale(1/scaleX, 1/scaleY);
		g2d.rotate(-rotation);
		g2d.translate(-xpos, -ypos);
	}
	
	protected AffineTransform getGlobalTransform(){
	   	 AffineTransform at;
	   	 if(this.parent == null) at = new AffineTransform();
	   	 else at = this.getParent().getGlobalTransform();
	   	 
	   	 at.concatenate(getLocalTransform());
	   	 return at;
	}

	
	protected AffineTransform getLocalTransform(){
	   	 AffineTransform at = new AffineTransform();
	   	 at.translate(this.xpos, this.ypos);
	   	 at.rotate(Math.toRadians(this.rotation));
	   	 at.scale(this.scaleX, this.scaleY);
	   	 at.translate(-this.xpivot, -this.ypivot);
	   	 return at;
	}
	    
    public Shape getGlobalHitbox(){
   	 	return getGlobalTransform().createTransformedShape(new Rectangle(0, 0, getUnscaledWidth(), getUnscaledHeight()));
    }
   	 
    public Shape getLocalHitbox(){
   	 	return getLocalTransform().createTransformedShape(new Rectangle(0, 0, getUnscaledWidth(), getUnscaledHeight()));
    }
}
