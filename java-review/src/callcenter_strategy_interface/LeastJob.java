package callcenter_strategy_interface;

public class LeastJob implements Scheduler {

	@Override
	public void getNextCall() {
		System.out.println("LeastJob get");
		
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("LeastJob send");
		
	}

}
