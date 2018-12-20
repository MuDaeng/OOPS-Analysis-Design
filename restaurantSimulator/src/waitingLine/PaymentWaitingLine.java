package waitingLine;

import java.util.*;

import restaurantSimulator.Customer;
import restaurantSimulator.Payment;

public class PaymentWaitingLine extends WaitingLine<Customer> {
	private Payment payment;
	
	private PaymentWaitingLine () {
		super(new ArrayList<Customer>());
		this.payment = new Payment();
	}
	private static class Singleton{
		private static PaymentWaitingLine instance = new PaymentWaitingLine();
	}
	public static PaymentWaitingLine getInstance() {
		return Singleton.instance;
	}
	@Override
	public boolean addLine(Customer index) {
		// TODO Auto-generated method stub
		return super.addLine(index);
	}
	public boolean removeLine(Customer index) {
		return super.removeLine(index, index.getPayWaitTime());
	}
	public Payment getPayment() {
		return payment;
	}
}
