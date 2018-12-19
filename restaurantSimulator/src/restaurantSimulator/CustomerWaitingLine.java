package restaurantSimulator;

import java.util.*;

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
	protected boolean addLine(Customer obj) {
		return this.getWaitList().add(obj);
	}

	@Override
	protected boolean removeLine(Customer obj) {
		// TODO Auto-generated method stub
		return this.getWaitList().remove(obj);
	}

	
}
