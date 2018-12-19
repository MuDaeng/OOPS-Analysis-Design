package restaurantSimulator;

import java.util.*;

public class ClerkWaitingLine extends WaitingLine<Clerk> {

	private ClerkWaitingLine() {
		super(new ArrayList<Clerk>());
	}
	
	private static class Singleton{
		private static ClerkWaitingLine instance = new ClerkWaitingLine();
	}
	
	public static ClerkWaitingLine getInstance() {
		return Singleton.instance;
	}
	
	@Override
	protected boolean addLine(Clerk obj) {
		// TODO Auto-generated method stub
		return this.getWaitList().add(obj);
	}

	@Override
	protected boolean removeLine(Clerk obj) {
		// TODO Auto-generated method stub
		return this.getWaitList().remove(obj);
	}


}
