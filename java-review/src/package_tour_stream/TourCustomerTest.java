package package_tour_stream;

import java.util.ArrayList;
import java.util.List;

public class TourCustomerTest {
	
	public static void main(String[] args) {
		TourCustomer customerLee = new TourCustomer("이순신", 40, 100);
		TourCustomer customerKim = new TourCustomer("김유신", 20, 100);
		TourCustomer customerHong = new TourCustomer("홍길동", 13, 50);
		
		List<TourCustomer> customerList = new ArrayList<>();
		customerList.add(customerLee);
		customerList.add(customerKim);
		customerList.add(customerHong);
		
		customerList.stream().map(c->c.getCustomerName()).forEach(s->System.out.println(s));
		System.out.println();
		
		int total =customerList.stream().mapToInt(c->c.getCustomerPrice()).sum();
		System.out.println(total);
		System.out.println();
		
		customerList.stream().filter(c->c.getCustomerAge() >= 20).map(s->s.getCustomerName()).sorted().forEach(s->System.out.println(s));
	}
}

