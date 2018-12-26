package waitingLine;

import java.util.*;

import restaurantSimulator.Customer;

public class CustomerWaitingLine extends WaitingLine<Customer>{
	
	private CustomerWaitingLine() {
		super(new ArrayList<Customer>());
	}
	
	private static class Singleton{
		private static final CustomerWaitingLine instance = new CustomerWaitingLine(); 
	}
	
	public static CustomerWaitingLine getInstance() {
		return Singleton.instance;
	}

	@Override
	public boolean addLine(Customer index) {
		// TODO Auto-generated method stub
		return super.addLine(index);
	}

	public boolean removeLine(Customer index) {
		return super.removeLine(index, index.getCusWaitTime());
	}

	@Override
	public synchronized Customer pop() {
		// TODO Auto-generated method stub
		this.getCountList().add(this.getWaitList().get(0).getCusWaitTime());
		return super.pop();
	}
	
}