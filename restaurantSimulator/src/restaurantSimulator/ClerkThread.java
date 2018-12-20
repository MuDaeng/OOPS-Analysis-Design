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
		int waittime = 0;
		if (this.clerkStatus.isWorking()==true) {
            System.out.println("직원이 일을 하고 있는중");
            this.clerkStatus.setClerkWaitTime(waittime);
            waittime=0;
           }
         else {
              System.out.println("직원이 할일이 없습니다.");
                  waittime++;
                  this.clerkStatus.setClerkWaitTime(waittime);         
         }
	}

	public Clerk handleTask() {
		//고치자
		if(this.clerkStatus.isWorking()) {
			
		}
		return this.clerkStatus;
	}
	public Clerk getClerkStatus() {
		return this.clerkStatus;
	}
}