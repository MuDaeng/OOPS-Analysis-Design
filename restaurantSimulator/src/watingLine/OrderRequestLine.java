package watingLine;

import java.util.*;

import restaurantSimulator.Customer;

public class OrderRequestLine extends WaitingLine<Customer>{
	
	private OrderRequestLine() {
		super(new ArrayList<Customer>());
	}
	
	private static class Singleton {
		private static OrderRequestLine instance = new OrderRequestLine();
	}
	
	public OrderRequestLine getInstance() {
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
