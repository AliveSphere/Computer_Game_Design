package onelife.maingame;

import edu.virginia.engine.display.DisplayObjectContainer;

public class Level extends DisplayObjectContainer {
	
	protected boolean allDead;
	protected final double gravity = 0.1;
	
	public Level(String s) {
		super(s);
	}
	
	public boolean getAllDead() {
		return allDead;
	}
	
	public void setAllDead(boolean b) {
		allDead = b;
	}
}