package algorithm;

public class MInMaxProblem {

	public static void main(String[] args) {
		int[] numbers = {10, 55, 23, 2, 79, 101, 16, 82, 30, 45};
		
		int min = numbers[0];
		int max = numbers[0];
		
		int minIndex= 0;
		int maxIndex= 0;
		
		for (int i = 1; i < numbers.length; i++) {
			
			if(max< numbers[i]) {
				max = numbers[i];
				maxIndex = i+1;
			}
			
			if(min>numbers[i]) {
				min = numbers[i];
				minIndex = i+1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(max).append('\t').append(maxIndex).append('\n');
		sb.append(min).append('\t').append(minIndex);
		
		System.out.println(sb);
	}

}
