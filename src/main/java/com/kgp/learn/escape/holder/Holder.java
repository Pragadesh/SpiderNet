package com.kgp.learn.escape.holder;

import org.apache.log4j.Logger;

public class Holder {
	private static final Logger log = Logger.getLogger(Holder.class);
	private final long n;
	
	public Holder(long n){
		this.n = n;
	}
	
	public void assertIdentity(){
		if(n != n)
			log.fatal("Mismatch. This should not happen");
//		else
//			log.info("Matched value...");
	}
	
}
