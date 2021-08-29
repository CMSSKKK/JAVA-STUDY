# TreeSet 클래스 활용

* 객체의 정렬에 사용하는 클래스
* Set 인터페이스를 구현하여 중복을 허용하지 않고, 오름차순이나 내림차순으로 객체를 정렬할 수 있음
* 내부적으로 이진검색트리(binary search tree)로 구현됨
* 이진검색트리에 저장하기 위해 각 객체를 비교해야 함
* 비교 대상이 되는 객체에 Comparable이나 Comparator 인터페이스를 구현 해야 TreeSet에 추가 될 수 있음
* String, Integer등 JDK의 많은 클래스들이 이미 Comparable을 구현했음



* String 클래스는 이미 Comprable 인터페이스가 구현되어 있으므로 오름차순으로 정렬되어 출력됨

```java
public class Member implements Comparable<Member>{

	......

	@Override
	public int compareTo(Member member) {
		
		//return (this.memberId - member.memberId);   //오름차순
		return (this.memberId - member.memberId) *  (-1);   //내림 차순
	}
  
}
// Member클래스가 아이디 오름차순으로 정렬되게 하기 위해 Comparable 인터페이스를 구현

```

```java

class MyCompare implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return (s1.compareTo(s2)) *-1 ;
	}
  
} 
// Comparator의 활용 : 이미 Comparable이 구현된 경우 Comparator로 비교하는 방식을 다시 구현할 수 있음
```



Comparator는 익명객체로 여러개를 생성할 수 있지만, Comparable의 경우 compareTo 하나 밖에 구현할 수 없다.

그렇다보니, 보통은 Comparable은 여러분이 비교하고자 하는 가장 기본적인 설정(보통은 오름차순)으로 구현하는 경우가 많고, Comparator는 여러개를 생성할 수 있다보니 특별한 정렬을 원할 때 많이 쓰인다.

 쉽게 말해 Comparable은 기본(default) 순서를 정의하는데 사용되며, Comparator은 특별한(specific) 기준의 순서를 정의할 때 사용된다는 것이다.