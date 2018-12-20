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
	
	private static class Singleton {
		private static Progress instance = new Progress();
	}
	
	private Progress() {
		clerkWaitingLine = ClerkWaitingLine.getInstance();
		customerWaitingLine = CustomerWaitingLine.getInstance();
		orderRequestLine = OrderRequestLine.getInstance();
		paymentWaitingLine = PaymentWaitingLine.getInstance();
	}
	public static Progress getInstance() {
		return Singleton.instance;
	}
	public void init(Option option) {
		List tmp = new ArrayList();
		for(int count = 0; count < option.getTableNumber(); count++) {
			tmp.add(new TableThread(count + 1));
		}
		tables = (TableThread[]) tmp.toArray();
		tmp.clear();
		for(int count = 0; count < option.getClerkNumber(); count++) {
			tmp.add(new ClerkThread(1,1));
		}
		clerks = (ClerkThread[]) tmp.toArray();
		int count = 0;
		while(count < tables.length) {
			Thread makeTable = new Thread(tables[count++]);
			makeTable.start();
		}
		count = 0;
		while(count < clerks.length) {
			Thread makeClerk = new Thread(clerks[count++]);
			makeClerk.start();
		}
	}
	
	public ClerkThread[] getClerks() {
		return clerks;
	}
	public TableThread[] getTables() {
		return tables;
	}
	
	public ClerkThread getClerk(int clerkNumber) {
		return clerks[clerkNumber-1];
	}
	public TableThread getTable(int tableNumber) {
		return tables[tableNumber-1];
	}


	
}
