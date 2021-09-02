package algorithm;

public class HeapSort {
	
	private int SIZE;
	private int[] heapArr;
	
	public HeapSort() {
		SIZE = 0;
		heapArr = new int[50];
	}
	
	
	public void insertHeap(int input) {
		int i = ++SIZE;
		//while( (i!=1) && (input > heapArr[i/2])) { // maxHeap
		while( (i!=1) && (input < heapArr[i/2])) { // minHeap
			heapArr[i] = heapArr[i/2];
			i = i/2;
		}
		heapArr[i] = input;
	}
	
	public int getHeapSize() {
		return SIZE;
	}
	
	public int deleteHeap() { // 최상위 노드를 삭제한 다음 맨 끝 노드를 최상위 노드로 위치시킨다고 가정하고 그 위치를 다시 정렬하는 개념 
		int parent, child;
		int data, temp;
		data = heapArr[1];
		
		temp = heapArr[SIZE];
		SIZE -= 1;
		parent = 1;
		child = 2;
		
		while(child <= SIZE) {
			//if((child < SIZE) && (heapArr[child] < heapArr[child+1])) { // maxHeap
			if((child < SIZE) && (heapArr[child] > heapArr[child+1])) { // minHeap
				child++;
			}
			//if(temp >= heapArr[child]) break; // maxHeap
			if(temp <= heapArr[child]) break; // minHeap
			heapArr[parent] = heapArr[child];
			parent = child;
			child *= 2;
		}
		
		heapArr[parent] = temp;
		return data;
	}
	
	public void printHeap() {
		for (int i = 1; i <= SIZE; i++) {
			System.out.printf("[%d] ",heapArr[i]);
		}
	}
	
	public static void main(String[] args) {
		HeapSort h = new HeapSort();
		h.insertHeap(80);
		h.insertHeap(50);
		h.insertHeap(70);
		h.insertHeap(10);
		h.insertHeap(60);
		h.insertHeap(20);
		
		h.printHeap();
	
//		int n, data;
//		n = h.getHeapSize();
//		for(int i=1; i<=n; i++){    
//			data = h.deleteHeap();  
//			System.out.printf("\n 출력 : [%d]", data);
//		}


	}

}
