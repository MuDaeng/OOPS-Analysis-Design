package restaurantSimulator;

import waitingLine.ClerkWaitingLine;

public class CleanThread implements Runnable {
	private Progress progress;
	private int tableNum;
	public CleanThread() {
		progress = Progress.getInstance();
	}
	
	@Override
	public void run() {   

		while(true){
			boolean flag = false;
			int size = progress.getTables().length;
			for(int count = 0; count < size; count++) {
				if(progress.getTable(count+1).getTableStatus().getTableState() == TableState.isCleanable) {
					flag = true;
					tableNum = count+1;
					break;
				}
			}
			if(ClerkWaitingLine.getInstance().getListSize() > 0 && flag) {
				new Thread(() -> {
					new RestaurantTask().cleanTable(tableNum);
				}).start(); 
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException ie) {
				break;
			}
		}	   
	}
}