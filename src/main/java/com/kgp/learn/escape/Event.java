package com.kgp.learn.escape;

public class Event {

	private String name;
	private String log;
	
	public Event(String name, String log){
		this.name=name;
		this.log=log;
	}
	
	@Override
	public String toString(){
		return name + " : " + log;
	}
	
}
