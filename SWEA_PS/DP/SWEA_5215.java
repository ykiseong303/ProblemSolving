package algo_hw_0913_0917;

import java.util.Scanner;

public class SWEA_5215 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
	 		int L = sc.nextInt();
			
			// 맛의 점수와, 칼로리를 저장하기 위한 배열 (1번째 인덱스부터 저장)
			int[] score = new int[N+1];
			int[] kcal = new int[N+1];
			 
			for(int i=1;i<=N;i++) {
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			
			// i번째 재료까지 고려한 1 ~ L까지의 칼로리의 최대 점수를 기록하기 위한 dp테이블 생성 
			int[][] d = new int[N+1][L+1];
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=L;j++) {
					// i번째까지 고려했을 때,
					// 허용 칼로리를 1부터 L까지로 나눴을때, 각각의 경우의 최댓값을 저장 
					
					if(kcal[i]<=j) { // i번째까지 고려했을 때의 칼로리가 현재 최대 칼로리보다 작거나 같은경우
						d[i][j] = Math.max(d[i-1][j], score[i]+d[i-1][j-kcal[i]]);
					} else { // 
						d[i][j] = d[i-1][j];
					}
				}
			}
			System.out.printf("#%d %d\n",tc,d[N][L]);
		}
	}

}
