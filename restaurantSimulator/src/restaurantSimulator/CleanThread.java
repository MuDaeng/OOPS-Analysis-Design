package restaurantSimulator;

import java.util.Timer;

import waitingLine.ClerkWaitingLine;

public class CleanThread implements Runnable {
	private int tableNum;
	public CleanThread() {
	}
	
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
					new RestaurantTask().cleanTable(tableNum);
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