package com.java.swea;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int tc=1;tc<T+1;tc++) {
			int num = sc.nextInt();
			int[] lst = {-1,-1,0,0,-1,0,-1,0,-1,-1,-1,0};
			int[] data = {2,3,5,7,11};
			while (num!=1) { 
				for(int d : data) {
					if (num%d==0) {
						num = num/d;
						lst[d] += 1;
					}
				}
			}
			System.out.printf("#%d ",tc);
			for (int l : lst) {
				if (l!=-1) System.out.print(l+" ");
			}
			System.out.print("\n");
		}
	}

}
