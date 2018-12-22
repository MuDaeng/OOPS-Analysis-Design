package restaurantSimulator;

import java.util.*;
import waitingLine.*;

public class RestaurantTask {
	private Progress progress;
	private WaitingLines waitingLines;
	
	public RestaurantTask() {
		progress = Progress.getInstance();
		waitingLines = new WaitingLines();
	}
	
	public void requestOrder() {
		Clerk clerk = waitingLines.getClerkWaitingLine().pop();
		Table table = waitingLines.getOrderRequestLine().pop();
		clerk.setWorking(true);
		progress.getTable(table.getTableNum()).getTableStatus().setReqWaitTime(0);
		clerk.setWorking(false);
		waitingLines.getClerkWaitingLine().addLine(clerk);	
	}
	public synchronized void countReqWaitTime() {
		WaitingLineEnum requestLine = WaitingLineEnum.ORDERREQUESTLINE;
		for(int count = 0; count < waitingLines.getClerkWaitingLine().getListSize(); count++) {
			int waitTime = waitingLines.getWaitTime(requestLine);
			waitTime++;
			waitingLines.setWaitTime(requestLine, count, waitTime);
		}
	}
	public void customerCreate() {
		Customer customer = new Customer(0,0);
		waitingLines.getCustomerWaitingLine().addLine(customer);
	}
	public void customerwaittime(int waitcustomer) {
		int customerwait;
		Customer customer = waitingLines.getCustomerWaitingLine().get(waitcustomer);
		customerwait=customer.getCusWaitTime();
		customerwait++;
		customer.setCusWaitTime(customerwait);
	}
		   
	public void paymentLine(Table table) {
		Customer customer = table.getCustomer();
		waitingLines.getPaymentWaitingLine().addLine(customer);
	}
	public void paymentwaittime(int waitcustomer) {
		int paywait;
		Customer customer = waitingLines.getCustomerWaitingLine().get(waitcustomer);
		paywait=customer.getPayWaitTime();
		paywait++;
		customer.setPayWaitTime(paywait);
	}
}
