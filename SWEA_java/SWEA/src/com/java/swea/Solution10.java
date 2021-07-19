package com.java.swea;

import java.util.Scanner;

public class Solution10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i=1;i<N+1;i++) {
			// i를 string으로 변환 
			String s = Integer.toString(i);
			boolean flag = false;
			for(int j=0;j<s.length();j++) {
//				System.out.println("j"+s.charAt(j));
//				if ((j == s.length()-1) && (flag==false)) System.out.print(s);  
				if ((s.charAt(j) == '3') || (s.charAt(j)=='6') || (s.charAt(j)=='9')) {
					System.out.print("-");
					flag = true;
				}
				
				
			}
			if (flag==false) System.out.print(s);
			System.out.print(" ");
		}
	}

}
