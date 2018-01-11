package edu.virginia.engine.tweening;

import edu.virginia.engine.events.*;

public class TweenEvent extends Event {

	final static String TWEEN_COMPLETE_EVENT = "";
	public String tweenEventType;
	public Tween tween;

	/** Constructor **/
	public TweenEvent(String eventType, Tween tween) {
		super(eventType, tween);
		setTweenEventType(eventType);
		setTweenSource(tween);
	}
	
	
	/** Getters and setters begin **/
	public String getTweenEventType() {
		return tweenEventType;
	}
	public void setTweenEventType(String tweenEventType) {
		this.tweenEventType = tweenEventType;
	}
	
	public Tween getTweenSource() {
		return tween;
	}
	public void setTweenSource(Tween source) {
		this.tween = source;
	}
	/** Getters and setters end **/

//	public void handleTweenEvent(Tween tween) {
//		if (tween.getTweenSource().getTweenEventType() == "Tween complete") {
//			
//		}
//	}
}
