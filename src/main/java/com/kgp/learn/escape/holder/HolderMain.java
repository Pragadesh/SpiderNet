package com.kgp.learn.escape.holder;

import org.apache.log4j.Logger;

public class HolderMain {

	public static Holder holder;
	private static final Logger log = Logger.getLogger(HolderMain.class);
	
	private static final long MaxRuns = Long.MAX_VALUE;
	public void initialize(long val){
		holder = new Holder(val);
	}
	
	
	public static void main(String[] args) {
		HolderMain holderMain = new HolderMain();
		MonitorThread mThread1 = new MonitorThread(holderMain);
		mThread1.setName("Monitor-Thread-1");
		mThread1.start();
		MonitorThread mThread2 = new MonitorThread(holderMain);
		mThread2.setName("Monitor-Thread-2");
		mThread2.start();
		log.info("Continue with main thread...");
		long val = 0;
		while(true){
			if(++val == MaxRuns) val = 0;
			holderMain.initialize(val);
		}
	}
	


}
