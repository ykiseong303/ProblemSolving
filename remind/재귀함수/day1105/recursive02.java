package day1105;

public class recursive02 {
	
	private static int[] arr = {1,2,3};
	
	// 결정요인이 되는 매개변수 : 배열의 인덱스 (배열의 크기-1만큼 증가)
	private static void recursive_print(int i) {
		
		// 3. 기저조건 > 배열의 끝에 도달하면 종료 
		if(i==arr.length) return;
		
		// 1. 현재시점에서 해야 하는 일 > 현재번째를 출력
		System.out.println(arr[i]);
		// 2. 반복되는 일 처리 > 다음으로 넘기기 
		recursive_print(i+1);
	}
	
	public static void main(String[] args) {
		recursive_print(0);
	}
}
