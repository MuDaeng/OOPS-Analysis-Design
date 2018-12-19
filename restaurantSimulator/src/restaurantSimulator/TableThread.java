package restaurantSimulator;

public class TableThread implements Runnable {
	private Table tableStatus;
	
	public TableThread(int tableNum) {
		this.tableStatus = new Table(tableNum);
	}
	
	public Table occupyCustomer(Customer customer) {
		this.tableStatus.setCustomer(customer);
		return this.tableStatus;
	}
	
	public Table getTableStatus() {
		return this.tableStatus;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//고치자
	}

}
