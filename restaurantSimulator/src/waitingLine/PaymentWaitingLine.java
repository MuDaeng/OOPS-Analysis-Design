package waitingLine;

import java.util.*;

import restaurantSimulator.Table;

public class PaymentWaitingLine extends WaitingLine<Table> {

	private PaymentWaitingLine () {
		super(new ArrayList<Table>());
	}
	private static class Singleton{
		private static PaymentWaitingLine instance = new PaymentWaitingLine();
	}
	public static PaymentWaitingLine getInstance() {
		return Singleton.instance;
	}
	@Override
	public boolean addLine(Table index) {
		// TODO Auto-generated method stub
		return super.addLine(index);
	}
	public boolean removeLine(Table index) {
		return super.removeLine(index, index.getCustomer().getPayWaitTime());
	}
	@Override
	public synchronized Table pop() {
		// TODO Auto-generated method stub
		this.getCountList().add(this.getWaitList().get(0).getCustomer().getPayWaitTime());
		return super.pop();
	}
}
