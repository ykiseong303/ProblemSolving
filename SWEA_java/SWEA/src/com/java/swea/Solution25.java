package com.java.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution25 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			double [] score = new double [N];
			double target = 0;
			String [] res = {"D0","C-","C0","C+","B-","B0","B+","A-","A0","A+"};
//			String [] res = {"","A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			for (int i=0;i<N;i++) {
				double sum = 0;
				st = new StringTokenizer(br.readLine());
				double data1 =  (Integer.parseInt(st.nextToken())* 0.35);
				double data2 =  (Integer.parseInt(st.nextToken())* 0.45);
				double data3 =  (Integer.parseInt(st.nextToken())* 0.2);
				sum = data1+data2+data3;
				if (i==K-1) {
					target = sum; 
//					System.out.printf("data1 : %f data2 : %f data3 : %f\n",data1,data2,data3);
				}
				score[i] = sum;
			}
//			System.out.printf("target : %f\n", target);
			int target_index = 0;
			Arrays.sort(score);
			for (int i=0;i<N;i++) {
				if(score[i] == target) {
//					System.out.printf("score[i] : %ftarget : %f\n", score[i],target);
					target_index = i;
//					System.out.printf("target_index :  %d i : %d\n", target_index, i);
					break;
				}
			}
			System.out.printf("#%d %s\n",tc,res[target_index/(N/10)]);
//			for (double d : score) {
//				System.out.println(d);
//			}
//			System.out.println(target_index);
			
//			if (N>10) { 
//				if (target_index<10) {
//					System.out.println("yes");
//					System.out.printf("#%d %s\n",tc,res[0]);
//				}
//				else {
//					System.out.printf("#%d %s\n",tc,res[target_index/10]);
//				}
//			}
//			else {
//				System.out.printf("#%d %s\n",tc,res[target_index%10]);
//			}
			
		}
	}

}
