package com.kgp.learn.escape;

import org.apache.log4j.Logger;

public class ThisEscape {
	
	private static final Logger log = Logger.getLogger(ThisEscape.class);
	private String escapeStr;
	public ThisEscape(String escapeStr, EventSource source){
		this.escapeStr = escapeStr;
		source.registerListener(new EventListener() {
			
			@Override
			public void performAction(Event e) {
				System.out.println(e);
			}
		});
	}
	
	@Override
	public String toString(){
		return "Escape Type: "+ escapeStr;
	}
	
	public static void main(String[] args){
		EventSource source = new EventSource();
		ThisEscape escape = new ThisEscape("trueEscape",source);
		log.info("Exit application..."+escape);
	}

}
