package restaurantSimulator;

public enum TableState {
	isEmpty,isOccupying,isCleanable;
	@Override
	public String toString() {
		switch(this) {
			case isEmpty :
				return "isEmpty";
			case isOccupying :
				return "isOccupying";
			case isCleanable :
				return "isCleanable";
			default :
				return null;
		}
	}
}
