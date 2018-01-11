package onelife.maingame;

import java.awt.Graphics;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;

import edu.virginia.engine.display.DisplayObjectContainer;
import edu.virginia.engine.display.Sprite;

public class SplashGameOver extends DisplayObjectContainer {
	
	private boolean currentSelect = false; //false = try again, true = quit
	private Sprite tails;
	
	public SplashGameOver() {
		super("Splash Game Over");
		
		Sprite background = new Sprite("Game Over Screen", "splashgameover.png");
		this.addChild(background, this);
		
		tails = new Sprite("Dead Tails", "DeadTails.png");
		tails.setXpos(335 - (tails.getUnscaledWidth() / 2));
		tails.setYpos(100);
		tails.setScaleX(4.0);
		tails.setScaleY(4.0);
		this.addChild(tails, this);
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		
		for (int i = 0; i < pressedKeys.size(); i++) {
			if (pressedKeys.get(i).equals(KeyEvent.VK_DOWN) || pressedKeys.get(i).equals(KeyEvent.VK_UP)) {
				currentSelect = !currentSelect;
				pressedKeys.clear();
			}
			else if (pressedKeys.get(i).equals(KeyEvent.VK_ENTER)) {
				this.setVisible(false);
				pressedKeys.clear();
			}
		} 
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
		if (!currentSelect) 
			g.drawRect(260, 440, 280, 52);
		else
			g.drawRect(330, 520, 125, 55);
	}
	
	public boolean getCurrentSelect() {
		return currentSelect;
	}
}
