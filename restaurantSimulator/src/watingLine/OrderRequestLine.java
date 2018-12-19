package watingLine;

import java.util.*;

import restaurantSimulator.Table;

public class OrderRequestLine extends WaitingLine<Table>{
	
	private OrderRequestLine() {
		super(new ArrayList<Table>());
	}
	
	private static class Singleton {
		private static OrderRequestLine instance = new OrderRequestLine();
	}
	
	public OrderRequestLine getInstance() {
		return Singleton.instance;
	}

	@Override
	public boolean addLine(Table index) {
		// TODO Auto-generated method stub
		return super.addLine(index);
	}

	@Override
	public boolean removeLine(Table index) {
		// TODO Auto-generated method stub
		this.getCountList().add(index.getReqWaitTime());
		return super.removeLine(index);
	}

	@Override
	public void setResultAvg() {
		// TODO Auto-generated method stub
		super.setResultAvg( a -> {this.getTimeOperation().getResultDTO().setReqAvgWaitingTime(a);});
	}

	@Override
	public void setResultMax() {
		// TODO Auto-generated method stub
		super.setResultMax( a -> {this.getTimeOperation().getResultDTO().setReqMaxWaitingTime(a);});
	}
}
