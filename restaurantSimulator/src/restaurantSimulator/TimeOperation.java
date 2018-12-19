package restaurantSimulator;

import java.util.*;
import java.sql.SQLException;

public class TimeOperation {
	private DAO dao;
	private ResultDTO resultDTO;
	private String SQLTable;

	private TimeOperation() {
		dao = DAO.getInstance();
		resultDTO = new ResultDTO();
		SQLTable = "result";
	}
	
	private static class Singleton{
		private static TimeOperation instance = new TimeOperation();
	}
	public static TimeOperation getInstance() {
		return Singleton.instance;
	}
	public int calculateAvg(List<Integer> waitList) {
		//고치자
		int countNum = waitList.size();
		int value = 0;
		if(countNum == 0) {
			System.out.println("잘못됨");
			return 0;
		}else {
			Iterator<Integer> iterator = waitList.iterator();
			while(iterator.hasNext()) value += iterator.next();
			return ( value / countNum );
		}
	}
	public int calculateMax(List<Integer> waitList) {
		if(waitList.size() == 0) {
			return 0;
		}else {
			waitList.sort(null);
			return waitList.get(waitList.size()-1);	
		}
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
			if(dao.setData(sqlQuery, values)) {
				dao.commit();
				return true;
			}
		}catch(SQLException SQLe){
			dao.rollback();
			return false;
		}
		return false;
	}
	public List<Map<String,Object>> getResult(String SQLQuery){
		return dao.getData(SQLQuery);
	}
	public void setResultDTO(ResultDTO resultDTO) {
		this.resultDTO = resultDTO;
	}
	public ResultDTO getResultDTO() {
		return this.resultDTO;
	}
}
