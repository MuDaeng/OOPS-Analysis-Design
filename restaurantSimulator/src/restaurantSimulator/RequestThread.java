package restaurantSimulator;

import java.util.*;

import waitingLine.ClerkWaitingLine;

public class RequestThread implements Runnable{
	private RestaurantTask task;
	
	public RequestThread() {
		task = new RestaurantTask();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public synchronized void run() {
				task.countReqWaitTime();
			}
		}, 1000, 1000 );
		while(true) {
			synchronized(this) {
				if(ClerkWaitingLine.getInstance().getListSize() > 0) {
					task.resolveOrder();
					timer.cancel();
					break;
				}
			}
			try {
				Thread.sleep(50);	
			}catch(InterruptedException ie) {}
		}
	}
}