package waitingLine;

import restaurantSimulator.WaitingLines;

public enum WaitingLineEnum {
	CLERKWAITINGLINE, CUSTOMERWAITINGLINE, ORDERREQUESTLINE, PAYMENTWAITINGLINE;
	

	public int getWaitTime(int indexNum) {
		switch(this) {
		case CLERKWAITINGLINE :
			return ClerkWaitingLine.getInstance().getWaitList().get(indexNum).getClerkWaitTime();
		case CUSTOMERWAITINGLINE :
			return CustomerWaitingLine.getInstance().getWaitList().get(indexNum).getCusWaitTime();
		case ORDERREQUESTLINE :
			return OrderRequestLine.getInstance().getWaitList().get(indexNum).getReqWaitTime();
		case PAYMENTWAITINGLINE :
			return PaymentWaitingLine.getInstance().getWaitList().get(indexNum).getCustomer().getPayWaitTime();
		default :
			return 0;
		}
	}
	public synchronized void setWaitTime(int index, int waitTime) {
		WaitingLines wl = new WaitingLines();
		switch(this) {
		case CLERKWAITINGLINE :
			ClerkWaitingLine.getInstance().getWaitList().get(index).setClerkWaitTime(waitTime);
			break;
		case CUSTOMERWAITINGLINE :
			CustomerWaitingLine.getInstance().getWaitList().get(index).setCusWaitTime(waitTime);
			break;
		case ORDERREQUESTLINE :
			OrderRequestLine.getInstance().getWaitList().get(index).setReqWaitTime(waitTime);
			break;
		case PAYMENTWAITINGLINE :
			PaymentWaitingLine.getInstance().getWaitList().get(index).getCustomer().setPayWaitTime(waitTime);
			break;
		default :
			return;
		}
	}
}
