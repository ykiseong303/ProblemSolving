package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution13 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc<T+1;tc++) { 
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][] shape = new int[N][N];
			// 2차원 맵 입력받기
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<N;j++) {
					shape[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for (int i = M-1;i<N;i++) {
				for (int j=M-1;j<N;j++) {
//					System.out.printf("##i: %d j: %d\n",i,j );
					int sum = 0;
					// 현재 위치를 기준으로
					// M-1까지의 서브 모양의 합계를 계산 
					for (int k=i;k>i-M;k--) {
						for (int l=j;l>j-M;l--) {
//							System.out.printf("k: %d l: %d\n",k,l );
							sum += shape[k][l];
						}
					}
//					System.out.printf("#sum : %d\n",sum );
					max = (max < sum ? sum : max);
				}
			}
			System.out.printf("#%d %d\n",tc,max);
			
		}
	}

}
