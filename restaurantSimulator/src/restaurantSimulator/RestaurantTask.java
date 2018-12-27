package restaurantSimulator;

import java.util.*;
import waitingLine.*;

public class RestaurantTask {
	private Progress progress;
	private WaitingLines waitingLines;
	
	public RestaurantTask() {
		waitingLines = new WaitingLines();
		progress = Progress.getInstance();
	}
	public void customertotable(Table table) {
		Customer customer = waitingLines.getCustomerWaitingLine().pop();
		progress.getTable(table.getTableNum()).occupyCustomer(customer);
		addOrderLine(progress.getTable(table.getTableNum()).getTableStatus());
	}
	private void addOrderLine(Table table) {
		waitingLines.getOrderRequestLine().addLine(table);
	}
	public void addPayLine(Table table) {
		waitingLines.getPaymentWaitingLine().addLine(table);
	}
	public synchronized void resolveOrder() {
		Clerk clerk = waitingLines.getClerkWaitingLine().pop();
		Table table = waitingLines.getOrderRequestLine().pop();
		clerk.setClerkState(ClerkState.takeOrder);
		//작업
		clerk.handleTask();
		Progress.getInstance().getTable(table.getTableNum()).getTableStatus().setReqWaitTime(0);
		Progress.getInstance().getTable(table.getTableNum()).getTableStatus().setTableState(TableState.isCompleted);
		clerk.setClerkState(ClerkState.notWorking);
		waitingLines.getClerkWaitingLine().addLine(clerk);	
	}
	public synchronized void countReqWaitTime() {
		WaitingLineEnum requestLine = WaitingLineEnum.ORDERREQUESTLINE;
		for(int count = 0; count < waitingLines.getOrderRequestLine().getListSize(); count++) {
			int waitTime = waitingLines.getWaitTime(requestLine, count);
			waitTime++;
			waitingLines.setWaitTime(requestLine, count, waitTime);
		}
	}
	public synchronized void countPayWaitTime() {
		WaitingLineEnum paymentLine = WaitingLineEnum.PAYMENTWAITINGLINE;
		int size = waitingLines.getPaymentWaitingLine().getListSize();
		for(int count = 0; count < size; count++) {
			int waitTime = waitingLines.getWaitTime(paymentLine, count);
			waitTime++;
			waitingLines.setWaitTime(paymentLine, count, waitTime);
		}
	}
	public synchronized void payment() {
		Clerk clerk = waitingLines.getClerkWaitingLine().pop();
		try {
			Table table = waitingLines.getPaymentWaitingLine().pop();
			clerk.setClerkState(ClerkState.takePayment);;
			//작업
			clerk.handleTask();
			clerk.setClerkState(ClerkState.notWorking);
			Progress.getInstance().getTable(table.getTableNum()).occupyCustomer(null);
		}catch(NullPointerException ne) {
			new RuntimeException(ne);
			return;	
		}finally {
			waitingLines.getClerkWaitingLine().addLine(clerk);
		}
	}
	public synchronized void cleanTable(int tableNum)throws Exception{
		Clerk clerk = waitingLines.getClerkWaitingLine().pop();
		clerk.setClerkState(ClerkState.takeClearTable);
		//작업
		clerk.handleTask();
		progress.getTable(tableNum).getTableStatus().setTableState(TableState.isEmpty);
		clerk.setClerkState(ClerkState.notWorking);
		waitingLines.getClerkWaitingLine().addLine(clerk);
	}
	public void customerCreate() {
		Customer customer = new Customer(0,0);
		waitingLines.getCustomerWaitingLine().addLine(customer);
	}
	public void customerWaitTime(int waitcustomer) {
		int customerwait;
		Customer customer = waitingLines.getCustomerWaitingLine().get(waitcustomer);
		customerwait=customer.getCusWaitTime();
		customerwait++;
		customer.setCusWaitTime(customerwait);
	}
	public void addPaymentLine(Table table) {
		waitingLines.getPaymentWaitingLine().addLine(table);
	}
}
