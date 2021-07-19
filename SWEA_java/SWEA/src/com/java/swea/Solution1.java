package com.java.swea;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		for (int i=1;i<T+1;i++) {
			String s = sc.next();
			boolean flag = true;
			int middle = s.length()/2;
			if (s.length() % 2 == 1) {
				for (int j=0;j<middle;j++) {
					if (s.charAt(j) !=s.charAt(s.length()-1-j)) {
						// System.out.print(s.charAt(i)+"\n");
						flag = false;
						break;
					}
						
				}
					
			}
			
			else {
				for(int k=0;k<middle+1;k++) {
					if (s.charAt(k) !=s.charAt(s.length()-1-k)) {
						flag = false;
						break;
					}
				}
			}
			if (flag == false) System.out.printf("#%d 0\n",i);
			else System.out.printf("#%d 1\n",i);
		}
	}

}
