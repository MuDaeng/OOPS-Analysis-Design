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
	private Thread requestThread;
	private Thread paymentThread;
	private Thread cleanThread;
	private Thread cusCreateThread;
	private Thread addPayLineThread;
	private Timer countTimer;
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
		requestThread = new Thread(new RequestThread());
		paymentThread = new Thread(new PaymentThread());
		cleanThread = new Thread(new CleanThread());
		cusCreateThread = new Thread(() ->{
			while(true) {
				synchronized(this) {
					callCustomer();
					if(customerWaitingLine.getListSize() > 0) {
						if(clerkWaitingLine.getListSize()> 0) {
							for(int count = 0; count < tables.length; count++) {
								if(tables[count].getTableStatus().getTableState() == TableState.isEmpty) {
									cusToTable(count);
									break;	
								}else continue;
							}
						}
					}
				}	
				try {
					Thread.sleep(503);
				}catch(InterruptedException e){
					break;
				}
			}
		});
		addPayLineThread = new Thread(new ToPay());
		countTimer = new Timer();
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
			clerkWaitingLine.addLine(index.getClerkStatus());
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
		requestThread.setDaemon(true);
		paymentThread.setDaemon(true);
		cleanThread.setDaemon(true);
		cusCreateThread.setDaemon(true);
		addPayLineThread.setDaemon(true);
		requestThread.start();
		paymentThread.start();
		cleanThread.start();
		cusCreateThread.start();
		addPayLineThread.start();
		countTimer.schedule(new CountWaitTime(), 1000, 1000);
	}
	
	public ClerkThread[] getClerks() {
		return clerks;
	}
	public TableThread[] getTables() {
		return tables;
	}
	private void callCustomer() {
		RestaurantTask task = new RestaurantTask();
		int cusCreate = (int)(Math.random()*25+1);
		if(cusCreate<Option.customerPressure*5)
			task.customerCreate();
	}   
	//12-24 9시
	private void cusToTable(int i) {
		Table tmp = tables[i].getTableStatus();
		RestaurantTask task = new RestaurantTask();
		task.customertotable(tmp);
	}
	public void end() {
		requestThread.interrupt();
		paymentThread.interrupt();
		cleanThread.interrupt();
		cusCreateThread.interrupt();
		addPayLineThread.interrupt();
		for(int count = 0; count < tableList.size(); count++) {
			tableList.get(count).interrupt();
		}
		for(int count = 0; count < clerkList.size(); count++) {
			clerkList.get(count).interrupt();
		}
		countTimer.cancel();
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
	public List<Thread> getClerkList() {
		return clerkList;
	}
private class ToPay implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(504);	
			}catch(InterruptedException ie) {
				break;
			}
			if((int)Math.random()*5 < 4) {
				synchronized(this) {
					boolean flag = false;
					for(int count = 0; count < tables.length; count++) {
						if(tables[count].getTableStatus().getTableState() == TableState.isCompleted && tables[count].getTableStatus().getCustomer() != null) {
							if(paymentWaitingLine.getListSize() == 0) {
								new RestaurantTask().addPayLine(tables[count].getTableStatus());
								continue;
							}else {
								int size = paymentWaitingLine.getListSize();
								for(int indexNum = 0; indexNum < size; indexNum++) {
									if(tables[count].getTableStatus().getTableNum() == paymentWaitingLine.get(indexNum).getTableNum()) {
										flag = true;
										break;
									}
								}
								if(!(flag)) {
									new RestaurantTask().addPayLine(tables[count].getTableStatus());
									break;
								}else {
									continue;
								}	
							}
						}
					}	
				}
			}
		}
	}
}
}
