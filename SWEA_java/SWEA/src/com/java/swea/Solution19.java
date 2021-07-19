package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution19 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			int [] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			if (m1==m2) System.out.printf("#%d %d\n",tc,d2-d1+1);
			else {
				int day = 0;
				for (int i=m1;i<m2+1;i++) {
					// 시작 월
					if (i==m1) {
						day = month[m1] - d1 + 1;
					}
					// 끝나는 월 
					else if (i==m2) {
						day += d2;
					}
					// 나머지 
					else if(i!=m1 && i!=m2){
						day += month[i];
					}
				}
				System.out.printf("#%d %d\n", tc, day);
			}
			
		}
	}

}
