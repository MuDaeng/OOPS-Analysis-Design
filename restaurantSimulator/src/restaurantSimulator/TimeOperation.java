package restaurantSimulator;

import java.util.*;
import java.sql.SQLException;

import waitingLine.*;

public class TimeOperation {

	private ResultDTO resultDTO;
	private WaitingLine waitingLine;

	private TimeOperation() {
		resultDTO = new ResultDTO();
	}
	
	//Design pattern of Singleton
	private static class Singleton{
		private static TimeOperation instance = new TimeOperation();
	}
	public static TimeOperation getInstance() {
		return Singleton.instance;
	}
	private int calculateAvg(List<Integer> countList) {
		int countNum = countList.size();
		int value = 0;
		if(countNum == 0) {
			return 0;
		}else {
			Iterator<Integer> iterator = countList.iterator();
			while(iterator.hasNext()) value += iterator.next();
			return ( value / countNum );
		}
	}
	private int calculateMax(List<Integer> countList) {
		if(countList.size() == 0) {
			return 0;
		}else {
			countList.sort(null);
			return countList.get(countList.size()-1);	
		}
	}
	
	public void inputOptionToResultDTO(int compressionDegree, int clerkNumber) {
		resultDTO.setCompressionDegree(compressionDegree);
		resultDTO.setClerkNumber(clerkNumber);
	}
	
	public void inputResultToResultDTO() {
		waitingLine = CustomerWaitingLine.getInstance();
		resultDTO.setCustomerNumber(getCountList().size());
		resultDTO.setCusAvgWaitingTime(calculateAvg(getCountList()));
		resultDTO.setCusMaxWaitingTime(calculateMax(getCountList()));
		
//		waitingLine = ClerkWaitingLine.getInstance();
//		resultDTO.setClerkAvgWaitingTime(calculateAvg(getCountList()));
//		resultDTO.setClerkMaxWaitingTime(calculateMax(getCountList()));
		
		waitingLine = PaymentWaitingLine.getInstance();
		resultDTO.setPayAvgWaitingTime(calculateAvg(getCountList()));
		resultDTO.setPayMaxWaitingTime(calculateMax(getCountList()));

		waitingLine = OrderRequestLine.getInstance();
		resultDTO.setReqAvgWaitingTime(calculateAvg(getCountList()));
		resultDTO.setReqMaxWaitingTime(calculateMax(getCountList()));
	}
	public ResultDTO getResultDTO() {
		return this.resultDTO;
	}
	
	@SuppressWarnings("unchecked")
	private List<Integer> getCountList() {
		return waitingLine.getCountList();
	}
}
