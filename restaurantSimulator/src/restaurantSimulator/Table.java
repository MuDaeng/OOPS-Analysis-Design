package restaurantSimulator;

public class Table {
	private int tableNum;
	private int reqWaitingTime;
	private TableState tableState;
	private Customer customer;
	
	public Table(int tableNum) {
		this.tableNum = tableNum;
		this.tableState = TableState.isEmpty;
	}
	
	public int getTableNum() {
		return this.tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public int getReqWaitingTime() {
		return this.reqWaitingTime;
	}
	public void setReqWaitingTime(int reqWaitingTime) {
		this.reqWaitingTime = reqWaitingTime;
	}
	public TableState getTableState() {
		return this.tableState;
	}
	public void setTableState(TableState tableState) {
		this.tableState = tableState;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
