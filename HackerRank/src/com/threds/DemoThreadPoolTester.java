package com.threds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DemoThreadPoolTester {
	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	public void test1(){
		List<ScheduledFuture<?>> list = new ArrayList<>();
		list.add(submitJobOne(executor));
		list.add(submitJobTwo(executor));
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(list.size());
		for(ScheduledFuture<?> f : list){
			newFixedThreadPool.execute(()->
				{
					try {
						f.get();
					}catch (Exception e) {
						e.printStackTrace();
						executor.shutdownNow();
						test1();
					}
				}
			);
		}
	}
	private ScheduledFuture<?> submitJobTwo(ScheduledExecutorService executor) {
		return executor.scheduleWithFixedDelay(()->{
			//task2
			System.out.println("task2");
		}, 1, 1, TimeUnit.SECONDS);
	}
	private ScheduledFuture<?> submitJobOne(ScheduledExecutorService executor) {
		return executor.scheduleWithFixedDelay(()->{
			//task1
			System.out.println("task1");
			if(Math.random()>0.9)
				throw new RuntimeException();
		}, 1, 1, TimeUnit.SECONDS);
	}
	public static void main(String[] args) {
		new DemoThreadPoolTester().test1();
	}
}


