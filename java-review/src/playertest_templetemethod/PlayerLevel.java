package playertest_templetemethod;

public abstract class PlayerLevel {
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	final public void go(int N) {
		run();
		for (int i = 0; i < N; i++) {
			jump();
		}
		turn();
		
	}
}
