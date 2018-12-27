package restaurantSimulator;

public enum TableState {
	isEmpty,isOccupying,isCleanable,isCompleted;
	@Override
	public String toString() {
		switch(this) {
			case isEmpty :
				return "isEmpty";
			case isOccupying :
				return "isOccupying";
			case isCleanable :
				return "isCleanable";
			case isCompleted : 
				return "isCompleted";
			default :
				return null;
		}
	}
}