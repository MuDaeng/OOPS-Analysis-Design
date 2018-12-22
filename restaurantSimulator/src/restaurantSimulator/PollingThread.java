package restaurantSimulator;

public class PollingThread implements Runnable {
	private Thread requestThread;
	private WaitingLines waitingLines;

	public PollingThread() {
		requestThread = new Thread(new RequestThread());
		waitingLines = new WaitingLines();
	}
	
	public void run() {
		while(true) {
			if(waitingLines.getClerkWaitingLine().getListSize() > 0) requestThread.start();
		}
	}
}
