package restaurantSimulator;

import watingLine.*;
import java.util.*;

public class RestaurantTask {
	private ClerkWaitingLine clerkWaitingLine;
	private CustomerWaitingLine customerWaitingLine;
	private OrderRequestLine orderRequestLine;
	private PaymentWaitingLine paymentWaitingLine;
	
	public RestaurantTask() {
		this.clerkWaitingLine = ClerkWaitingLine.getInstance();
		this.customerWaitingLine = CustomerWaitingLine.getInstance();
		this.orderRequestLine = OrderRequestLine.getInstance();
		this.paymentWaitingLine = PaymentWaitingLine.getInstance();
	}
	
	public void requestOrder() {
		
		while(true) {
			if(clerkWaitingLine.getWaitList().size() != 0) {
				Clerk clerk = clerkWaitingLine.getWaitList().remove(0);
				Table table = orderRequestLine.getWaitList().remove(0);
				clerk.setWorking(true);
				//작업
				table.setReqWaitTime(0);
				clerkWaitingLine.getWaitList().add(clerk);
			}else {
				
			}
		}
	}
}
