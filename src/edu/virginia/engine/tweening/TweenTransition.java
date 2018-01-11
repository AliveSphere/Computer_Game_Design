package edu.virginia.engine.tweening;

public class TweenTransition {
	
	public String name;
	
	// Constructor
	public TweenTransition (String transName) {
		name = transName;
	}
	
	public double applyTransition(double percentageDone) {
		
		if (this.getName() == "linear") {
			return percentageDone;
		}
		if (this.getName() == "quadratic") {
			return Math.pow(percentageDone, 2);
		}
		if (this.getName() == "cubic") {
			return Math.pow(percentageDone, 3);
		}
		return percentageDone;
	}
	
	public void setName(String s) {
		this.name = s;
	}
	public String getName() {
		return this.name;
	}
	
	
}
