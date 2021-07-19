package com.java.swea;

public class ArrayListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 향상된 for문을 통해 이차원 이상의 배열을 차원단위별로 끌어올 수 있다. 
		// 원리는 파이썬의 for s in shape : for a in s 와 같
		int[][] shape = {{1,2},{3,4}}; 
		for (int[] arrs : shape) { // 현재 2차원 배열로 선언되어있으므로 처음 가져올 참조형변수는 1차원 배열로 선언
			for(int arr : arrs) { // 이후에는 1차원 배열에서 값을 하나씩 꺼내오는 것이므로 일반변수로 선언
				System.out.print(arr+" ");
			}
			System.out.print("\n");
		}
	}

}
