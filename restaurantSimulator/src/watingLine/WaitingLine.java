package watingLine;

import java.util.*;

import restaurantSimulator.TimeOperation;

public abstract class WaitingLine<E> {
	private List<E> waitList;
	private TimeOperation timeOperation;
	private List<Integer> countList;
	
	public WaitingLine(List<E> waitList) {
		this.waitList = waitList;
	}
	
	public List<E> getWaitList() {
		return this.waitList;
	}
	
	public TimeOperation getTimeOperation() {
		return this.timeOperation;
	}

	public List<Integer> getCountList() {
		return countList;
	}

	public void setCountList(List<Integer> countList) {
		this.countList = countList;
	}

	protected boolean addLine(E index) {
		return waitList.add(index);
	}
	
	protected boolean removeLine(E index) {
		return waitList.remove(index);
	}
}
