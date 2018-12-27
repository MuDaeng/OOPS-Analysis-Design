package restaurantSimulator;

public class TableThread implements Runnable {
	private Table tableStatus;
	public TableThread(int tableNum) {
		this.tableStatus = new Table(tableNum);
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);	
			}catch(InterruptedException ie) {
				break;
			}
		}
	}
	//if null is out customer,else sit down customer to table
	public void occupyCustomer(Customer customer) {
		this.tableStatus.setCustomer(customer);
		if(customer != null) tableStatus.setTableState(TableState.isOccupying);
		else tableStatus.setTableState(TableState.isCleanable);
	}
	public Table getTableStatus() {
		return this.tableStatus;
	}
}
