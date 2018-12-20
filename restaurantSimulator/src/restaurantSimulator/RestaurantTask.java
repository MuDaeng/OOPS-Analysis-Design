package restaurantSimulator;

import java.util.*;
import waitingLine.*;

public class RestaurantTask {
	private Progress progress;
	private ClerkWaitingLine clerkWaitingLine;
	private CustomerWaitingLine customerWaitingLine;
	private OrderRequestLine orderRequestLine;
	private PaymentWaitingLine paymentWaitingLine;
	
	public RestaurantTask() {
		progress = Progress.getInstance();
		clerkWaitingLine = ClerkWaitingLine.getInstance();
		customerWaitingLine = CustomerWaitingLine.getInstance();
		orderRequestLine = OrderRequestLine.getInstance();
		paymentWaitingLine = PaymentWaitingLine.getInstance();
	}
	
	public void requestOrder() {
		int first = 0;
		if(clerkWaitingLine.getWaitList().size() != 0) {
			Clerk clerk = clerkWaitingLine.getWaitList().remove(first);
			Table table = orderRequestLine.getWaitList().remove(first);
			clerk.setWorking(true);
			//작업
			progress.getTable(table.getTableNum()).getTableStatus().setReqWaitTime(0);
			clerk.setWorking(false);
			clerkWaitingLine.getWaitList().add(clerk);
		}else {
			for(int count = 0; count < clerkWaitingLine.getWaitList().size(); count++) {
				int waitTime = orderRequestLine.getWaitList().get(count).getReqWaitTime();
				orderRequestLine.getWaitList().get(count).setReqWaitTime(waitTime+1);
			}
		}
	}
	public void customerCreate() {
		Customer customer = new Customer(0,0);
		customerWaitingLine.addLine(customer);
	}
	public void customerwaittime(int waitcustomer) {
		int customerwait;
		Customer customer = customerWaitingLine.getWaitList().get(waitcustomer);
		customerwait=customer.getCusWaitTime();
		customerwait++;
		customer.setCusWaitTime(customerwait);
	}
		   
	public void paymentLine(Table table) {
		Customer customer = table.getCustomer();
		paymentWaitingLine.addLine(customer);
	}
	public void paymentwaittime(int waitcustomer) {
		int paywait;
		Customer customer = paymentWaitingLine.getWaitList().get(waitcustomer);
		paywait=customer.getPayWaitTime();
		paywait++;
		customer.setPayWaitTime(paywait);
	}
}
