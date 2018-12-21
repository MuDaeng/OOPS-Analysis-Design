package waitingLine;

import java.util.*;
import restaurantSimulator.*;

public enum WaitingLineEnum {
	CLERKWAITINGLINE, CUSTOMERWAITINGLINE, ORDERREQUESTLINE, PAYMENTWAITINGLINE;
	
	public WaitingLine getWaitingLine() {
		switch(this) {
		case CLERKWAITINGLINE :
			return ClerkWaitingLine.getInstance();
		case CUSTOMERWAITINGLINE :
			return CustomerWaitingLine.getInstance();
		case ORDERREQUESTLINE :
			return OrderRequestLine.getInstance();
		case PAYMENTWAITINGLINE :
			return PaymentWaitingLine.getInstance();
		default :
			return null;
		}
	}
	public Object pop() {
		int first = 0;
		switch(this) {
		case CLERKWAITINGLINE :
			return ClerkWaitingLine.getInstance().getWaitList().remove(first);
		case CUSTOMERWAITINGLINE :
			return CustomerWaitingLine.getInstance().getWaitList().remove(first);
		case ORDERREQUESTLINE :
			return OrderRequestLine.getInstance().getWaitList().remove(first);
		case PAYMENTWAITINGLINE :
			return PaymentWaitingLine.getInstance().getWaitList().remove(first);
		default :
			return null;
		}
	}
	public Object get(int count) {
		switch(this) {
		case CLERKWAITINGLINE :
			return ClerkWaitingLine.getInstance().getWaitList().get(count);
		case CUSTOMERWAITINGLINE :
			return CustomerWaitingLine.getInstance().getWaitList().get(count);
		case ORDERREQUESTLINE :
			return OrderRequestLine.getInstance().getWaitList().get(count);
		case PAYMENTWAITINGLINE :
			return PaymentWaitingLine.getInstance().getWaitList().get(count);
		default :
			return null;
		}
	}
	public int waitListSize() {
		switch(this) {
		case CLERKWAITINGLINE :
			return ClerkWaitingLine.getInstance().getWaitList().size();
		case CUSTOMERWAITINGLINE :
			return CustomerWaitingLine.getInstance().getWaitList().size();
		case ORDERREQUESTLINE :
			return OrderRequestLine.getInstance().getWaitList().size();
		case PAYMENTWAITINGLINE :
			return PaymentWaitingLine.getInstance().getWaitList().size();
		default :
			return 0;
		}
	}
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
			return PaymentWaitingLine.getInstance().getWaitList().get(first).getPayWaitTime();
		default :
			return 0;
		}
	}
	public boolean addLine(Object obj) {
		switch(this) {
		case CLERKWAITINGLINE :
			Clerk clerk = (Clerk) obj;
			return ClerkWaitingLine.getInstance().addLine(clerk);
		case CUSTOMERWAITINGLINE :
			Customer customer = (Customer) obj;
			return CustomerWaitingLine.getInstance().addLine(customer);
		case ORDERREQUESTLINE :
			Table table = (Table) obj;
			return OrderRequestLine.getInstance().addLine(table);
		case PAYMENTWAITINGLINE :
			Customer payCus = (Customer) obj;
			return PaymentWaitingLine.getInstance().addLine(payCus);
		default :
			return false;
		}
	}
	public void setWaitTime(int count) {
		int first = 0;
		switch(this) {
		case CLERKWAITINGLINE :
			ClerkWaitingLine.getInstance().getWaitList().get(first).setClerkWaitTime(count);
			break;
		case CUSTOMERWAITINGLINE :
			CustomerWaitingLine.getInstance().getWaitList().get(first).setCusWaitTime(count);
			break;
		case ORDERREQUESTLINE :
			OrderRequestLine.getInstance().getWaitList().get(first).setReqWaitTime(count);
			break;
		case PAYMENTWAITINGLINE :
			PaymentWaitingLine.getInstance().getWaitList().get(first).setPayWaitTime(count);
			break;
		default :
			return;
		}
	}
}
