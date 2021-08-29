package package_tour_stream;

public class TourCustomer {
	
	private String customerName;
	private int customerAge;
	private int customerPrice;
	
	public TourCustomer() {}
	
	public TourCustomer(String name, int age, int price) {
		this.customerName = name;
		this.customerAge = age;
		this.setCustomerPrice(price);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public int getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(int customerPrice) {
		this.customerPrice = customerPrice;
	}
	
	@Override
	public String toString() {
		return "이름: "+ customerName+ " 나이: "+customerAge;
	}
}
