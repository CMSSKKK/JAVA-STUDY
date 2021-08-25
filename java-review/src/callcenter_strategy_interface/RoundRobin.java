package callcenter_strategy_interface;

public class RoundRobin implements Scheduler {

	@Override
	public void getNextCall() {
		System.out.println("RoundRobin get");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("RoundRobin send");
		
	}

}
