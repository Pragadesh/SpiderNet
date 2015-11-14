package com.kgp.learn.escape.holder;

import org.apache.log4j.Logger;

public class MonitorThread extends Thread{
	
	private static final Logger log = Logger.getLogger(MonitorThread.class);

	private HolderMain holderMain;
	public MonitorThread(HolderMain holderMain){
		this.holderMain = holderMain;
	}
	
	public void run(){
		try{Thread.currentThread().sleep(1000);}catch(Exception e){};
		log.info("Starting " + Thread.currentThread().getName() + "...");
		while (true){
//			try{
				holderMain.holder.assertIdentity();
//			}catch(Exception e){}
		}
	}
}