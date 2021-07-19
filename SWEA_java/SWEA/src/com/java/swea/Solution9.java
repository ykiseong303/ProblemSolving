package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// System.out.print(Integer.parseInt(T));
		for(int tc=1;tc<T+1;tc++) {
			String[] lst = br.readLine().split(" ");
			int h1 = Integer.parseInt(lst[0]); 
			int h2 = Integer.parseInt(lst[2]);
			int m1 = Integer.parseInt(lst[1]);
			int m2 = Integer.parseInt(lst[3]);
			
			int res_h = h1+h2;
			int res_m = 0;
			if (m1+m2 >=60) {
				res_m = m1+m2-60;
				res_h += 1;
			} else res_m = m1+m2;
			if (res_h > 12) res_h -= 12;
			System.out.printf("#%d %d %d\n",tc, res_h,res_m);
		}
	}

}
