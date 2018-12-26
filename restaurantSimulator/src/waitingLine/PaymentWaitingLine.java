package waitingLine;

import java.util.*;

import restaurantSimulator.Table;
import restaurantSimulator.Payment;

public class PaymentWaitingLine extends WaitingLine<Table> {
	private Payment payment;
	
	private PaymentWaitingLine () {
		super(new ArrayList<Table>());
		this.payment = new Payment();
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
	public Payment getPayment() {
		return payment;
	}
}
