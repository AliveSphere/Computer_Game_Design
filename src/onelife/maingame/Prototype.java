package onelife.maingame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.glass.events.KeyEvent;

import edu.virginia.engine.display.*;
import onelife.obstacles.Obstacles;

public class Prototype extends Level {
	
	ArrayList<Sprite> layers = new ArrayList<Sprite>();
	//ArrayList<AnimatedSprite> players = new ArrayList<AnimatedSprite>();
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Player> deadPlayers = new ArrayList<Player>();
	public int coinCounter = 0;
	public int totalScore = 0;
	ArrayList<AnimatedSprite> coins = new ArrayList<AnimatedSprite>();
	ArrayList<Sprite> blocks = new ArrayList<Sprite>();
	LevelTwo lt = new LevelTwo();
	
	Point coinAnimate = new Point (0, 5);
	public ArrayList <String> coinActions = new ArrayList <String> (Arrays.asList("coinAnimate"));
	public ArrayList <Point> coinCoordList = new ArrayList <Point> (Arrays.asList(coinAnimate));
	Point doorAnimate = new Point (0, 3);
	public ArrayList <String> doorActions = new ArrayList <String> (Arrays.asList("doorAnimate"));
	public ArrayList <Point> doorCoordList = new ArrayList <Point> (Arrays.asList(doorAnimate));
	AnimatedSprite coin = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	AnimatedSprite coin1 = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	AnimatedSprite coin2 = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	AnimatedSprite coin3 = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	AnimatedSprite coin4 = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	AnimatedSprite coin5 = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	AnimatedSprite coin6 = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	AnimatedSprite coin7 = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	AnimatedSprite coin8 = new AnimatedSprite ("coin", coinActions, coinCoordList, 6);
	
	AnimatedSprite door = new AnimatedSprite ("door", doorActions, doorCoordList, 4);
	private boolean doorOpen = false;
	private boolean killPlayer = false;
	private boolean inAbyss = false;
	private boolean player1Alive = true;
	private boolean player2Alive = true;
	private boolean player3Alive = true;
	private boolean player4Alive = true;
	//private boolean hasJumped = false;
	
	Sprite block0 = new Sprite("block");
	Sprite block1 = new Sprite("block");
	Sprite block2 = new Sprite("block");
	Sprite block3 = new Sprite("block");
	Sprite block4 = new Sprite("block");
	Sprite block5 = new Sprite("block");
	Sprite block6 = new Sprite("block");
	Sprite block7 = new Sprite("block");
	
	Obstacles o = new Obstacles();
	
//	ArrayList<Sprite> spikes = new ArrayList<Sprite>();
//	ArrayList<Sprite> lavaPits = new ArrayList<Sprite>();
//	ArrayList<Sprite> platforms = new ArrayList<Sprite>();
	
	DisplayObjectContainer levelOne = new DisplayObjectContainer();
	private int timeCounter = 180;
	
	Sprite ground = new Sprite("Ground", "ground.png");
	
	//SoundManager jumpEffect = new SoundManager();

	private Camera gameCam = new Camera();
	
