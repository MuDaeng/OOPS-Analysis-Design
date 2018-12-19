package restaurantSimulator;

import java.util.*;

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

	protected abstract boolean addLine(E obj);
	
	protected abstract boolean removeLine(E obj);
}
