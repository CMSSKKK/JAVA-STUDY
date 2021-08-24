package playertest_templetemethod;

public class SuperLevel extends PlayerLevel {

	@Override
	public void run() {
		System.out.println("super run");
		
	}

	@Override
	public void jump() {
		System.out.println("super jump");
		
	}

	@Override
	public void turn() {
		System.out.println("super turn");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("======super level======");
		
	}

}
