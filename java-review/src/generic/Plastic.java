package generic;

public class Plastic extends Material {

	@Override
	public void doPrinting() {
		System.out.println("print plastic");
		
	}
	
	public String toString() {
		return "plastic";
	}
}
