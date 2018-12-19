package watingLine;

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

	@Override
	public boolean removeLine(Clerk index) {
		// TODO Auto-generated method stub
		this.getCountList().add(index.getClerkWaitTime());
		return super.removeLine(index);
	}
	@Override
	public void setResultMax() {
		// TODO Auto-generated method stub
		this.getTimeOperation().setResultDTO(resultDTO);
	}
}
