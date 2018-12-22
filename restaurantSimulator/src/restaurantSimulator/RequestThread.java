package restaurantSimulator;

import java.util.*;

import waitingLine.WaitingLineEnum;

public class RequestThread implements Runnable{
	private RestaurantTask task;
	private WaitingLines waitingLines;
	
	public RequestThread() {
		task = new RestaurantTask();
		waitingLines = new WaitingLines();
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
				if(waitingLines.getClerkWaitingLine().getListSize() > 0) {
					task.requestOrder();
					timer.cancel();
					break;
				}
			}
		}
	}
}