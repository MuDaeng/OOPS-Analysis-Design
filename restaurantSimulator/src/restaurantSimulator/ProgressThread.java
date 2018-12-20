package restaurantSimulator;

public class ProgressThread implements Runnable{
	private Progress progress;
	private RestaurantTask task;
	
	public ProgressThread() {
		progress = Progress.getInstance();
		task = new RestaurantTask();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Thread.yield();
			if(Thread.currentThread().isInterrupted()) {
				task.requestOrder();
			}	
		}
	}

}
