package com.java.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for (int tc = 1;tc<T+1;tc++) {
			int N = Integer.parseInt(sc.next());
			int lst[] = new int[N];
			for (int i=0;i<N;i++) lst[i] = Integer.parseInt(sc.next());
			Arrays.sort(lst);
			System.out.printf("#%d ",tc);
			for (int j=0;j<N;j++) System.out.print(lst[j]+" ");
			System.out.print("\n");
		}
	}

}
