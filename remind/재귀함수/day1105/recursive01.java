package day1105;

public class recursive01 {
	
	private static int fact(int n) {
		
		// 더 이상 재귀가 진행되지 않도록 멈추는 기저조건 
		if(n<=1) return 1;		
		
		// 재귀의 반복파트를 먼저 작성
		// 현재의 나와 나머지를 계산 
		return n * fact(n-1);
	}
	
	// 반복문을 이용한 팩토리얼 계산 
	private static int fact2(int n) {
		int res = 1;
		for(int i = n;i>0;i--) {
			res *= i;
		}
		return res;
	}
	
	// 반복문으로 짜인 코드를 재귀로 변경 
	private static int res = 1;
	
	// 계속 바뀌는 값이 결정요인(매개변수)이 되어야 한다.
	// 그 값은 반복되는 i 
	private static void fact3(int i) {
		
		// 3. 기저조건
		if(i==0) return;
		// 1. 현재 일을 해결하는 반복되는 파트를 가져옴 
		res *= i;
		// 2. 그리고 다음 작업으로 넘어가기 위해서는 ? 
		// 현재 값보다 하나 작은 값을 매개변수로 호출 
		fact3(i-1);
	}
	
	public static void main(String[] args) {
		System.out.println(fact(4));
		System.out.println(fact2(4));
		fact3(4);
		System.out.println(res);
	}
}
