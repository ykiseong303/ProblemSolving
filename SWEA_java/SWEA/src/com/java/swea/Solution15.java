package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int [][] shape = new int[N][N];
			
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					shape[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i=0;i<N;i++) { 
				for (int j=0;j<N;j++) {
					boolean g_check = true;
					boolean s_check = true; 
					int g_cnt = K;
					int s_cnt = K;
					if (shape[i][j]==1) {
						System.out.printf("i : %d j : %d\n",i,j);
						// 가로 먼저 검사
						if (j+K-1<=N) {
							for (int g=j;g<N-K+1;g++) {
//								if (g==i+K && shape[i][j]==1) g_check = false;
								if (shape[i][g] != 1) {
									System.out.printf("garo false i : %d j : %d\n",i,j);
									g_check = false; 
									g_cnt -= 1; 
								}
								if (j<N-K && shape[i][j+K] ==1) {
									g_check = false;
									g_cnt -= 1;
								}
							}
						}
						System.out.printf("i : %d j : %d g_count : %d\n",i,j,g_cnt);
						// 세로 검사
						if (i+K-1<=N) {
							for (int g=i;g<N-K+1;g++) {
//								if (g==j+K && shape[i][j]==1) s_check = false;
								if (shape[g][j] != 1) {
									System.out.printf("sero false i : %d j : %d\n",i,j);
									s_check = false;
									s_cnt -= 1;
								}
								if (i<N-K && shape[i+K][j] == 1) {
									s_check = false;
									s_cnt -=1;
								}
							}
						}
						System.out.printf("i : %d j : %d s_count : %d\n",i,j,s_cnt);
						if (g_check == true && g_cnt == K) count += 1;
						if (s_check == true && s_cnt == K) count += 1;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, count);
		}
		
	}

}
