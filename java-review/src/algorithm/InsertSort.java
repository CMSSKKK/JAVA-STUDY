package algorithm;

public class InsertSort {

	public static void main(String[] args) {
		
		int[] arr = {80, 50, 70, 10, 60, 20, 40, 30 };
		insertSort(arr);
		
	}
	
	public static void insertSort(int[] arr) {
		
		
		int i, j = 0;
		int temp = 0;
		
		for( i = 1; i< arr.length; i++) {
			temp = arr[i];
			j = i;
			while((j>0) && arr[j-1]>temp) {
				arr[j] = arr[j-1];
				j = j-1;
			}
			arr[j]= temp;

			System.out.println(i);
			printSort(arr);
		}
	}
	
	public static void printSort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

	}
}
