package restaurantSimulator;

public class ResultDTO {
	private int compressionDegree,
				customerNumber,
				clerkNumber,
				cusMaxWaitingTime,
				cusAvgWaitingTime,
				clerkMaxWaitingTime,
				clerkAvgWaitingTime,
				payMaxWaitingTime,
				payAvgWaitingTime,
				reqMaxWaitingTime,
				reqAvgWaitingTime;

	public int getCompressionDegree() {
		return this.compressionDegree;
	}

	public void setCompressionDegree(int compressionDegree) {
		this.compressionDegree = compressionDegree;
	}

	public int getCustomerNumber() {
		return this.customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getClerkNumber() {
		return this.clerkNumber;
	}

	public void setClerkNumber(int clerkNumber) {
		this.clerkNumber = clerkNumber;
	}

	public int getCusMaxWaitingTime() {
		return this.cusMaxWaitingTime;
	}

	public void setCusMaxWaitingTime(int cusMaxWaitingTime) {
		this.cusMaxWaitingTime = cusMaxWaitingTime;
	}

	public int getCusAvgWaitingTime() {
		return this.cusAvgWaitingTime;
	}

	public void setCusAvgWaitingTime(int cusAvgWaitingTime) {
		this.cusAvgWaitingTime = cusAvgWaitingTime;
	}

	public int getClerkMaxWaitingTime() {
		return this.clerkMaxWaitingTime;
	}

	public void setClerkMaxWaitingTime(int clerkMaxWaitingTime) {
		this.clerkMaxWaitingTime = clerkMaxWaitingTime;
	}

	public int getClerkAvgWaitingTime() {
		return this.clerkAvgWaitingTime;
	}

	public void setClerkAvgWaitingTime(int clerkAvgWaitingTime) {
		this.clerkAvgWaitingTime = clerkAvgWaitingTime;
	}

	public int getPayMaxWaitingTime() {
		return this.payMaxWaitingTime;
	}

	public void setPayMaxWaitingTime(int payMaxWaitingTime) {
		this.payMaxWaitingTime = payMaxWaitingTime;
	}

	public int getPayAvgWaitingTime() {
		return this.payAvgWaitingTime;
	}

	public void setPayAvgWaitingTime(int payAvgWaitingTime) {
		this.payAvgWaitingTime = payAvgWaitingTime;
	}

	public int getReqMaxWaitingTime() {
		return this.reqMaxWaitingTime;
	}

	public void setReqMaxWaitingTime(int reqMaxWaitingTime) {
		this.reqMaxWaitingTime = reqMaxWaitingTime;
	}

	public int getReqAvgWaitingTime() {
		return this.reqAvgWaitingTime;
	}

	public void setReqAvgWaitingTime(int reqAvgWaitingTime) {
		this.reqAvgWaitingTime = reqAvgWaitingTime;
	}
	
	
}
