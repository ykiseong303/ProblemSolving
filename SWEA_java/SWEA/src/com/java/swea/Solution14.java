package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc=1;tc<T+1;tc++) {
			int [][] shape = new int[9][9];
			for (int i=0;i<9;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					shape[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 가로 9줄, 세로 9줄, 사각형 9개를 검증 
			boolean flag = true;
			int [] c1 = new int[9];
			int [] c2 = new int[9];
			int [] c3 = {0,0,0,0,0,0,0,0,0};
			int index = -1 ;
			for(int i=0;i<9;i++) { 
				for (int j=0;j<9;j++) {
					if ((i+1)%3==0 && (j+1)%3==0) {
						index+=1;
//						 System.out.printf("##i : %d j : %d\n",i,j);
						for(int k=i;k>i-3;k--) {
							for(int l=j;l>j-3;l--) {
								c3[index] += shape[k][l];
							}
						}
					}
					c1[i] += shape[i][j];
					c2[i] += shape[j][i];
				}
				
			}
			for (int check : c1) {
				if (check != 45 ) flag = false;
			}
			for (int check : c2) {
				if (check != 45 ) flag = false;
			}
			for (int check : c3) {
				if (check != 45 ) flag = false;
			}
			if (flag == true) System.out.printf("#%d 1\n",tc);
			else System.out.printf("#%d 0\n",tc);
		}
		
	}

}
