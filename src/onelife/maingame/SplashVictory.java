package onelife.maingame;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.glass.events.KeyEvent;

import edu.virginia.engine.display.AnimatedSprite;
import edu.virginia.engine.display.DisplayObjectContainer;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.util.GameClock;

public class SplashVictory extends DisplayObjectContainer {
	
	private ArrayList<AnimatedSprite> coins = new ArrayList<AnimatedSprite>();
	private String playerName = "";
	private GameClock timer;
	
	public SplashVictory() {
		super("Splash Victory");
		
		Sprite background = new Sprite("Victory Screen", "splashvictory.png");
		ArrayList<String> actions = new ArrayList<String>();
		actions.add("coinAnimate");
		ArrayList<Point> coors = new ArrayList<Point>();
		coors.add(new Point(0, 5));
		AnimatedSprite coin1 = new AnimatedSprite ("coin", actions, coors, 6);
		AnimatedSprite coin2 = new AnimatedSprite ("coin", actions, coors, 6);
		AnimatedSprite coin3 = new AnimatedSprite ("coin", actions, coors, 6);
		AnimatedSprite coin4 = new AnimatedSprite ("coin", actions, coors, 6);
		this.addChild(background, this);
		this.addChild(coin1, this);
		this.addChild(coin2, this);
		this.addChild(coin3, this);
		this.addChild(coin4, this);
		
		coins.add(coin1);
		coins.add(coin2);
		coins.add(coin3);
		coins.add(coin4);
		
		for (int i = 0; i < coins.size(); i++) {
			coins.get(i).animate("coinAnimate");
			coins.get(i).setYpos(125);
		}
		
		int spacer = (820 - (coin1.getUnscaledWidth() * 4)) / 5;
		
		coin1.setXpos(spacer);
		coin2.setXpos(coin1.getXpos() + coin1.getUnscaledWidth() + spacer);
		coin3.setXpos(coin2.getXpos() + coin2.getUnscaledWidth() + spacer);
		coin4.setXpos(820 - coin4.getUnscaledWidth() - spacer);
		
		playerName = JOptionPane.showInputDialog("Enter your name!");
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		
		for (AnimatedSprite c : coins) {
			c.animate("coinAnimate");
		}
		
		for (int i = 0; i < pressedKeys.size(); i++) {
			if (pressedKeys.get(i).equals(KeyEvent.VK_ENTER)) {
				//this.setVisible(false);
			}
		}
		
		if (timer.getElapsedTime() / 1000 > 3)
			this.setVisible(false);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void startTimer() {
		timer = new GameClock();
	}

}
