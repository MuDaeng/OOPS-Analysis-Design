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
			try {
				return PaymentWaitingLine.getInstance().getWaitList().get(indexNum).getCustomer().getPayWaitTime();
			}catch(NullPointerException ne) {
				new RuntimeException(ne);
				return 0;
			}
		default :
			return 0;
		}
	}
	public synchronized void setWaitTime(int index, int waitTime) {
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
			try {
				PaymentWaitingLine.getInstance().getWaitList().get(index).getCustomer().setPayWaitTime(waitTime);
				break;	
			}catch(NullPointerException ne){
				new RuntimeException(ne);
				break;
			}
		default :
			return;
		}
	}
}
