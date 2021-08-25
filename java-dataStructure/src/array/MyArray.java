package array;

public class MyArray {
	int[] intArr;
	int count;
	
	public int ARRAY_SIZE;
	public static final int ERROR = -9999999;
	
	public MyArray() {
		count = 0;
		ARRAY_SIZE = 10;
		intArr = new int[ARRAY_SIZE];
		
	}
	
	public MyArray(int size) {
		count = 0;
		ARRAY_SIZE = size;
		intArr = new int[ARRAY_SIZE];
		
	}
	
	public void addElement(int num) {
		if(count>= ARRAY_SIZE) {
			System.out.println("memory error ");
			return;
		}
		intArr[count++] = num;
	}
	
	public void insertElement(int index, int num) {
		if(count>= ARRAY_SIZE) {
			System.out.println("memory error ");
			return;
		}
		
		if(index < 0 || index > count) {
			System.out.println("insert error");
			return;
		}
		
		for (int i = count -1 ; i >= index; i--) {
			intArr[i+1] = intArr[i];
		}
		
		intArr[index] = num;
		count++;
	}
	
	public int removeElement(int index) {
		
		int ret = ERROR;
		
		if(isEmpty()){
			System.out.println("There is no element");
			return ret;
		}
		
		if(index < 0 || index >= count ){  
			System.out.println("remove Error");
			return ret;
		}
		
		ret = intArr[index];
		
		for(int i = index; i<count -1; i++ )
		{
			intArr[i] = intArr[i+1];
		}
		count--;
		return ret;
	}
	
	public int getSize() {
		return count;
	}
	
	public boolean isEmpty() {
		if(count == 0) return true;
		else return false;
	}
	
	public int getElement(int index) {
		if(index < 0 || index > count-1) {
			System.out.println("검색 위치 오류. 현재 리스트의 개수는 " + count +"개 입니다.");
			return ERROR;
		}
		return intArr[index];
	}
	
	public void printAll()
	{
		if(count == 0){
			System.out.println("출력할 내용이 없습니다.");
			return;
		}
			
		for(int i=0; i<count; i++){
			System.out.println(intArr[i]);
		}
		
	}
	
	public void removeAll()
	{
		for(int i=0; i<count; i++){
			intArr[i] = 0;
		}
		count = 0;
	}
}
