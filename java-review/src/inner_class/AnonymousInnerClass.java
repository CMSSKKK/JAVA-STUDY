package inner_class;

class Outer {
	
	Runnable getRunnable(int i) { 
		
		int num = 100; // 매개변수 int i와 지역변수 num은 상수 'final'로 컴파일 됨.
		
		return new Runnable() {

			@Override
			public void run() {
				System.out.println(i);
				System.out.println(num);
			}
			
		};
	}
	
	Runnable runner = new Runnable() {

		@Override
		public void run() {

			System.out.println("runner");
		}
		
	};
}

public class AnonymousInnerClass {

	public static void main(String[] args) {

		Outer out = new Outer();
		
		Runnable runnerable = out.getRunnable(10);
		runnerable.run();
		
		out.runner.run();
	}

}