	public Prototype() {
		//super("OneLife Prototype Game", 820, 670);
		super("level 1");
		o.addObstacles();
		
		Sprite layer1 = new Sprite("Layer 1", "Layer.png");
		Sprite layer2 = new Sprite("Layer 2", "Layer.png");
		Sprite layer3 = new Sprite("Layer 3", "Layer.png");
		Sprite layer4 = new Sprite("Layer 4", "Layer.png");
		
//		Sprite ground = new Sprite("Ground", "ground.png");
		
//		Sprite spike1 = new Sprite("Spike 1", "spike.png");
//		Sprite spike2 = new Sprite("Spike 2", "spike.png");
//		Sprite spike3 = new Sprite("Spike 3", "spike.png");
//		Sprite spike4 = new Sprite("Spike 4", "spike.png");
		
//		Sprite lava1 = new Sprite("Lava 1", "lava.png");
//		Sprite lava2 = new Sprite("Lava 2", "lava.png");
//		Sprite lava3 = new Sprite("Lava 3", "lava.png");
		
//		Sprite platform1 = new Sprite("Platform 1", "ledge.png");
		
		ArrayList<String> actions = new ArrayList<String>();
		actions.add("standing"); actions.add("running"); actions.add("jumping");
		Point stand = new Point(0, 0);
		Point run = new Point(8, 15);
		Point jump = new Point(16, 23);
		ArrayList<Point> coors = new ArrayList<Point>();
		coors.add(stand); coors.add(run); coors.add(jump);
		Player p1 = new Player("tails", actions, coors, 23);
		Player p2 = new Player("tails", actions, coors, 23);
		Player p3 = new Player("tails", actions, coors, 23);
		Player p4 = new Player("tails", actions, coors, 23);
		p1.animate("standing");
		p2.animate("standing");
		p3.animate("standing");
		p4.animate("standing");
		
		
		layers.add(layer1);
		layers.add(layer2);
		layers.add(layer3);
		layers.add(layer4);
		
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		
		coins.add(coin);
		coins.add(coin1);
		coins.add(coin2);
		coins.add(coin3);
		coins.add(coin4);
		coins.add(coin5);
		coins.add(coin6);
		coins.add(coin7);
		coins.add(coin8);

		layer1.addChild(ground, layer1);
		layer2.addChild(ground, layer2);
		//layer3.addChild(ground, layer3);
		layer4.addChild(ground, layer4);
		
		for (Sprite block: o.getBlocks()) {
			layer1.addChild(block, layer1);
		}
		for (Sprite spike: o.getSpikes()) {
			layer2.addChild(spike, layer2);
		}
		for (Sprite platform: o.getPlatforms()) {
			layer3.addChild(platform, layer3);
		}
		for (Sprite lava: o.getLava()) {
			layer4.addChild(lava, layer4);
		}
		
//		blocks.add(block0);
//		blocks.add(block1);
//		blocks.add(block2);
//		blocks.add(block3);
//		blocks.add(block4);
//		blocks.add(block5);
//		blocks.add(block6);
//		blocks.add(block7);
		
//		spikes.add(spike1);
//		spikes.add(spike2);
//		spikes.add(spike3);
//		spikes.add(spike4);
		
//		platforms.add(platform1);
//		
//		lavaPits.add(lava1);
//		lavaPits.add(lava2);
//		lavaPits.add(lava3);

		
		layer1.addChild(door, layer1);
		layer2.addChild(door, layer2);
		layer3.addChild(door, layer3);
		layer4.addChild(door, layer4);
		
		//layer1.addChild(coin, layer1);
		//layer2.addChild(coin, layer2);
		//layer3.addChild(coin, layer3);
		//layer4.addChild(coin, layer4);
		layer1.addChild(coin1, layer1);
		layer2.addChild(coin2, layer2);
		layer3.addChild(coin3, layer3);
		layer4.addChild(coin4, layer4);
		layer1.addChild(coin5, layer1);
//		layer2.addChild(coin6, layer2);
//		layer3.addChild(coin7, layer3);
//		layer4.addChild(coin8, layer4);
		
		layer1.addChild(p1, layer1);
		layer2.addChild(p2, layer2);
		layer3.addChild(p3, layer3);
		layer4.addChild(p4, layer4);
		
//		layer1.addChild(spike1, layer1);
//		layer2.addChild(spike2, layer2);
//		layer3.addChild(spike3, layer3);
//		layer4.addChild(spike4, layer4);
		
//		layer1.addChild(platform1, layer1);
//		
//		layer4.addChild(lava1, layer4);
//		layer4.addChild(lava2, layer4);
//		layer4.addChild(lava3, layer4);
		
		this.addChild(levelOne, this);
		levelOne.addChild(layer1, levelOne);
		levelOne.addChild(layer2, levelOne);
		levelOne.addChild(layer3, levelOne);
		levelOne.addChild(layer4, levelOne);
		
//		this.addChild(layer1, this);
//		this.addChild(layer2, this);
//		this.addChild(layer3, this);
//		this.addChild(layer4, this);
		
		p1.xpos = 10;
		p2.xpos = 10;
		p3.xpos = 10;
		p4.xpos = 10;
		p1.ypos = 75;
		p2.ypos = 75;
		p3.ypos = 75;
		p4.ypos = 75;
		
		//coin.xpos = 1500;
		coin1.xpos = 400;
		coin2.xpos = 1200;
		coin3.xpos = 700;
		coin4.xpos = 100;
		coin5.xpos = 700;
//		coin6.xpos = 600;
//		coin7.xpos = 800;
//		coin8.xpos = 300;
		//coin.ypos = 25;
		coin1.ypos = 25;
		coin2.ypos = 25;
		coin3.ypos = 25;
		coin4.ypos = 25;
		coin5.ypos = 25;
//		coin6.ypos = 25;
//		coin7.ypos = 25;
//		coin8.ypos = 25;
		
		door.xpos = 1500;
		door.ypos = 40;
		
		///**
		coin.scaleX = 0.5;
		coin1.scaleX = 0.5;
		coin2.scaleX = 0.5;
		coin3.scaleX = 0.5;
		coin4.scaleX = 0.5;
		coin5.scaleX = 0.5;
		coin6.scaleX = 0.5;
		coin7.scaleX = 0.5;
		coin8.scaleX = 0.5;
		coin.scaleY = 0.5;
		coin1.scaleY = 0.5;
		coin2.scaleY = 0.5;
		coin3.scaleY = 0.5;
		coin4.scaleY = 0.5;
		coin5.scaleY = 0.5;
		coin6.scaleY = 0.5;
		coin7.scaleY = 0.5;
		coin8.scaleY = 0.5;
		//**/
//		for (Player p : players) {
//			p.setScaleX(0.5);
//			p.setScaleY(0.5);
//		}
		
		
		ground.xpos = 0;
		ground.ypos = 126;
		
		layer1.xpos = 10;
		layer1.ypos = 10;
		layer2.xpos = 10;
		layer2.ypos = 170;
		layer3.xpos = 10;
		layer3.ypos = 330;
		layer4.xpos = 10;
		layer4.ypos = 490;
		
//		platform1.xpos = 200;
//		platform1.ypos = 60;
		
//		spike1.xpos = 100;
//		spike2.xpos = 200;
//		spike3.xpos = 150;
//		spike4.xpos = 400;
//		spike1.ypos = 120;
//		spike2.ypos = 120;
//		spike3.ypos = 120;
//		spike4.ypos = 120;
		
//		lava1.xpos = 100;
//		lava2.xpos = 320;
//		lava3.xpos = 660;
//		lava1.ypos = 132;
//		lava2.ypos = 132;
//		lava3.ypos = 132;
		
//		for (AnimatedSprite p : players) {
//			p.scaleX = 0.5;
//			p.scaleY = 0.5;
//		}
		
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		if (timeCounter >= 0 && this.isVisible()) {
			timeCounter--;
		}
		allDead = true;
		
		if (!player1Alive) {
			players.get(0).setAlive(false);
		}
		if (!player2Alive) {
			players.get(1).setAlive(false);
		}
		if (!player3Alive) {
			players.get(2).setAlive(false);
		}
		if (!player4Alive) {
			players.get(3).setAlive(false);
		}
		
		for (Player p : players) {
			if (p.isAlive()) {
				allDead = false;
			}
		}
		
		for (AnimatedSprite c : coins) {
			if(c != null) c.animate("coinAnimate");
		}
		
		for (AnimatedSprite c : coins) {
			for (AnimatedSprite player: players) {
				if (player.collidesWith(c) && player.isVisible() == true && c.isVisible()) {
					coinCounter++;
					totalScore++;
					c.setVisible(false);
				}
			}
		}
		
		if (door != null) {
			if (reachedEnd()) {
				if (doorOpen == false) {
					door.looping = false;
					door.animationSpeed = 200;
					door.animate("doorAnimate");
					this.setVisible(false);
					lt.totalScore += this.totalScore;
				}
				doorOpen = true;
			}
		}
		
		if (players.get(0).xpos > 400) {
			if (players.get(0).xpos < 1200) {
				if (players.get(0).isFacingLeft())
					gameCam.setPosition(players.get(0).xpos - players.get(0).getUnscaledWidth() - 400, 0);
				else
					gameCam.setPosition(players.get(0).xpos - 400, 0);
			}
		}
		
		if (pressedKeys.size() == 0) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).animate("standing");
			}
		}
		
		for (AnimatedSprite player : players) {
			//for (Sprite platform : platforms()) {
			ArrayList<DisplayObject> inLayerPlatforms = ( (DisplayObjectContainer) player.getParent()).getAllChildren();
			for (DisplayObject platform : inLayerPlatforms) {
//				for (Sprite b : o.blocks) {
//					if (player.landsOn(b)) {
//						player.setAcceleration(0);
//						player.setVelocity(0);
//						player.setJumping(false);
//					}
//				}
				if(player.landsOn(platform) && platform.getId() != "coin")  {
					//System.out.println(players.get(3).isJumping());
					player.setAcceleration(0);
					player.setVelocity(0);
					player.setJumping(false);
					//System.out.println(players.get(2).isJumping());
				}
				if (player.landsOn(ground) && !(players.get(2) == player)) {
					//System.out.println(players.get(2).isJumping());
					player.setAcceleration(0);
					player.setVelocity(0);
					player.setJumping(false);
				}
				else {
					player.setJumping(true);
					//player.ypos += player.getAcceleration();
				}
			}
//			for (Sprite p : o.getPlatforms()) {
//				if (players.get(0).landsOn(p)) {
//					players.get(0).setAcceleration(0);
//					players.get(0).setVelocity(0);
//					players.get(0).setJumping(false);
//				}
//			}
//			for (Sprite b : o.getBlocks()) {
//				if (players.get(2).landsOn(b)) {
//					players.get(2).setAcceleration(0);
//					players.get(2).setVelocity(0);
//					players.get(2).setJumping(false);
//				}
//			}
				/** **/
				if (player.isJumping()) {
	   				player.setAcceleration(gravity);
	   				player.setVelocity(player.getVelocity() + player.getAcceleration());
	   				//player.setYpos(player.getYpos() + (int) player.getVelocity());
	   				inBounds(player, player.getXpos(), (int)(player.getYpos() + player.getVelocity()));
	   				 
	   			}
	   			else {
	   				player.setAcceleration(0);
	   			}
			}
