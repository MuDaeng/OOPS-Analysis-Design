package watingLine;

import java.util.*;

import restaurantSimulator.TimeOperation;

public abstract class WaitingLine<E> {
	private List<E> waitList;
	private TimeOperation timeOperation;

	public WaitingLine(List<E> waitList) {
		this.waitList = waitList;
	}
	
	public List<E> getWaitList() {
		return this.waitList;
	}
	
	public TimeOperation getTimeOperation() {
		return this.timeOperation;
	}

	protected boolean addLine(E index) {
		return waitList.add(index);
	}
	
	protected boolean removeLine(E index) {
		return waitList.remove(index);
	}
}
