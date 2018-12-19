package restaurantSimulator;

import java.util.*;
import java.sql.SQLException;

public class TimeOperation {
	private DatabaseAccess dba;
	private ResultDTO resultDTO;
	private List reqWaitList;
	private List payWaitList;
	private String SQLTable;

	private TimeOperation() {
		dba = DatabaseAccess.getInstance();
		reqWaitList = new ArrayList();
		payWaitList = new ArrayList();
		SQLTable = "result";
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

	public boolean inputResult() {
		List<Integer> values = new ArrayList<Integer>();
		//고치자
		String sqlQuery = "insert into " + SQLTable + " values(?,?,?,?,?,?,?,?,?,?,?)";
		values.add(resultDTO.getCompressionDegree());
		values.add(resultDTO.getCustomerNumber());
		values.add(resultDTO.getClerkNumber());
		values.add(resultDTO.getCusMaxWaitingTime());
		values.add(resultDTO.getCusAvgWaitingTime());
		values.add(resultDTO.getClerkMaxWaitingTime());
		values.add(resultDTO.getClerkAvgWaitingTime());
		values.add(resultDTO.getPayMaxWaitingTime());
		values.add(resultDTO.getPayAvgWaitingTime());
		values.add(resultDTO.getReqMaxWaitingTime());
		values.add(resultDTO.getReqAvgWaitingTime());
		try {
			if(dba.setData(sqlQuery, values)) {
				dba.commit();
				return true;
			}
		}catch(SQLException SQLe){
			dba.rollback();
			return false;
		}
		return false;
	}
	
	public void setResultDTO(ResultDTO resultDTO) {
		this.resultDTO = resultDTO;
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
