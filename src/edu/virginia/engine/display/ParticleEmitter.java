package edu.virginia.engine.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import edu.virginia.engine.util.GameClock;

public class ParticleEmitter extends DisplayObject {
	
	private HashMap<Point, ArrayList<Ember> > origins;
	
	public ParticleEmitter(String id, DisplayObject parent) {
		super(id);
		origins = new HashMap<Point, ArrayList<Ember> >();
	}
	
	public void addEmitter(int x, int y) {
		origins.put(new Point(x, y), new ArrayList<Ember>());
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
		
		for (Point p : origins.keySet()) {
			if (origins.get(p).size() < 5) {
				origins.get(p).add(new Ember(p.x, p.y));
			}
		}
		
		ArrayList<ArrayList<Ember> > vals = (ArrayList<ArrayList<Ember>>) origins.values();
		for (int i = 0; i < vals.size(); i++) {
			for (int j = 0; j < vals.get(i).size(); j++) {
				vals.get(i).get(j).update(pressedKeys);
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
		ArrayList<ArrayList<Ember> > vals = (ArrayList<ArrayList<Ember>>) origins.values();
		for (int i = 0; i < vals.size(); i++) {
			ArrayList<Ember> emitter = vals.get(i);
			if (emitter.size() < 1)
				vals.remove(emitter);
			else {
				for (int j = 0; j < emitter.size(); j++) {
					Ember curr = emitter.get(j);
					if (!curr.isVisible())
						emitter.remove(curr);
					else
						emitter.get(j).draw(g);
				}
			}
		}
	}
	
	private class Ember extends DisplayObject {
		private Rectangle ember;
		private int x;
		private int y;
		private double xVel;
		private double yVel;
		private final double gravity = 1.5;
		private GameClock timer;
		
		public Ember(int x, int y) {
			this.x = x;
			this.y = y;
			ember = new Rectangle(x, y, 5, 5);
			
			Random r = new Random();
			double ran = r.nextDouble();
			yVel = ran * -100;
			
			ran = r.nextDouble();
			int sign = r.nextInt(2);
			if (sign == 0)
				xVel = ran * -50;
			else
				xVel = ran * 50;
			
			timer = new GameClock();
		}
		
		@Override
		public void update(ArrayList<Integer> pressedKeys) {
			super.update(pressedKeys);
			
			double t = timer.getElapsedTime() / 1000;
			
			if (t > 5)
				this.setVisible(false);
			else {
				x = (int) (x + xVel);
				y = (int) (y + (yVel * gravity));
				
				ember.x = x;
				ember.y = y;
			}
			
		}
		
		@Override
		public void draw(Graphics g) {
			super.draw(g);
			
			g.setColor(Color.RED);
			g.fillRect(ember.x, ember.y, ember.width, ember.height);
			g.setColor(Color.BLACK);
		}
	}
}
