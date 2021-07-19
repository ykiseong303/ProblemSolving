package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution23 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			int speed = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int g = Integer.parseInt(st.nextToken());
				if (g!=0) {
					int s = Integer.parseInt(st.nextToken());
					if (g==1) {
						speed += s;
						sum += speed;
					}
					else {
						if (speed < s) sum =0;
						else {
							speed -= s;
							sum += speed;
						}
					}
				}
				else {
					sum += speed;
					continue;
				}
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
		
	}

}
