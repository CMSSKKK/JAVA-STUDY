package compare;

import java.util.Arrays;
import java.util.Comparator;

public class compareTest {
	
	public static void main(String[] args) {
		
		Student[] arr = new Student[9];
		
		arr[0] = new Student(3, 70);	
		arr[1] = new Student(1, 70);	
		arr[2] = new Student(1, 50);	
		arr[3] = new Student(2, 60);	
		arr[5] = new Student(1, 30);	
		arr[6] = new Student(2, 70);	
		arr[7] = new Student(3, 90);	
		arr[8] = new Student(3, 60);	
		
		Student[] arr2 = arr.clone();	
		Student[] arr3 = arr.clone();	
		
		System.out.println("(c, s) -> (classNum, score)");
		System.out.print("정렬 전 : ");
		for(Student v : arr) {
			System.out.print(v);
		}
		System.out.println();
 
		Arrays.sort(arr);	// Comparable 사용
		
 
		System.out.print("\n학급 오름차순 정렬(같을 경우 성적 내림차순) : ");
		for(Student v : arr) {
			System.out.print(v);
		}
		System.out.println();
		
		
		
		Arrays.sort(arr2, comp1);	// Comparator 사용 
		
		System.out.print("\n학급 오름차순 정렬(같을 경우 성적 오름차순) : ");
		for(Student v : arr2) {
			System.out.print(v);
		}
		System.out.println();
	
		
		
		Arrays.sort(arr3, comp2);	// Comparator 사용
		
		System.out.print("\n성적 내림차순 정렬(같을 경우 학급 오름차순) : ");
		for(Student v : arr3) {
			System.out.print(v);
		}
		System.out.println();
		
	}
 
	
	static Comparator<Student> comp1 = new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			
			
			if(o1.classNum == o2.classNum) {
				return o1.score - o2.score;
			}
			return o1.classNum - o2.classNum;
		}
	};
	
	static Comparator<Student> comp2 = new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			
			if(o1.score == o2.score) {
				return o1.classNum - o2.classNum;
			}
			return o2.score - o1.score;	
		}
	};
}
 
 
class Student implements Comparable<Student> {
 
	int classNum;
	int score;
	
	public Student(int classNum, int score) {
		this.classNum = classNum;
		this.score = score;
	}
	
	@Override
	public int compareTo(Student o) {
		
		if(this.classNum == o.classNum) {
			return o.score - this.score;
		}
		return this.classNum - o.classNum;	
	}
	
	
	@Override
	public String toString() {
		return "("+classNum + ", " + score + ")  ";
	}
	
}
// https://st-lab.tistory.com/243
// 코드 따라치면서 익혀보기
