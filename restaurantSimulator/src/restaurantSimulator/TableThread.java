package restaurantSimulator;

import java.util.Timer;

public class TableThread implements Runnable {
	private Table tableStatus;
	public TableThread(int tableNum) {
		this.tableStatus = new Table(tableNum);
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//고치자
		while(true) {
			try {
				Thread.sleep(1000);	
			}catch(InterruptedException ie) {
				break;
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
