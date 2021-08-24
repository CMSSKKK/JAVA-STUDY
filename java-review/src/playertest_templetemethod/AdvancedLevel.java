package playertest_templetemethod;

public class AdvancedLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("advanced run");
		
	}

	@Override
	public void jump() {
		System.out.println("advanced jump");
		
	}

	@Override
	public void turn() {
		System.out.println("advanced turn");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("======advanced level======");
		
	}

}
