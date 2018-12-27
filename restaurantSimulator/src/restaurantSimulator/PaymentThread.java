package restaurantSimulator;

import java.util.Timer;
import java.util.TimerTask;

import waitingLine.ClerkWaitingLine;
import waitingLine.OrderRequestLine;
import waitingLine.PaymentWaitingLine;

public class PaymentThread implements Runnable{
	private RestaurantTask task;
	
	public PaymentThread() {
		task = new RestaurantTask();
	}
	
	//오류
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public synchronized void run() {
					task.countPayWaitTime();
				}
			}, 1000, 1000 );
			while(true) {
				synchronized(this) {
					if((ClerkWaitingLine.getInstance().getListSize() > 0) && (PaymentWaitingLine.getInstance().getListSize() > 0)) {
						task.payment();
						timer.cancel();
						break;
					}
					try {
						Thread.sleep(502);	//0.6초에 한번씩 직원라인이 비는지 검사한다.
					}catch(InterruptedException ie) {
						timer.cancel();
						return;
					}
				}
			}
		}
	}
}
