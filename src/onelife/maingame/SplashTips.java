package onelife.maingame;

import java.awt.Graphics;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;

import edu.virginia.engine.display.DisplayObjectContainer;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.util.GameClock;

public class SplashTips extends DisplayObjectContainer {

	private GameClock timer;
	
	public SplashTips() {
		super("tips");
		
		Sprite tips = new Sprite("Tips", "splashtips.png");
		this.addChild(tips, this);
		
		timer = new GameClock();
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		if (pressedKeys.size() > 0 && pressedKeys.get(0).equals(KeyEvent.VK_ENTER))
			this.setVisible(false);
		//if (timer.getElapsedTime() / 1000 > 5)
			//this.setVisible(false);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawString("DONE! Press enter!", 655, 120);
	}
}
