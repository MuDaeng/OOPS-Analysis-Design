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
	//0.1초마다 직원대기줄에서 직원이 놀고 있으면 직원에게 일을 시킴 우선순위는 위에서부터
	public void run() {
		while(true) {
			try {
				if(waitingLines.getClerkWaitingLine().getListSize() > 0) {
					requestThread.start();
					paymentThread.start();
				}
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				// TODO: handle exception
				end();
				break;
			}
		}
	}
	public void end() {
		requestThread.interrupt();
		paymentThread.interrupt();
	}
}