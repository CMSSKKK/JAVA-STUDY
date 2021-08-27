# 제네릭(Generic)

* 클래스에서 사용하는 변수의 자료형이 여러개 일수 있고, 그 기능은 동일하는 경우 클래스의 자료형을 특정하지 않고 추후 해당 클래스를 사용할 때 지정 할 수 있도록 선언
* 실제 사용되는 자료형의 변환은 컴파일러에 의해 검증되므로 안정적인 프로그래밍 방식
* 컬렉션 프레이뭐크에서 많이 사용되고 있음

> 제네릭을 사용하지 않고 `Object` 클래스를 사용할 수 도 있지만, 형변환이 꼭 필요하다

## 제네릭 클래스 사용하기

Powder.java

```java
public class Powder {
	
	public String toString() {
		return "재료는 Powder 입니다";
	}
}
```

Plastic.java

```java
public class Plastic {

	public String toString() {
		return "재료는 Plastic 입니다";
	}
}
```

GenericPrinter.java

```java
public class GenericPrinter<T> {
	private T material;   //T 자료형으로 선언한 변수
	
	public void setMaterial(T material) {
		this.material = material;
	}
	
	public T getMaterial() {   //T 자료형을 반환하는 제네릭 메서드
		return material;
	}
	
	public String toString(){
		return material.toString();
	}
}
```

GenericPrinterTest.java

```java
public class GeneriPrinterTest {

	public static void main(String[] args) {

		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
		powderPrinter.setMaterial(new Powder());
		System.out.println(powderPrinter);
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		plasticPrinter.setMaterial(new Plastic());
		System.out.println(plasticPrinter);
		
	}

}
```



- 자료형 매개변수 T(type parameter) : 이 클래스를 사용하는 시점에 실제 사용할 자료형을 지정, static 변수는 사용할 수 없음
- E : element, K: key, V : value 등 여러 알파벳을 의미에 따라 사용 가능

## 