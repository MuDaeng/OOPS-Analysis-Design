package restaurantSimulator;

import waitingLine.ClerkWaitingLine;

public class ClerkThread implements Runnable {
	private Clerk clerkStatus;
	
	public ClerkThread(int ability, int experienced,int clerkNum) {
	   this.clerkStatus = new Clerk(ability,experienced, clerkNum);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//고치자
		int waittime = 0;
		//12-24 9시
		while(true) {
			
			if(clerkStatus.getClerkState() == ClerkState.notWorking) {
				waittime++;
			}	
			else {
				waittime=0;
			}
			try {
				clerkStatus.setClerkWaitTime(waittime);
				Thread.sleep(1000);
			}
			catch(InterruptedException ie){
				System.out.println(ie.getMessage());
				break;
			}
		}
	}
	public Clerk getClerkStatus() {
		return this.clerkStatus;
	}
}