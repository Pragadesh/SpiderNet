package com.kgp.learn.escape;

public class ThisEscape {
	
	public ThisEscape(EventSource source){
		source.registerListener(new EventListener() {
			
			@Override
			public void performAction(Event e) {
				System.out.println(e);
			}
		});
	}
	
	
	public static void main(String[] args){
		EventSource source = new EventSource();
		ThisEscape escape = new ThisEscape(source);
		System.out.println("Exit application...");
	}

}
