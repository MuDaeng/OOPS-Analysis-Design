package restaurantSimulator;

import java.util.*;
import waitingLine.*;

public class Progress {
	private TableThread[] tables;
	private ClerkThread[] clerks;
	private ClerkWaitingLine clerkWaitingLine;
	private CustomerWaitingLine customerWaitingLine;
	private OrderRequestLine orderRequestLine;
	private PaymentWaitingLine paymentWaitingLine;
	private Thread pollingThread;
	private List<Thread> tableList;
	private List<Thread> clerkList;
	
	private static class Singleton {
		private static Progress instance = new Progress();
	}
	
	private Progress() {
		clerkWaitingLine = ClerkWaitingLine.getInstance();
		customerWaitingLine = CustomerWaitingLine.getInstance();
		orderRequestLine = OrderRequestLine.getInstance();
		paymentWaitingLine = PaymentWaitingLine.getInstance();
		pollingThread = new Thread(new PollingThread());
	}
	public static Progress getInstance() {
		return Singleton.instance;
	}
	public void init() {
		tableList = new ArrayList<Thread>();
		clerkList = new ArrayList<Thread>();
		List tmp = new ArrayList();
		for(int count = 0; count < Option.tableNumber; count++) {
			tmp.add(new TableThread(count + 1));
		}
		tables = new TableThread[tmp.size()];
		tables = (TableThread[]) tmp.toArray(tables);
		tmp.clear();
		for(int count = 0; count < Option.clerkNumber; count++) {
			ClerkThread index = new ClerkThread(1,1,count+1);
			tmp.add(index);
		}
		clerks = new ClerkThread[tmp.size()];
		clerks = (ClerkThread[]) tmp.toArray(clerks);
		int count = 0;
		while(count < tables.length) {
			Thread makeTable = new Thread(tables[count++]);
			makeTable.start();
			tableList.add(makeTable);
		}
		count = 0;
		while(count < clerks.length) {
			Thread makeClerk = new Thread(clerks[count++]);
			makeClerk.start();
			clerkList.add(makeClerk);
		}
	}
	
	public void progressStart() {
		pollingThread.start();
	}
	
	public ClerkThread[] getClerks() {
		return clerks;
	}
	public TableThread[] getTables() {
		return tables;
	}
	
	public void end() {
		pollingThread.interrupt();
		for(int count = 0; count < tableList.size(); count++) {
			tableList.get(count).interrupt();
		}
		for(int count = 0; count < clerkList.size(); count++) {
			clerkList.get(count).interrupt();
		}
	}
	public ClerkThread getClerk(int clerkNumber) {
		return clerks[clerkNumber-1];
	}
	public TableThread getTable(int tableNumber) {
		return tables[tableNumber-1];
	}
	
	public ClerkWaitingLine getClerkWaitingLine() {
		return clerkWaitingLine;
	}
	public CustomerWaitingLine getCustomerWaitingLine() {
		return customerWaitingLine;
	}
	public OrderRequestLine getOrderRequestLine() {
		return orderRequestLine;
	}
	public PaymentWaitingLine getPaymentWaitingLine() {
		return paymentWaitingLine;
	}	
}
