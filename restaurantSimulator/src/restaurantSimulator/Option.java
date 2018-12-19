package restaurantSimulator;

public class Option {
	private int customerPressure;
	private int clerkNumber;
	private int tableNumber;
	
	public Option() {
		this(1,3,9);
	}
	public Option(int customerPressure,int clerkNumber,int tableNumber) {
		this.customerPressure = customerPressure;
		this.clerkNumber = clerkNumber;
		this.tableNumber = tableNumber;
	}
	public int getCustomerPressure() {
		return this.customerPressure;
	}
	public void setCustomerPressure(int customerPressure) {
		this.customerPressure = customerPressure;
	}
	public int getClerkNumber() {
		return this.clerkNumber;
	}
	public void setClerkNumber(int clerkNumber) {
		this.clerkNumber = clerkNumber;
	}
	public int getTableNumber() {
		return this.tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
}
