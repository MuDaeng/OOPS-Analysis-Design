package waitingLine;

import java.util.*;

import restaurantSimulator.Table;

public class OrderRequestLine extends WaitingLine<Table>{
	
	private OrderRequestLine() {
		super(new ArrayList<Table>());
	}
	
	private static class Singleton {
		private static OrderRequestLine instance = new OrderRequestLine();
	}
	
	public static OrderRequestLine getInstance() {
		return Singleton.instance;
	}
	@Override
	public boolean addLine(Table index) {
		// TODO Auto-generated method stub
		return super.addLine(index);
	}
	public boolean removeLine(Table index) {
		return super.removeLine(index, index.getReqWaitTime());
	}
}