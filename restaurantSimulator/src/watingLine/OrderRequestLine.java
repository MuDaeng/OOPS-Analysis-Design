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
	
	public static OrderRequestLine getInstance() {
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
		super.setResultAvg( value -> {this.getTimeOperation().getResultDTO().setReqAvgWaitingTime(value);});
	}

	@Override
	public void setResultMax() {
		// TODO Auto-generated method stub
		super.setResultMax( value -> {this.getTimeOperation().getResultDTO().setReqMaxWaitingTime(value);});
	}
}
