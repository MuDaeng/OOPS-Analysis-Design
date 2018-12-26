package restaurantSimulator;

import waitingLine.ClerkWaitingLine;

public class ClerkThread implements Runnable {
	private Clerk clerkStatus;
	
	public ClerkThread(int ability, int experienced) {
	   this.clerkStatus = new Clerk(ability,experienced);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//고치자
		int waittime = 0;
		//12-24 9시
		ClerkWaitingLine.getInstance().addLine(clerkStatus);
		while(true) {
			
			if(this.clerkStatus.isWorking()==true) {
				System.out.println("직원이 일을 하고 있는중");
				waittime=0;
			}	
			else {
				System.out.println("직원이 할일이 없습니다.");
				waittime++;       
			}
			try {
				clerkStatus.setClerkWaitTime(waittime);
				Thread.sleep(1000);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	public Clerk handleTask() {
		//고치자
		if(this.clerkStatus.isWorking()) {	
			try {
				long takeWorkTime = 3000;
				Thread.sleep(takeWorkTime/(clerkStatus.getAbility()+clerkStatus.getExperienced()));			
			}catch(InterruptedException ie) {}
		}		
		return this.clerkStatus;
	}	
	public Clerk getClerkStatus() {
		return this.clerkStatus;
	}
}