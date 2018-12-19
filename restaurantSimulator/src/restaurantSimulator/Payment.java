package restaurantSimulator;

public class Payment {
	private int customerNumber;
	private TimeOperation timeOperation;
	
	public synchronized TableThread changeTableStatus(TableThread table,ClerkThread clerk) {
		//고치자
		table.occupyCustomer(null);
		return table;
	}

	public int getCustomerNumber() {
		return this.customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public TimeOperation getTimeOperation() {
		return this.timeOperation;
	}

}
