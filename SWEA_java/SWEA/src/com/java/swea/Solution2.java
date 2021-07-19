package com.java.swea;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		for (int i=1;i<T+1;i++) {
			int sum=0;
			int N = Integer.parseInt(sc.next());
			for (int j=1;j<N+1;j++) {
				if (j%2==0) sum-=j;
				else sum += j;
			}
			System.out.printf("#%d %d\n",i,sum);
		}
	}

}
