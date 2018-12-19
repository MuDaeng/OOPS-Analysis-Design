package watingLine;

import java.util.*;

import restaurantSimulator.*;

public abstract class WaitingLine<E> implements SetResult {
	private List<E> waitList;
	private TimeOperation timeOperation;
	private List<Integer> countList;
	
	public WaitingLine(List<E> waitList) {
		this.waitList = waitList;
	}
	public void setCountList(List<Integer> countList) {
		this.countList = countList;
	}
	protected void setResultMax(InputResultValue setCalculateResult) {
		setCalculateResult.setResult(this.getMax());
	}
	protected void setResultAvg(InputResultValue setCalculateResult) {
		setCalculateResult.setResult(this.getAvg());
	}
	protected boolean addLine(E index) {
		return waitList.add(index);
	}
	protected boolean removeLine(E index) {
		return waitList.remove(index);
	}
	private int getMax() {
		return timeOperation.calculateMax(countList);
	}
	private int getAvg() {
		return timeOperation.calculateAvg(countList);
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
}
