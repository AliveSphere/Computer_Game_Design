package edu.virginia.engine.events;

public class QuestManager implements IEventListener{

	private String eventType;
	
	// Constructor
	public QuestManager (String eventType) {
		this.eventType=eventType;
	}
	public QuestManager () {
	}
	
	@Override
	public void handleEvent(Event event) {
		if (event.getEventType() == "Coin touched") {
			System.out.println("All your base are belong to us!");
		}
		if (event.getEventType() == "Tween complete") {
			System.out.println("THIS IS HELL!");
//			Tween t = (Tween) event.getSource();
//			t.animate(TweenableParam.X_SCALE, 1, 2, 5000);
//			t.animate(TweenableParam.Y_SCALE, 1, 2, 5000);
//			t.animate(TweenableParam.X_POS, 0, Math.sqrt(400), 5000);
//			t.animate(TweenableParam.Y_POS, 0, Math.sqrt(400), 5000);
		}
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
}
