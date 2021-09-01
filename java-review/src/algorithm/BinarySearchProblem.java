package algorithm;

public class BinarySearchProblem {

	public static void main(String[] args) {
		
		int[] numbers = {12, 25, 31, 48, 54, 66, 70, 83, 95, 108}; // 정렬된 상태
		
		int target = 83;
		
		int left = 0;
		int right = numbers.length-1;
		int mid = (left+right) /2;
		
		int temp = numbers[mid];
		boolean find = false;
		
		while(right >= left) {
			
			if(target == temp) {
				find = true;
				break;
			} else if(target<temp) {
				right = mid-1;
			} else {
				left = mid+1;
			}
			mid = (left+right)/2;
			temp = numbers[mid];
		}
		
		if(find == true) {
			System.out.println(mid+1);
		} else {
			System.out.println("찾을 수 없습니다. ");
		}
	}

}
