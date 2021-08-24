package memberShip_inheritance;

public class VIPCustomer extends Customer{
	
	private int agentID;
	double salesRatio;
	
	public VIPCustomer() {
		salesRatio = 0.1;
		bonusRatio = 0.05;
		
		customerGrade = "VIP";
	}
	
	@Override
	public int calcPrice(int price) {
		int resultPrice = 0;
		resultPrice = price - (int)(price * salesRatio);
		//bonusPoint += price * bonusRatio; 
		return resultPrice;
	}
	
}
