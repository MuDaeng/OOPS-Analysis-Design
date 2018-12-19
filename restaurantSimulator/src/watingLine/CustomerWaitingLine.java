package watingLine;

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

	@Override
	public boolean removeLine(Customer index) {
		// TODO Auto-generated method stub
		return super.removeLine(index);
	}
}
