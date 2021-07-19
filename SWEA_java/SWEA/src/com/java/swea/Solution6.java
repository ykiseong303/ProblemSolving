package com.java.swea;

import java.util.Scanner;

public class Solution6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		for(int tc=1;tc<T+1;tc++) {
			int N = Integer.parseInt(sc.next());
			int lst[][] = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					lst[i][j] = Integer.parseInt(sc.next());
				}
			}
			
			change(lst);
		}
		
		
	}

	private static void change(int arr[][]) {
		// TODO Auto-generated method stub
		
	}

}
