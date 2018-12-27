package restaurantSimulator;

public class Clerk {
	private int clerkNum;
	private int ability;
	private int experienced;
	private int clerkWaitTime;
	private ClerkState clerkState;
	
	public Clerk(int ability, int experienced,int clerkNum) {
		this.ability = ability;
		this.experienced = experienced;
		this.clerkNum = clerkNum;
		this.clerkWaitTime = 0;
		this.clerkState = ClerkState.notWorking;
	}
	public int getClerkNum() {
		return clerkNum;
	}

	public void setClerkNum(int clerkNum) {
		this.clerkNum = clerkNum;
	}
	public int getAbility() {
		return this.ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	public int getExperienced() {
		return this.experienced;
	}
	public void setExperienced(int experienced) {
		this.experienced = experienced;
	}
	public int getClerkWaitTime() {
		return this.clerkWaitTime;
	}
	public void setClerkWaitTime(int clerkWaitTime) {
		this.clerkWaitTime = clerkWaitTime;
	}
	public ClerkState getClerkState() {
		return clerkState;
	}
	public void setClerkState(ClerkState clerkState) {
		this.clerkState = clerkState;
	}
	//직원이 일을 처리할 때 3초가 걸리고 능력이 좋을 수록 더 빨라짐
	public Clerk handleTask() {
		if(this.clerkState != ClerkState.notWorking) {	
			try {
				long takeWorkTime = 3000;
				synchronized(Progress.getInstance().getClerk(clerkNum)) {
					Progress.getInstance().getClerk(clerkNum).wait((takeWorkTime/(ability+experienced)));	
				}
			}catch(InterruptedException ie) {}
		}		
		return this;
	}	
}
