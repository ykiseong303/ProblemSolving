package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution16 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// map을 받을 2차원 shape 생성
			int [][] shape = new int[N][N];
			// shape에 값을 입력받기 
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					shape[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			// 가로부터 검사 
			for (int i=0;i<N;i++) { // 행은 0~N까지 움직이
				for(int j=0;j<=N-K;j++) { // 열은 0부터 N-K까지만 이동
					boolean flag = true;
					if (shape[i][j] == 1) { // 현재위치가 1인 경우에
						
						// 현재위치에서 + K-1위치를 확인
						for (int g = j;g<j+K;g++) {
							if (shape[i][g] != 1 )  { // 다음위치가 1이 아닌경우 continue
								if (j<=N-K-1) { // 한칸 더를 고려할 수 있는 경 
									if (shape[i][j+K] == 1) {
										flag = false;
										break;
									}
								} 
								flag = false; 
								break;
							}
							if (g==j+K-1 && flag == true) count +=1 ;
						}
						
						

					}
//					if (flag == true) count += 1;
				}
			}
			System.out.print(count);
		}
	}

}
