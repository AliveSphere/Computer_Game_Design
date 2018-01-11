package edu.virginia.engine.events;

public class CoinTouchedEvent extends Event {

	public CoinTouchedEvent(String eventType, IEventDispatcher source) {
		super(eventType, source);
		// TODO Auto-generated constructor stub
	}

	/*
	public final static String COIN_TOUCHED ="Coin touched";

	public CointTouchedEvent(IEventDispatcher source, String eventType) {
		super(eventType, source);
	}
	public CoinTouchedEvent(){
		super();
		this.setEventType(COIN_PICKED_UP);
	}*/
}
