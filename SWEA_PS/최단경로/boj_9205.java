package hw_algo_03_0916;

import java.util.Scanner;

/*
 * 문제번호 : 백준 9205 / 맥주마시면서 걸어가기
 * 분류 : 최단경로, bfs
 * 일자 : 2021.09.16
 * 접근 : 최단경로로 풀이 
 * 			> 플로이드 워셜 : 모든 정점에 대한 맨해튼 거리(갈 수 없다면 INF)를 구하고, 
 * 				           K번째를 거쳐서 갈 수 있는 최단 경로를 갱신
 * 		 bfs로 풀이	
 * 			> 시작위치에서 방문할 수 있는 정점을 큐에 넣고, 갱신  
 */
public class boj_9205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			// N+2개의 정점을 가지고 있음
			// 목적지에서 도착점까지의 최단거리(50m에 맥주 1병씩 마시는 1000m)가 1000이하가 된다면 가능
			int[][] map = new int[N+2][N+2];
			
			int INF = 1001;
			
			// map에 대해 초기화 진행 
			for(int i=0;i<N+2;i++) {
				for(int j=0;j<N+2;j++) {
					if(i==j) continue;
					map[i][j] = INF;
				}
			}
			
			// 정점간의 좌표 입력 
			int[][] temp = new int[N+2][2];
			temp[0][0] = sc.nextInt();
			temp[0][1] = sc.nextInt();
			for(int i=1;i<=N;i++) {
				temp[i][0] = sc.nextInt();
				temp[i][1] = sc.nextInt();
			}
			temp[N+1][0] = sc.nextInt();
			temp[N+1][1] = sc.nextInt();
			
			// 각 정점간에 연결 여부를 파악하기 위해 맨해튼 거리로 두 정점간 거리 계산
			
			for(int i=0;i<N+2;i++) {
				for(int j=0;j<N+2;j++) {
					if(i==j) continue;
					// 두 정점간 맨해튼 거리의 절대값을 계산해서 1000이하면 연결 
					int dist = Math.abs(temp[i][0] - temp[j][0]) + Math.abs(temp[i][1] - temp[j][1]);
					if(dist<=1000) {
						map[i][j] = 1;
					}
				}
			}
			
			// k번째를 거쳐서 모든 정점에서 모든 정점으로 갈 수 있는 최단거리 갱
			for(int k=0;k<N+2;k++) {
				for(int i=0;i<N+2;i++) {
					for(int j=0;j<N+2;j++) {
						if(i==j) continue;
						if(map[i][j] > map[i][k]+map[k][j]) {
							map[i][j] = map[i][k]+map[k][j];
						}
					}
				}
			}
			
			int res = map[0][N+1];
			System.out.println(res<1000 ? "happy" : "sad");
		}
	}

}
