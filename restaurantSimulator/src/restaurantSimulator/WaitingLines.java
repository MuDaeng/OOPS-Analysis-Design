package restaurantSimulator;

import waitingLine.*;

public class WaitingLines {
	private ClerkWaitingLine clerkWaitingLine;
	private CustomerWaitingLine customerWaitingLine;
	private OrderRequestLine orderRequestLine;
	private PaymentWaitingLine paymentWaitingLine;
	
	public WaitingLines() {
		clerkWaitingLine = ClerkWaitingLine.getInstance();
		customerWaitingLine = CustomerWaitingLine.getInstance();
		orderRequestLine = OrderRequestLine.getInstance();
		paymentWaitingLine = PaymentWaitingLine.getInstance();
	}

	public ClerkWaitingLine getClerkWaitingLine() {
		return clerkWaitingLine;
	}

	public CustomerWaitingLine getCustomerWaitingLine() {
		return customerWaitingLine;
	}

	public OrderRequestLine getOrderRequestLine() {
		return orderRequestLine;
	}

	public PaymentWaitingLine getPaymentWaitingLine() {
		return paymentWaitingLine;
	}
	public int getWaitTime(WaitingLineEnum enumValue, int count) {
		return enumValue.getWaitTime(count);
	}
	public synchronized void setWaitTime(WaitingLineEnum enumValue, int index, int count) {
		enumValue.setWaitTime(index, count);
	}
}
