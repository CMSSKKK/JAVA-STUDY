package mc.sn.day3;

public class GugudanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<8;i++) {
			int danNumber = i+2;
			for(int j=0;j<9;j++) {
				int number= j+1;
				System.out.println(danNumber+"X"+number+"="+danNumber*number);
			}
			System.out.println();
		}
	}

}
