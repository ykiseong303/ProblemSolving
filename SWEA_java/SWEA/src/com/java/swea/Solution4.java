package com.java.swea;

import java.util.Scanner;

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		int money[] = {50000,10000,5000,1000,500,100,50,10};
		
		for (int tc=1;tc<T+1;tc++) {
			int count[] = {0,0,0,0,0,0,0,0};
			int num = Integer.parseInt(sc.next());
			System.out.printf("#%d\n",tc);
			for (int i=0;i<8;i++) {
				if(num>=money[i]) {
					 count[i] += num/money[i];
					 num = num%money[i];
				}
			}
			for (int j=0;j<8;j++) System.out.print(count[j]+" ");
			System.out.print("\n");
			
		}
	}

}
