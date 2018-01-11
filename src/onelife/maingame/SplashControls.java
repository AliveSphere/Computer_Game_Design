package onelife.maingame;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;

import edu.virginia.engine.display.AnimatedSprite;
import edu.virginia.engine.display.DisplayObjectContainer;
import edu.virginia.engine.display.Sprite;

public class SplashControls extends DisplayObjectContainer {
	
	AnimatedSprite tails = null;
	private boolean pressed = false;
	
	public SplashControls() {
		super("Splash Controls");
		
		Sprite background = new Sprite("Controls Screen", "splashcontrols.png");
		ArrayList<String> actions = new ArrayList<String>();
		actions.add("standing"); actions.add("running"); actions.add("jumping");
		ArrayList<Point> coors = new ArrayList<Point>();
		coors.add(new Point(0, 7)); coors.add(new Point(8, 15));
		coors.add(new Point(16, 22));
		tails = new AnimatedSprite("tails", actions, coors, 23);
		this.addChild(background, this);
		this.addChild(tails, this);
		
		tails.setScaleX(4.0);
		tails.setScaleY(4.0);
		tails.setXpos(500);
		tails.setYpos(20);
		tails.animate("jumping");
	}
	
	public void setPressed(boolean b) {
		pressed = b;
	}
	
	public boolean getPressed() {
		return pressed;
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		
		tails.animate("jumping");
		
		for (int i = 0; i < pressedKeys.size(); i++) {
			if (pressedKeys.get(i).equals(KeyEvent.VK_ENTER)) {
				if (!getPressed()) {
					this.setVisible(false);
					this.setPressed(true);
				}
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}

}
