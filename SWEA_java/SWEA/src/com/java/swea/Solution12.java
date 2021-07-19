package com.java.swea;

import java.util.Scanner;

public class Solution12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc=1; tc<T+1;tc++) {
			String s = sc.nextLine();
			int wave = 0;
			for (int i=1;i<10;i++) {
				String sub = s.substring(0,i);
				String subnext = s.substring(i,i+i);
				if (sub.equals(subnext)) {
					wave = i;
					break;
				}
			}
			System.out.printf("#%d %d\n",tc, wave);
			 
			
		}
	}

}
