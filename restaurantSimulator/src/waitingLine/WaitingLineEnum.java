package waitingLine;

public enum WaitingLineEnum {
	CLERKWAITINGLINE, CUSTOMERWAITINGLINE, ORDERREQUESTLINE, PAYMENTWAITINGLINE;
	

	public int getWaitTime() {
		int first = 0;
		switch(this) {
		case CLERKWAITINGLINE :
			return ClerkWaitingLine.getInstance().getWaitList().get(first).getClerkWaitTime();
		case CUSTOMERWAITINGLINE :
			return CustomerWaitingLine.getInstance().getWaitList().get(first).getCusWaitTime();
		case ORDERREQUESTLINE :
			return OrderRequestLine.getInstance().getWaitList().get(first).getReqWaitTime();
		case PAYMENTWAITINGLINE :
			return PaymentWaitingLine.getInstance().getWaitList().get(first).getCustomer().getPayWaitTime();
		default :
			return 0;
		}
	}
	public void setWaitTime(int index, int waitTime) {
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
