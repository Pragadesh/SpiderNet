package com.kgp.learn.escape;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class EventSource {
	
	private static final Logger log = Logger.getLogger(EventSource.class);

	public List<EventListener> listeners = new ArrayList<>();
	
	public void registerListener(EventListener listener){
		listeners.add(listener);
		fetchOuterClass(listener);
	}
	
	public void fetchOuterClass(EventListener listener){
		try{
			Field field = listener.getClass().getDeclaredField("this$0");
			field.setAccessible(true);
			ThisEscape outer = (ThisEscape) field.get(listener);
			log.info(outer);
		}catch(Exception e){
			System.err.println(e);
		}
	}
	
}
