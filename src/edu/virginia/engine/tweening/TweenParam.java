package edu.virginia.engine.tweening;

import edu.virginia.engine.display.DisplayObject;

public class TweenParam {

	public TweenableParam parameter;
	public DisplayObject d;
	public double startValue, endValue, timeTotal;
	public double currentValue;

	// constructors
	public TweenParam() {
		
	}
	public TweenParam(TweenableParam paramToTween, double startVal, double endVal, double time) {
		parameter = paramToTween;
		startValue = startVal;
		endValue = endVal;
		timeTotal = time;
	}
	
	public TweenableParam getParam() {
		return this.parameter;
	}
	
	public double getStartVal() {
		return this.startValue;
	}
	public double getEndVal() {
		return this.endValue;
	}
	public double getTweenTime() {
		return this.timeTotal;
	}
	public double getCurrentValue() {
		return this.currentValue;
	}
	public void setCurrentValue(double current) {
		this.currentValue = current;
	}
	
	// Returns Boolean of if time is finished;
	public boolean isComplete (double timePassed) {
		if (timePassed >= timeTotal) {
			return true;
		}
		return false;
	}

	// (We’ll call this once a frame to set current to percentageDone between start and end)
	public void update (double timePassed) {
		double x = timePassed;
		double percentageDone = x/timeTotal;
		if (percentageDone <= 1) {
			//parameter.setValue(d, (startVal + (endVal - startVal) * percentageDone));
			//parameter.setValue(parameter, (startValue + (endValue - startValue) * percentageDone));
			setCurrentValue(startValue + (endValue - startValue) * percentageDone);
		}
	}

}
