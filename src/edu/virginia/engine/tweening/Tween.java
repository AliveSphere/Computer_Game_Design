package edu.virginia.engine.tweening;

import java.util.ArrayList;

import edu.virginia.engine.display.DisplayObject;
import edu.virginia.engine.events.*;
import edu.virginia.engine.util.GameClock;

public class Tween extends EventDispatcher {
	
	ArrayList<TweenParam> parallelParams = new ArrayList<TweenParam>();
	DisplayObject tweenedObject;
	//TweenTransitions transition
	GameClock timer = new GameClock();
	TweenTransition trans = new TweenTransition("");
	private boolean firstUpdate = false;
	
	
	// Constructors
	public Tween(DisplayObject obj) {
		tweenedObject = obj;
	}
	public Tween(DisplayObject obj, TweenTransition transition) {
		tweenedObject = obj;
		trans = transition;
	}
	
	
	public void animate(TweenableParam fieldToAnimate, double startVal, double endVal, double time) {
		parallelParams.add(new TweenParam(fieldToAnimate, startVal, endVal, time));
	}

	public boolean isComplete() {
		for (TweenParam t : parallelParams) {
			if (!t.isComplete(timer.getElapsedTime())) {
				return false;
			}
		}
		return true;
	}
	
	public void handleTweenEvent(Tween source, TweenEvent tweenEvent) {
		if (tweenEvent.getTweenEventType() == "Tween complete") {
			//System.out.println("We in dis bitch");
			//System.out.println(tweenEvent.getTweenEventType());
//			source.animate(TweenableParam.X_SCALE, 1, 2, 5000);
//			source.animate(TweenableParam.Y_SCALE, 1, 2, 5000);
//			source.animate(TweenableParam.X_POS, 0, Math.sqrt(400), 5000);
//			source.animate(TweenableParam.Y_POS, 0, Math.sqrt(400), 5000);
		}
	}
	
	public void update() {
		if (firstUpdate == false) {
			timer.resetGameClock();
		}
		
		for(TweenParam tp : parallelParams) {
			tp.update(timer.getElapsedTime());
			setValue(tp.getParam(), trans.applyTransition(tp.getCurrentValue()));
		}
		
		firstUpdate = true;
		
	}
	
	public void setValue(TweenableParam param, double value) {
		if (param == TweenableParam.X_POS){
			this.tweenedObject.xpos = (int) value;
		}
		if (param == TweenableParam.Y_POS){
			this.tweenedObject.ypos = (int) value;
		}
		if (param == TweenableParam.X_SCALE){
			this.tweenedObject.scaleX = value;
		}
		if (param == TweenableParam.Y_SCALE){
			this.tweenedObject.scaleY = value;
		}
		if (param == TweenableParam.X_PIVOT){
			this.tweenedObject.xpivot = value;
		}
		if (param == TweenableParam.Y_PIVOT){
			this.tweenedObject.ypivot = value;
		}
		if (param == TweenableParam.ALPHA){
			this.tweenedObject.alpha = (float) value;
		}
	}

	
}
