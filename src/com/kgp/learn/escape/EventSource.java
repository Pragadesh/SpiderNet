package com.kgp.learn.escape;

import java.util.ArrayList;
import java.util.List;

public class EventSource {

	public List<EventListener> listeners = new ArrayList<>();
	
	public void registerListener(EventListener listener){
		listeners.add(listener);
	}
	
}
