package restaurantSimulator;

import java.util.TimerTask;

import waitingLine.WaitingLineEnum;

public class CountWaitTime extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		WaitingLines waitingLines = new WaitingLines();
		WaitingLineEnum requestLine = WaitingLineEnum.ORDERREQUESTLINE;
		for(int count = 0; count < waitingLines.getOrderRequestLine().getListSize(); count++) {
			int waitTime = waitingLines.getWaitTime(requestLine, count);
			waitTime++;
			waitingLines.setWaitTime(requestLine, count, waitTime);
		}
		WaitingLineEnum paymentLine = WaitingLineEnum.PAYMENTWAITINGLINE;
		int size = waitingLines.getPaymentWaitingLine().getListSize();
		for(int count = 0; count < size; count++) {
			int waitTime = waitingLines.getWaitTime(paymentLine, count);
			waitTime++;
			waitingLines.setWaitTime(paymentLine, count, waitTime);
		}
		for(int count = 0; count < waitingLines.getCustomerWaitingLine().getListSize(); count++) {
			new RestaurantTask().customerWaitTime(count);
		}
	}
}
