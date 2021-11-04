package day1105;

import java.util.Arrays;

public class recursive03 {

	private static int[][] arr = {{1,2,3}, {4,5,6}};
	
	private static void recursive_print(int i, int j) {
		System.out.println(i+" : "+j);
		// 3. 기저조건 
		if(j==arr[0].length) {
			//recursive_print(i+1,0);
			i+=1;
			j=0;
		}
		if(i==arr.length) return;
		
		// 1. 현재 할 수 있는 일 처리 > (i,j)번째 출력
		System.out.println(arr[i][j]);
		// 2. 다음번째로 넘기기 (다음 열을 출력)
		recursive_print(i,j+1);
	}
	 
	private static void recursive_print2(int i) {
		if(i==arr.length) return;
		System.out.println(Arrays.toString(arr[i]));
		recursive_print2(i+1);
	}
	public static void main(String[] args) {
		System.out.println(arr.length);
		//recursive_print(0,0);
		recursive_print2(0);
	}
}
