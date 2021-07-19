package com.java.swea;

import java.util.Scanner;

public class Solution8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for (int tc=1;tc<T+1;tc++) {
			int t = Integer.parseInt(sc.next());
			int score[] = new int[101];
			for(int i=0;i<101;i++) score[i] = 0;
			for(int j=0;j<1000;j++) score[Integer.parseInt(sc.next())] += 1;
			int start_score =0;
			
			for(int k=1;k<101;k++) {
				if (score[start_score] < score[k]) {
					start_score = k;
					
				}
				else if (score[start_score] == score[k]) {
					if (start_score > k) continue;
					else start_score = k;
				}
			}
			 
			System.out.printf("#%d %d\n",t,start_score);
					
		}
	}

}
