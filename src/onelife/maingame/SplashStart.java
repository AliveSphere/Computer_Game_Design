package onelife.maingame;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;

import edu.virginia.engine.display.AnimatedSprite;
import edu.virginia.engine.display.DisplayObjectContainer;
import edu.virginia.engine.display.Sprite;

public class SplashStart extends DisplayObjectContainer {
	
	AnimatedSprite tails = null;
	private boolean toControls = false;
	private boolean currentSelect = false; //false = start game, true = controls
	
	public SplashStart() {
		super("Splash Start");
		
		Sprite background = new Sprite("Start Screen", "splashstart.png");
		ArrayList<String> actions = new ArrayList<String>();
		actions.add("standing");
		ArrayList<Point> coors = new ArrayList<Point>();
		coors.add(new Point(0, 7));
		tails = new AnimatedSprite("tails", actions, coors, 8);
		this.addChild(background, this);
		this.addChild(tails, this);
		
		tails.setScaleX(4.0);
		tails.setScaleY(4.0);
		tails.setXpos(20);
		tails.setYpos(450);
		tails.animate("standing");
	}
	
	public boolean toControls() {
		return toControls;
	}
	
	public void setToControls(boolean b) {
		toControls = b;
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		
		tails.animate("standing");
		
		for (int i = 0; i < pressedKeys.size(); i++) {
			if (pressedKeys.get(i).equals(KeyEvent.VK_DOWN) || pressedKeys.get(i).equals(KeyEvent.VK_UP)) {
				currentSelect = !currentSelect;
				pressedKeys.clear();
			}
			else if (pressedKeys.get(i).equals(KeyEvent.VK_ENTER)) {
				if (currentSelect)
					toControls = true;
				this.setVisible(false);
				pressedKeys.clear();
			}
		} 
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
		if (!currentSelect) 
			g.drawRect(200, 275, 325, 62);
		else
			g.drawRect(80, 338, 590, 65);
	}

}
