package restaurantSimulator;

import java.util.*;

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
	protected boolean addLine(Customer obj) {
		// TODO Auto-generated method stub
		return this.getWaitList().add(obj);
	}

	@Override
	protected boolean removeLine(Customer obj) {
		// TODO Auto-generated method stub
		return this.getWaitList().remove(obj);
	}
	
	
}
