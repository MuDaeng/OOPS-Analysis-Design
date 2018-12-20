package restaurantSimulator;

public class Payment {
	private TimeOperation timeOperation;
	
	public synchronized TableThread changeTableStatus(TableThread table,ClerkThread clerk) {
		//고치자
		table.occupyCustomer(null);
		return table;
	}

	public TimeOperation getTimeOperation() {
		return this.timeOperation;
	}

}
