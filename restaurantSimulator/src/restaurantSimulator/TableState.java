package restaurantSimulator;

public enum TableState {
	isEmpty,isOccupying,isCleanable,isComplete;
	@Override
	public String toString() {
		switch(this) {
			case isEmpty :
				return "isEmpty";
			case isOccupying :
				return "isOccupying";
			case isCleanable :
				return "isCleanable";
			case isComplete : 
				return "isComplete";
			default :
				return null;
		}
	}
}