package restaurantSimulator;

import waitingLine.ClerkWaitingLine;
import waitingLine.PaymentWaitingLine;

public class PaymentThread implements Runnable{
	private RestaurantTask task;
	
	public PaymentThread() {
		task = new RestaurantTask();
	}
	//when clerk isn't working and sombody request Payment, clerk take care of payment
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized(this) {
				if((ClerkWaitingLine.getInstance().getListSize() > 0) && (PaymentWaitingLine.getInstance().getListSize() > 0)) {
					try{
						task.payment();
					}catch(IndexOutOfBoundsException ie) {
						new RuntimeException(ie);
					}
				}
				try {
					Thread.sleep(503);	//0.6초에 한번씩 직원라인이 비는지 검사한다.
				}catch(InterruptedException ie) {
					return;
				}
			}
		}
	}
}
