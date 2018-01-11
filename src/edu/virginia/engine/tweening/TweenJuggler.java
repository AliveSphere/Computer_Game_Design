package edu.virginia.engine.tweening;

import java.util.ArrayList;

public class TweenJuggler {

	// add method is static and accessible from anywhere in your code
	// does most work of handling active tweens, and disposing ones that are complete

	// Singleton stuff;
	public static TweenJuggler instance;
	
	private ArrayList<Tween> tweenList = new ArrayList<Tween>();
	
	// Constructor
	public TweenJuggler() {
		if (instance == null) {
			instance = this;
		}
	}

	public void add(Tween tween) {
		Tween t = tween;
		tweenList.add(t);
	}

	public void remove(Tween tween) {
		tweenList.remove(tween);
	}
	
	public static TweenJuggler getInstance() {
		return instance;
	}

	// GAME CLASS NEEDS TO CALL THE TWEEN JUGGLER UPDATE EVERY FRAME
	public void update() {
		for (int i = 0; i < tweenList.size(); i++) {
			if (!tweenList.get(i).isComplete()) {
				tweenList.get(i).update();
			}
		}
		// for each tween in the list, call update on it.
	}

}