//			if (timeCounter > 100) {
//				for (int i = 0; i < pressedKeys.size(); i++) {
//					
//					//if (pressedKeys.get(i) == KeyEvent.VK_SPACE) {
//					/**
//					if (pressedKeys.contains(KeyEvent.VK_SPACE)) {
//						for (AnimatedSprite player : players) {
//							if (player != null) {
//								if (player.isJumping() == false) {
//									//player.animate("jumping");
//									//player.setAcceleration(gravity - 4);
//									player.setVelocity(-5);
//									//System.out.println("CHANGING Y POSITION");
//									player.setYpos(player.getYpos() + (int) player.getVelocity());
//									//jumpEffect.playSound("jump.wav");
//									player.setJumping(true);
//								}
//								//player.setJumping(true);
//								//else {
//									
//							}
//						}
//					}
//					**/
//					
//					if (pressedKeys.get(i).equals(KeyEvent.VK_LEFT)) {
//						for (int x = 0; x < players.size(); x++) {
//							inBounds(players.get(x), players.get(x).getXpos() - 5, players.get(x).getYpos());
//							players.get(x).animate("running");
//						}
//					}
//					if (pressedKeys.get(i).equals(KeyEvent.VK_RIGHT)) {
//						for (int x = 0; x < players.size(); x++) {
//							inBounds(players.get(x), players.get(x).getXpos() + 5, players.get(x).getYpos());
//							players.get(x).animate("running");
//						}
//					}
//					if (pressedKeys.get(i).equals(KeyEvent.VK_UP)) {
//						for (int x = 0; x < players.size(); x++) {
//	//						players.get(x).animationSpeed = 200;
//	//						players.get(x).animate("jumping");
//							inBounds(players.get(x), players.get(x).getXpos(), players.get(x).getYpos() - 5);
//							players.get(x).setJumping(true);
//	//						inBounds(players.get(x), players.get(x).getXpos(), (int)(players.get(x).getYpos() + players.get(x).getVelocity()));
//						}
//					}
//	//				if (pressedKeys.get(i).equals(KeyEvent.VK_DOWN)) {
//	//					for (int x = 0; x < players.size(); x++) {
//	//						inBounds(players.get(x), players.get(x).getXpos(), players.get(x).getYpos() + 5);
//	//					}
//	//				}
//				}
//			}
		
			if (timeCounter <= 0) {
	      		 for(Player p : players) {
	      			 int oldX = p.getXpos();
	      			 for (int i = 0; i < pressedKeys.size(); i++) {
	      				if (pressedKeys.get(i).equals(KeyEvent.VK_RIGHT)) {
//	      					 if (p.isFacingLeft()) {
//	      						 p.setFacingLeft(false);
//	      						 p.setScaleX(1.0);
//	      						 p.setXpos(p.getXpos() - p.getUnscaledWidth());
//	      					 }
//	      					 else
	      						 inBounds(p, p.getXpos() + 5, p.getYpos());
//	      					if (!p.isJumping())
	      						 p.animate("running");
//	      					 System.out.println(collidesBlock(p, o));
	      				 }
	      				 
	      				 if(collidesBlock(p, o) && p.isVisible()) {
	      					 players.get(0).setXpos(p.xpos -1);
	      					 players.get(1).setXpos(p.xpos -1);
	      					 players.get(2).setXpos(p.xpos -1);
	      					 players.get(3).setXpos(p.xpos -1);
	      				 }
	      			 
	      			 
	      				 if (pressedKeys.get(i).equals(KeyEvent.VK_LEFT)) {
//	      					 if (!p.isFacingLeft()) {
//	      						p.setFacingLeft(true);
//	      						p.setScaleX(-1.0);
//	      						p.setXpos(p.getXpos() + p.getUnscaledWidth());
//	      						inBounds(p, p.getXpos() + 5, p.getYpos());
//	      					 }
//	      					 else
	      						 inBounds(p, p.getXpos() - 5, p.getYpos());
//	      					if (!p.isJumping())
	      						 p.animate("running");
	      				 }
	      				 
	      				 if(collidesBlock(p, o) && p.isVisible()) {
	      					 players.get(0).setXpos(oldX);
	      					 players.get(1).setXpos(oldX);
	      					 players.get(2).setXpos(oldX);
	      					 players.get(3).setXpos(oldX);
	      				 }
	      				 
	      				 if (pressedKeys.get(i).equals(KeyEvent.VK_UP)) {
	      					 p.animationSpeed = 200;
	      					 inBounds(p, p.getXpos(), p.getYpos() - 4);
	      					if (p.isJumping()) {
	      						 p.animate("jumping");
	      					 }
	      					 p.setJumping(true);
	//                   	inBounds(players.get(x), players.get(x).getXpos(), (int)(players.get(x).getYpos() + players.get(x).getVelocity()));
	      				 }
	      			 }
	      		 }
	       	}

			
			for (int x = 0; x < players.size(); x++) {
		 		for (int j = 0; j < o.getSpikes().size(); j ++) {
			 		if(players.get(x).collidesWith(o.getSpikes().get(j)) && players.get(x).isVisible()) {
				 		players.get(x).setAlpha(0);
				 		players.get(x).setAlive(false);
				 		deadPlayers.add(players.get(x));
				 		setKillPlayer(true);
				 		deadLayer();
				 		setKillPlayer(false);
			 		}
		 		}
			}
			
			for (int x = 0; x < players.size(); x++) {
				for (int j = 0; j < o.getLava().size(); j ++) {
					if(players.get(x).collidesWith(o.getLava().get(j)) && players.get(x).isVisible()) {
						players.get(x).setAlpha(0);
				 		players.get(x).setAlive(false);
				 		deadPlayers.add(players.get(x));
				 		setKillPlayer(true);
				 		deadLayer();
				 		setKillPlayer(false);
					}
				}
			}
			
			if (inAbyss && players.get(2).isAlive()) {
          		 int layerX = layers.get(2).xpos;
          		 int layerY = layers.get(2).ypos;
          		 players.get(2).setAlive(false);
          		 Sprite layerDead = new Sprite("LayerDead", "LayerDead.png");
      			 levelOne.removeChild(layers.get(2));
      			 levelOne.addChild(layerDead, levelOne);
      			 layerDead.setXpos(layerX);
      			 layerDead.setYpos(layerY);
      			 setInAbyss(false);
           	}
			if(!(players.get(0).isAlive())) {
          		 setPlayer1Alive(false);
          		 lt.setPlayer1Alive(false);
           	}
           	if(!(players.get(1).isAlive())) {
          		 setPlayer2Alive(false);
          		 lt.setPlayer2Alive(false);
           	}
           	if(!(players.get(2).isAlive())) {
          		 setPlayer3Alive(false);
          		 lt.setPlayer3Alive(false);
           	}
           	if(!(players.get(3).isAlive())) {
          		 setPlayer4Alive(false);
          		 lt.setPlayer4Alive(false);
           	}
           	
           	if (!(deadPlayers.size() == 0)) {
        		if (coinCounter >= 5) {
        			if (deadPlayers.get(0) == players.get(0)) {
        				lt.setPlayer1Alive(true);
        				lt.coinCounter = 0;
        			}
        			else if (deadPlayers.get(0) == players.get(1)) {
        				lt.setPlayer2Alive(true);
        				lt.coinCounter = 0;
        			}
        			else if (deadPlayers.get(0) == players.get(2)) {
        				lt.setPlayer3Alive(true);
        				lt.coinCounter = 0;
        			}
        			else if (deadPlayers.get(0) == players.get(3)) {
        				lt.setPlayer4Alive(true);
        				lt.coinCounter = 0;
        			}
        		}
        	}
		
	}


	
	@Override
	public void draw(Graphics g) {
		if (g != null && gameCam != null) {
			gameCam.translateToPosition((Graphics2D) g);
			super.draw(g);
		}
		Font f = g.getFont();
		Font newFont = f.deriveFont(f.getSize2D() * 6);
		g.setColor(Color.red);
		if (timeCounter >= 0) {
			g.setFont(newFont);
			g.drawString("Ready? " + Integer.toString(timeCounter/60 + 1), 250, 335);
		}
		Font coinFont = f.deriveFont(f.getSize2D() * 2);
    	g.setColor(Color.ORANGE);
    	g.setFont(coinFont);
    	g.drawString("Coins: " + totalScore, (int)gameCam.getX() + 600, (int)gameCam.getY() + 40);
	}
	
	private boolean reachedEnd() {
		for (AnimatedSprite p : players) {
			if (p.getHitbox().intersects(door.getHitbox())) {
				return true;
			}
		}
		return false;
	}
	
	
	private void inBounds(DisplayObject o, int x, int y) {
		int origX = x;
		int origY = y;
		DisplayObject p = o.getParent();
		int parX = p.getXpos();
		int parY = p.getYpos();
		
		Rectangle r = o.getGlobalHitbox().getBounds();
		if (x == o.xpos)
			x = r.x;
		else
			x = x + parX;
		
		if (y == o.ypos)
			y = r.y;
		else
			y = y + parY;
		
		if (x + o.getUnscaledWidth() > parX + p.getUnscaledWidth()) {
			o.xpos = (parX + p.getUnscaledWidth() - o.getUnscaledWidth()) - parX;
			o.ypos = origY;
		}
		else if (x < parX) {
			o.xpos = parX - parX + 1;
			o.ypos = origY;
		}
		else if (y + o.getUnscaledHeight() > parY + p.getUnscaledHeight()) {
			o.xpos = origX;
			o.ypos = (parY + p.getUnscaledHeight() - o.getUnscaledHeight()) - parY + 1;
			setInAbyss(true);
//			Player pl = (Player) o;
//			pl.setAlive(false);
		}
		else if (y < parY) {
			o.xpos = origX;
			o.ypos = parY - parY + 1;
		}
		else {
			o.xpos = origX;
			o.ypos = origY;
		}
	}

	public boolean collidesBlock(Player p, Obstacles o) {
    	for(Sprite block : o.getBlocks()) {
        	if(p.collidesWith(block) && ((p.getUnscaledHeight() + p.ypos) > block.ypos + 5)) {
            	return true;
        	}
    	}
    	return false;
	}
    
	 
	public boolean collidesPlatform(Player p, Obstacles o) {
    	for(Sprite platform : o.getPlatforms()) {
        	if(p.collidesWith(platform)) {
            	return true;
        	}
    	}
    	return false;
	}
	
	public void deadLayer() {
    	for(int i = 0; i < layers.size(); i++) {
   		 if(killPlayer && layers.get(i).getId() != "LayerDead") {
	    		 int layerX = layers.get(i).getXpos();
	    		 int layerY = layers.get(i).getYpos();
	    		 if(!players.get(i).isAlive()) {
	    			 Sprite layerDead = new Sprite("LayerDead", "LayerDead.png");
	    			 levelOne.removeChild(layers.get(i));
	    			 levelOne.addChild(layerDead, levelOne);
	    			 layerDead.setXpos(layerX);
	    			 layerDead.setYpos(layerY);
	    		 }
   		 }
   		 
   		 else {
   			 
   		 }
    	}
//    	setKillPlayer(false);
	}

	 public boolean isKillPlayer() {
		 return killPlayer;
	 }

	 public void setKillPlayer(boolean killPlayer) {
		 this.killPlayer = killPlayer;
	 }
	 public boolean isInAbyss() {
		 return inAbyss;
	 }

	 public void setInAbyss(boolean inAbyss) {
		 this.inAbyss = inAbyss;
	 }
	public boolean isPlayer1Alive() {
		 return player1Alive;
	 }

	 public void setPlayer1Alive(boolean player1Alive) {
		 this.player1Alive = player1Alive;
	 }

	 public boolean isPlayer2Alive() {
		 return player2Alive;
	 }

	 public void setPlayer2Alive(boolean player2Alive) {
		 this.player2Alive = player2Alive;
	 }

	 public boolean isPlayer3Alive() {
		 return player3Alive;
	 }

	 public void setPlayer3Alive(boolean player3Alive) {
		 this.player3Alive = player3Alive;
	 }

	 public boolean isPlayer4Alive() {
		 return player4Alive;
	 }

	 public void setPlayer4Alive(boolean player4Alive) {
		 this.player4Alive = player4Alive;
	 }


}
