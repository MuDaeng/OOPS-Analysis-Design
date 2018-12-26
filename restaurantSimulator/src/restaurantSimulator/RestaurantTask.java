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
	public void addOrderLine(Table table) {
		Customer customer = waitingLines.getCustomerWaitingLine().pop();
		waitingLines.getOrderRequestLine().addLine(table);
	}
	public void resolveOrder() {
		Clerk clerk = waitingLines.getClerkWaitingLine().pop();
		Table table = waitingLines.getOrderRequestLine().pop();
		clerk.setWorking(true);
		//작업
		progress.getTable(table.getTableNum()).getTableStatus().setReqWaitTime(0);
		clerk.setWorking(false);
		waitingLines.getClerkWaitingLine().addLine(clerk);	
	}
	public synchronized void countReqWaitTime() {
		WaitingLineEnum requestLine = WaitingLineEnum.ORDERREQUESTLINE;
		for(int count = 0; count < waitingLines.getOrderRequestLine().getListSize(); count++) {
			int waitTime = waitingLines.getWaitTime(requestLine);
			waitTime++;
			waitingLines.setWaitTime(requestLine, count, waitTime);
		}
	}
	public synchronized void countPayWaitTime() {
		for(int count = 0; count < waitingLines.getPaymentWaitingLine().getListSize(); count++) {
			paymentwaittime(count);
		}
	}
	public void payment() {
		Clerk clerk = waitingLines.getClerkWaitingLine().pop();
		Table table = waitingLines.getPaymentWaitingLine().pop();
		clerk.setWorking(true);
		//작업
		clerk.setWorking(false);
		progress.getTable(table.getTableNum()).occupyCustomer(null);
		waitingLines.getClerkWaitingLine().addLine(clerk);
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
	public void addPaymentLine(Table table) {
		waitingLines.getPaymentWaitingLine().addLine(table);
	}
	private void paymentwaittime(int waitcustomer) {
		int paywait;
		Customer customer = waitingLines.getPaymentWaitingLine().get(waitcustomer).getCustomer();
		paywait=customer.getPayWaitTime();
		paywait++;
		customer.setPayWaitTime(paywait);
	}
}
