package restaurantSimulator;

public class Clerk {
	private int ability;
	private int experienced;
	private int clerkWaitTime;
	private boolean isWorking;
	
	public Clerk(int ability, int experienced) {
		this.ability = ability;
		this.experienced = experienced;
		this.clerkWaitTime = 0;
		this.isWorking = false;
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
	public boolean isWorking() {
		return this.isWorking;
	}
	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	
	
}
