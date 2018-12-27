package restaurantSimulator;

import waitingLine.ClerkWaitingLine;

public class CleanThread implements Runnable {
	private int tableNum;
	public CleanThread() {
	}
	
	//when exist table that has isCleanable, take care of clean table and update 0.5 seconds
	@Override
	public void run() {   

		while(true){
			boolean flag = false;
			int size = Progress.getInstance().getTables().length;
			for(int count = 0; count < size; count++) {
				if(Progress.getInstance().getTable(count+1).getTableStatus().getTableState() == TableState.isCleanable) {
					flag = true;
					tableNum = count+1;
					break;
				}
			}
			if(ClerkWaitingLine.getInstance().getListSize() > 0 && flag) {
				new Thread(() -> {
					try {
						new RestaurantTask().cleanTable(tableNum);
					}catch(IndexOutOfBoundsException ie) {
						new RuntimeException(ie);
					}
				}).start();
			}
			try {
				Thread.sleep(499);
			} catch (InterruptedException ie) {
				break;
			}
		}	   
	}
}