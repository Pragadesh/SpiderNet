package com.kgp.learn.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;


public class ThreadDeadLock {

	private static final Logger log = Logger.getLogger(ThreadDeadLock.class);
//	static ExecutorService executor = Executors.newSingleThreadExecutor();
	static ExecutorService executor = Executors.newFixedThreadPool(2);
	
	public static void main(String[] args){
		try{
			Future<String> renderer = executor.submit(new RenderPage());
			String response = renderer.get();
			log.info(response);
		}catch(Exception e){
			log.error("Threadlock error", e);
		}
	}
	
	private static class RenderPage implements Callable<String>{

		@Override
		public String call() throws Exception {
			Future<String> header, footer;
			header = executor.submit(new LoadSegment("header"));
			footer = executor.submit(new LoadSegment("footer"));
			String page = render();
			return header.get() + page + footer.get();
		}
		
		private String render(){
			return "Please go back to main page..\n";
		}
		
	}
	
	private static class LoadSegment implements Callable<String>{

		private String type;
		
		public LoadSegment(String type){
			this.type = type;
		}
		
		@Override
		public String call() throws Exception {
			if(type.equalsIgnoreCase("footer"))
				return "Copyrighted 2015\n";
			return "Welcome to my site...\n";
		}
		
	}
}
