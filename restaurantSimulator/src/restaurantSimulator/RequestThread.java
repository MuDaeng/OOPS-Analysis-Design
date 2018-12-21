package restaurantSimulator;

import java.util.*;

import waitingLine.WaitingLineEnum;

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
				if(WaitingLineEnum.CLERKWAITINGLINE.waitListSize() > 0) {
					task.requestOrder();
					timer.cancel();
					break;
				}
			}
		}
	}
}