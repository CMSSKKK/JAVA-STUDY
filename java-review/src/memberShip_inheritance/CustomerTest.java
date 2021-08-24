package memberShip_inheritance;
//회사에서 고객 정보를 활용한 맞춤 서비스를 하기 위해 일반고객(Customer)과 
//이보다 충성도가 높은 우수고객(VIPCustomer)에 따른 서비스를 제공하고자 함
//
//물품을 구매 할때 적용되는 할인율과 적립되는 보너스 포인트의 비율이 다름 
//여러 멤버십에 대한 각각 다양한 서비스를 제공할 수 있음
//멤버십에 대한 구현을 클래스 상속을 활용하여 구현해보기

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customerLee = new Customer();
		customerLee.setCustomerName("이순신");
		customerLee.setCustomerID(10010);
		customerLee.bonusPoint = 1000;
		System.out.println(customerLee.calcPrice(10000));
		System.out.println(customerLee.showCustomerInfo());
		
			
			
		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerName("김유신");
		customerKim.setCustomerID(10020);
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.calcPrice(10000));
		System.out.println(customerKim.showCustomerInfo());
	}
}
