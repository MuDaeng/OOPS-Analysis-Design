package restaurantSimulator;

import java.util.*;

import waitingLine.ClerkWaitingLine;
import waitingLine.OrderRequestLine;

public class RequestThread implements Runnable{
	private RestaurantTask task;
	
	public RequestThread() {
		task = new RestaurantTask();
	}
	
	//타이머가 1초에 한번씩 requestTime을 올려주며, 직원이 일을 처리하면 타이머가 멈춘다.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				task.countReqWaitTime();
			}
		}, 1000, 1000 );
		while(true) {
			synchronized(this) {
				if((ClerkWaitingLine.getInstance().getListSize() > 0) && (OrderRequestLine.getInstance().getListSize() > 0)) {
					task.resolveOrder();
					timer.cancel();
					break;
				}
			}
			try {
				Thread.sleep(50);	//0.05초에 한번씩 직원라인이 비는지 검사한다.
			}catch(InterruptedException ie) {
				break;
			}
		}
	}
}