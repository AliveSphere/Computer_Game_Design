package edu.virginia.engine.events;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher implements IEventDispatcher {

	
	public HashMap <String, ArrayList<IEventListener> > eventMap = new HashMap <String, ArrayList<IEventListener> >();
	
	// Constructors
	public EventDispatcher (IEventListener listener, String eventType) {
		ArrayList <IEventListener> a1 = new ArrayList<IEventListener>();
		a1.add(listener);
		eventMap.put(eventType, a1);
	}
	public EventDispatcher () {
	}
	//End constructors
	
	@Override
	public void addEventListener(IEventListener listener, String eventType) {
	//public void addEventListener(QuestManager qm, PickedUpEvent.COIN_PICKED_UP) {
		if (eventMap.containsKey(eventType)) {
			eventMap.get(eventType).add(listener);
		}
		else {
			ArrayList <IEventListener> a1 = new ArrayList<IEventListener>();
			a1.add(listener);
			eventMap.put(eventType, a1);
		}
	}
	
	@Override
	public void removeEventListener(IEventListener listener, String eventType) {
		if (eventMap.containsKey(eventType)) {
			eventMap.get(eventType).remove(listener);
		}
	}

	@Override
	public void dispatchEvent(Event event) {
		if (eventMap.containsKey(event.getEventType())) {
			for (IEventListener l : eventMap.get(event.getEventType())) {
				l.handleEvent(event);
			}
		}
	}

	@Override
	public boolean hasEventListener(IEventListener listener, String eventType) {
		if (eventMap.containsKey(eventType)) {
			return eventMap.get(eventType).contains(listener);
		}
		return false;
	}

}
