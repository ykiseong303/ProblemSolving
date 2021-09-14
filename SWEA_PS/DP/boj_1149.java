package algo_ws_0913_0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 번호 : 백준 1149 / RGB거리 
 * 분류 : DP or BFS
 * 접근 : dp[i] = i번째 집까지의 각각 RGB에 대한 값 
 * 		 1. 최적 부분 구조를 이루는지? : 이전의 문제로 다음문제를 해결할 수 있음
 * 		 2. 부분중복 발생 : i번째의 값을 구하기 위해서 memo를 하지않으면 처음부터 같은 값을 반복계산해야 하는 경우 발생 
 * 
 * 		 3. 문제 조건에 맞추어서 최소값을 계속 갱신 
 */
public class boj_1149 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번째부터 갱신 시작 
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				
				if(j==0) {
					map[i][j] += Math.min(map[i-1][j+1], map[i-1][j+2]);
				} else if(j==1) {
					map[i][j] += Math.min(map[i-1][j-1], map[i-1][j+1]);
				} else {
					map[i][j] += Math.min(map[i-1][j-1], map[i-1][j-2]);
				}
			}
		}
		// 마지막 행의 최대값을 출력
		int min = Integer.MAX_VALUE;
		for(int num : map[N-1]) {
			min = Math.min(min, num);
		}
		System.out.println(min);
	}

}
