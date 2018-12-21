package waitingLine;

import java.util.*;

import restaurantSimulator.*;

public abstract class WaitingLine<E> {
	private List<E> waitList;
	private TimeOperation timeOperation;
	private List<Integer> countList;
	
	protected WaitingLine(List<E> waitList) {
		this.waitList = waitList;
		this.countList = new ArrayList<Integer>();
	}

	protected synchronized boolean addLine(E index) {
		return waitList.add(index);
	}
	protected synchronized boolean removeLine(E index,int waitTime) {
		countList.add(waitTime);
		return waitList.remove(index);
	}
	public List<E> getWaitList() {
		return this.waitList;
	}
	protected TimeOperation getTimeOperation() {
		return this.timeOperation;
	}
	public List<Integer> getCountList() {
		return countList;
	}

}
