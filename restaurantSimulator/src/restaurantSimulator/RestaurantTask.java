package restaurantSimulator;

import java.util.*;
import waitingLine.*;

public class RestaurantTask {
	private Progress progress;
	
	public RestaurantTask() {
		progress = Progress.getInstance();
	}
	
	public void requestOrder() {
			Clerk clerk = (Clerk) WaitingLineEnum.CLERKWAITINGLINE.pop();
			Table table = (Table) WaitingLineEnum.ORDERREQUESTLINE.pop();
			clerk.setWorking(true);
			//작업
			progress.getTable(table.getTableNum()).getTableStatus().setReqWaitTime(0);
			clerk.setWorking(false);
			WaitingLineEnum.CLERKWAITINGLINE.addLine(clerk);
	}
	public synchronized void countReqWaitTime() {
		for(int count = 0; count < WaitingLineEnum.CLERKWAITINGLINE.waitListSize(); count++) {
			int waitTime = WaitingLineEnum.ORDERREQUESTLINE.getWaitTime();
			WaitingLineEnum.ORDERREQUESTLINE.setWaitTime(waitTime+1);
		}
	}
	public void customerCreate() {
		Customer customer = new Customer(0,0);
		WaitingLineEnum.CUSTOMERWAITINGLINE.addLine(customer);
	}
	public void customerwaittime(int waitcustomer) {
		int customerwait;
		Customer customer = (Customer) WaitingLineEnum.CUSTOMERWAITINGLINE.get(waitcustomer);
		customerwait=customer.getCusWaitTime();
		customerwait++;
		customer.setCusWaitTime(customerwait);
	}
		   
	public void paymentLine(Table table) {
		Customer customer = table.getCustomer();
		WaitingLineEnum.PAYMENTWAITINGLINE.addLine(customer);
	}
	public void paymentwaittime(int waitcustomer) {
		int paywait;
		Customer customer = (Customer) WaitingLineEnum.CUSTOMERWAITINGLINE.get(waitcustomer);
		paywait=customer.getPayWaitTime();
		paywait++;
		customer.setPayWaitTime(paywait);
	}
}
