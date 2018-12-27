package waitingLine;

import java.util.*;

import restaurantSimulator.Clerk;

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
	public boolean addLine(Clerk index) {
		// TODO Auto-generated method stub
		return super.addLine(index);
	}

	public boolean removeLine(Clerk index) {
		return super.removeLine(index, index.getClerkWaitTime());
	}

	@Override
	public synchronized Clerk pop() {
		// TODO Auto-generated method stub
		this.getCountList().add(this.getWaitList().get(0).getClerkWaitTime());
		return super.pop();
	}
	
}
