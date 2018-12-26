package restaurantSimulator;

public class PollingThread implements Runnable {
	private Thread requestThread;
	private Thread paymentThread;
	private WaitingLines waitingLines;

	public PollingThread() {
		requestThread = new Thread(new RequestThread());
		paymentThread = new Thread(new PaymentThread());
		waitingLines = new WaitingLines();
	}
	
	public void run() {
		while(true) {
			if(waitingLines.getClerkWaitingLine().getListSize() > 0) {
				requestThread.start();
				paymentThread.start();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				// TODO: handle exception
			}
		}
	}
}