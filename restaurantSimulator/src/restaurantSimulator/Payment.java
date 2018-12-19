package restaurantSimulator;

public class Payment {
	private int customerNumber;
	private TimeOperation timeOperation;
	
	public TableThread changeTableStatus(TableThread table,ClerkThread clerk) {
		//고치자
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
