package restaurantSimulator;

import java.util.*;

public class TimeOperation {
	private DatabaseAccess dba;
	private ResultDTO resultDTO;
	private List reqWaitList;
	private List payWaitList;

	private TimeOperation() {
		dba = DatabaseAccess.getInstance();
		//고치자
	}
	
	private static class Singleton{
		private static TimeOperation instance = new TimeOperation();
	}
	
	public static TimeOperation getInstance() {
		return Singleton.instance;
	}
	
	public int calculateAvg(List waitList) {
		//고치자
		return 0;
	}
	public int calculateMax(List waitList) {
		//고치자
		return 0;
	}
	
	public void setResultDTO(ResultDTO resultDTO) {
		this.resultDTO = resultDTO;
	}
	public boolean inputResult() {
		//고치자
		return false;
	}
	
	public List getReqWaitList() {
		return this.reqWaitList;
	}

	public void setReqWaitList(List reqWaitList) {
		this.reqWaitList = reqWaitList;
	}

	public List getPayWaitList() {
		return this.payWaitList;
	}

	public void setPayWaitList(List payWaitList) {
		this.payWaitList = payWaitList;
	}
}
