# 객체지향개념 복습하기 



## 클래스와 객체



* 클래스 : 객체를 정의해 놓은 것

> 클래스는 객체를 생성하는데 사용
>
> 클래스 (설계도) 를 인스턴스화 해서 인스턴스(객체) 생성

* 객체 : 속성(변수) + 기능(메서드)

* 인스턴스 : 특정 클래스로 부터 생성된 객체 

1. *클래스 작성 (설계도 작성)* 
2. *객체 생성 (제품 생성)*
3. *객체 사용 (제품 사용)*

`Hello2.java`

``` java
public class Hello2{}  

	class Hello3{}
```

> public class가 있는 경우 소스파일의 이름은 public class의 이름과 일치해야 함
>
> *pulic class가 없는 경우는 하나의 class와만 일치하면 됨*
>
> *하나의  소스파일에는 하나의 public class만 존재 가능*



*하나의 소스 파일에는 하나의 클래스만 작성하는 것이 바람직*



### 객체의 생성과 사용

```java
// 클래스 생성 
class Tv {
    String color; 
    boolean power;
    int channel;
   	
    void power() {power= !power;}
    void channelUp() {channel++;}
    void channelDown() {channel--;}
}
// 객체 생성
// 클래스명 변수명; 클래스의 객체를 참조하기 위한 참조변수를 선언
// 변수명 = new 클래스명(); 클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장

Tv t; // Tv클래스 타입의 참조변수 t를 선언
t = new Tv(); // Tv인스턴스를 생성한 후, 생성된 Tv인스턴스의 주소를 t에 저장

//객체의 사용
class Tvtest{ 
    public static void main(String args[]) {
t.channel= 7; // Tv인스턴스의 멤버변수 channel의 값을 7로 한다
t.channelDown(); // Tv인스턴스의 메서드 channelDown()을 호출한다
System.out.println("t.channel")
    }
}
```

> 참조변수 t 는 `리모콘` 
>
>  `리모콘` 과 객체인 `Tv()`를 연결 
>
> 객체를 생성하기 위해선 `리모콘`으로만 다룰 수 있음 ! 

#### 객체 배열 == 참조변수 배열

`Tv tv1, tv2, tv3;` `Tv[] tvArr = new Tv[3]` 

```java
// 객체를 생성해서 배열의 각 요소에 저장
tvArr[0] = new Tv(); 
tvArr[1] = new Tv();
tvArr[2] = new Tv();

Tv[] tvArr = { new Tv(), new Tv(), new Tv()};

Tv[] tvArr = new Tv[3];
tvArr[0] = new Tv(); 
tvArr[1] = new Tv();
tvArr[2] = new Tv();
```

* 객체 배열을 만든 후 객체를 **꼭** 만들어서 넣어야 함! 



### 클래스의 정의

* 클래스 == 데이터 + 정의

> 1. *설계도*
> 2. *데이터 + 함수*
> 3. *사용자 정의 타입*



2. 데이터 + 함수

> 변수 - 하나의 데이터를 저장할 수 있는 공간
>
> 배열 - 같은 종류의 여러 데이터를 하나로 저장할 수 있는 공간
>
> 구조체 - 서로 관련된 여러 데이터(종류 관계x) 를 하나로 저장할 수 있는 공간

* **클래스 - 데이터와 함수의 결합(구조체 + 함수)** 



3. 사용자 정의 타입 - 원하는 타입을 직접 만들 수 있다.

```java
class Time {
    int hour;
    int minute;
    int second;
}

Time t = new Time(); 
t.hour =12;
t.minute 34;
t.second = 56;

// 서로 관련된 값을 묶고, 코드가 더 간결해지는 장점이 있음
```



*남궁 성의 정석 코딩(자바의 정석 기초편)*