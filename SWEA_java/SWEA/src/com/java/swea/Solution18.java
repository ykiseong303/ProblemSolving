package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution18 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc =1; tc<T+1;tc++) { 
			 st = new StringTokenizer(br.readLine());
			 int N = Integer.parseInt(st.nextToken());
			 int M = Integer.parseInt(st.nextToken());
			 
			 int[] temp1 = new int [N];
			 int[] temp2 = new int [M];
			 
			 st = new StringTokenizer(br.readLine());
			 for (int i=0;i<N;i++) {
				 temp1[i] = Integer.parseInt(st.nextToken());
			 }
			 st = new StringTokenizer(br.readLine());
			 for (int i=0;i<M;i++) {
				 temp2[i] = Integer.parseInt(st.nextToken());
			 }
			 
			 int max_val = 0;
			 if (N<M) {
				 for(int i=0;i<M-N+1;i++) {
					 int sum = 0;
					 int index = 0;
					 for(int j=i;j<i+N;j++) {
						 sum = sum + temp1[index] * temp2[j];
//						 System.out.println(temp1[index]);
						 index ++;
					 }
//					 System.out.println(sum);
					 max_val = (max_val < sum) ? sum : max_val;
				 }
			 }
			 else if (N>M) { 
				 for(int i=0;i<N-M+1;i++) {
					 int sum = 0;
					 int index = 0;
					 for(int j=i;j<i+M;j++) {
						 sum = sum + temp2[index] * temp1[j];
//						 System.out.printf(temp1[j]+" ");
						 index ++;
					 }
//					 System.out.print("\n");
//					 System.out.println(sum);
					 max_val = (max_val < sum) ? sum : max_val;
				 }
			 }
			 else { 
				 int sum = 0;
				 for (int i=0;i<N;i++) {
					 sum = sum+ temp1[i] * temp2[i]; 
				 }
				 max_val = sum;
			 }
			 System.out.printf("#%d %d\n",tc,max_val);
			 
		}
	}

}
