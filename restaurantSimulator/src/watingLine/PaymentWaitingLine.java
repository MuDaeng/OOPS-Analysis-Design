package watingLine;

import restaurantSimulator.*;
import java.util.*;

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
	@Override
	public boolean removeLine(Customer index) {
		// TODO Auto-generated method stub
		this.getCountList().add(index.getPayWaitTime());
		return super.removeLine(index);
	}
	public Payment getPayment() {
		return payment;
	}
	
}
