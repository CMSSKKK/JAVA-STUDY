package callcenter_strategy_interface;

public class PriorityAllocation implements Scheduler{

	@Override
	public void getNextCall() {
		System.out.println("PriorityAllocation get");
		
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("PriorityAllocation send");
		
	}

}
