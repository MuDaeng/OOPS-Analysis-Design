package restaurantSimulator;

public class ClerkThread implements Runnable {
	private Clerk clerkStatus;
	
	public ClerkThread(int ability, int experienced) {
		this.clerkStatus = new Clerk(ability,experienced);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//고치자
	}

	public Clerk handleTask() {
		//고치자
		return this.clerkStatus;
	}
	public Clerk getClerkStatus() {
		return this.clerkStatus;
	}
	
}