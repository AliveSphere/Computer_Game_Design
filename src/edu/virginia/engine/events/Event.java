package edu.virginia.engine.events;

//import edu.virginia.engine.display.*;
//import edu.virginia.engine.util.*;
//import edu.virginia.lab4test.*;

public class Event {
	
	public String eventType;
	public IEventDispatcher source;
	
	// Constructor
	public Event(String eventType, IEventDispatcher source) {
		setEventType(eventType);
		setSource(source);
	}

	// Getters and setters begin
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public IEventDispatcher getSource() {
		return source;
	}

	public void setSource(IEventDispatcher source) {
		this.source = source;
	}
	// Getters and setters end
}
