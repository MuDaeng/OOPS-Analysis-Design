package watingLine;

import java.util.*;

import restaurantSimulator.*;

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
	protected abstract void setResultMax();
	protected abstract void setResultAvg();
	protected int getMax() {
		return timeOperation.calculateMax(countList);
	}
	protected int getAvg() {
		return timeOperation.calculateAvg(countList);
	}
	
	protected boolean addLine(E index) {
		return waitList.add(index);
	}
	
	protected boolean removeLine(E index) {
		return waitList.remove(index);
	}
	protected ResultDTO inputValue(ResultDTOValuesName name) {
		ResultDTO tmp = new ResultDTO();
		switch(name) {
		case 
		}
		return null;
	}
}
