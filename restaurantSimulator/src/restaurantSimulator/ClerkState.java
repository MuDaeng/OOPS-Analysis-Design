package restaurantSimulator;

public enum ClerkState {
	takePayment,takeOrder,takeClearTable,notWorking;
	
	@Override
	public String toString() {
		switch(this) {
		case takePayment :
			return "결제 돕는중";
		case takeOrder :
			return "주문 처리중";
		case takeClearTable :
			return "상치우는중";
		case notWorking :
			return "노는중";
		default :
			return null;
		}
	}
}
