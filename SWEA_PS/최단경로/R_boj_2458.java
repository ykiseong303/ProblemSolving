package algo_ws_0927_1001;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 문제번호 : 백준 2458 / 키 순서 
 * 분류 : 플로이드 워셜 
 * 목적 : 키 순서를 알 수 있는 정점의 수를 출력
 * 접근 : 1. 본인의 순서를 알 수 있다는 것은 ? : 
 * 			> 본인 앞, 뒤에 몇명이 있는지 (전체-자신제외) 정확히 알고 있는 경우 
 * 		 2. 즉, 다른 정점을 거쳐서 나로 오는 경우, 나 자신에서 다른 정점으로 갈 수 있는 경우를 구한다
 * 			> 플로이드 워셜을 사용 
 * 		 3. 플로이드 워셜로 갈 수 있는지 여부를 다 구한후, 2번에 해당하는 경우가 N-1이 되는 정점만 count  
 */
public class R_boj_2458 {
	static int N, M, dist[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dist = new int[N+1][N+1];
		int INF = 987654321;
		for(int i=1;i<N+1;i++) {
			Arrays.fill(dist[i], INF);
		}
		for(int i=0;i<M;i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			dist[num1][num2] = 1;
		}
		
		for(int k=1;k<N+1;k++) {
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					if(dist[i][j] > dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
					}
				}
			}
		}
		int res = 0;
		for(int i=1;i<N+1;i++) {
			int count = 0;
			for(int j=1;j<N+1;j++) {
				if(dist[i][j]!=INF||dist[j][i]!=INF) {
					count +=1;
				}
			}
			if(count == N-1) {
				res +=1;
			}
		}
		System.out.println(res);
	}

}
