package restaurantSimulator;

import waitingLine.*;

public class PollingThread implements Runnable {
	private Thread requestThread;

	public PollingThread() {
		requestThread = new Thread(new RequestThread());
	}
	
	public void run() {
		while(true) {
			if(WaitingLineEnum.CLERKWAITINGLINE.waitListSize() > 0) requestThread.start();
		}
	}
}
