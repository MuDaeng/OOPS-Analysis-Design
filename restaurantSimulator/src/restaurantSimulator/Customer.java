package restaurantSimulator;

public class Customer {
	private int cusWaitTime;
	private int payWaitTime;
	
	public Customer(int cusWaitTime, int payWaitTime) {
		this.cusWaitTime = cusWaitTime;
		this.payWaitTime = payWaitTime;
	}
	
	public int getCusWaitTime() {
		return this.cusWaitTime;
	}
	public void setCusWaitTime(int cusWaitTime) {
		this.cusWaitTime = cusWaitTime;
	}
	public int getPayWaitTime() {
		return this.payWaitTime;
	}
	public void setPayWaitTime(int payWaitTime) {
		this.payWaitTime = payWaitTime;
	}
	
	
}
