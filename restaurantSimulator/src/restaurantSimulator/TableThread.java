package restaurantSimulator;

import java.util.Timer;

public class TableThread implements Runnable {
	private Table tableStatus;
	private Timer task;
	public TableThread(int tableNum) {
		this.tableStatus = new Table(tableNum);
		this.task = new Timer();
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//고치자
		while(true) {
			if(tableStatus.getCustomer() != null && tableStatus.getReqWaitTime() == 0) {
				if((Math.random() * 2) < 1) {
					
				}
				//주문을 고르기
			}
		}
	}

	public Table occupyCustomer(Customer customer) {
		this.tableStatus.setCustomer(customer);
		if(customer != null) tableStatus.setTableState(TableState.isOccupying);
		else tableStatus.setTableState(TableState.isCleanable);
		return this.tableStatus;
	}
	public Table getTableStatus() {
		return this.tableStatus;
	}
}
