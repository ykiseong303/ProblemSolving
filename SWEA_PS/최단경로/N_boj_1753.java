package workshop_0830_0903;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제번호 : 백준 1753 / 최단경로
 * 분류 : 다익스트라 + 우선순위큐
 * 일자 : 2021.08.30
 * 접근 : 1. 한 정점에서 모든 정점을 방문하는 최단경로 > 다익스트라 
 * 		 2. 정점과 간선의 수가 많을 때 > 인접행렬 or 인접리스트 or 간선리스트 
 * 		 3. 방문하지 않은 정점 중 거리가 최소비용인 값을 찾을때는 우선순위큐로 구현 필요 
 */
public class N_boj_1753 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int K = sc.nextInt();
		int end = V;
		// 0. 인접행렬
		int[][] adjMatrix = new int[V+1][V+1];
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			adjMatrix[from][to] = weight;
		}
		
		
		// 1. 방문처리, 최소비용을 나타낼 배열 생성 
		boolean[]visited = new boolean[V+1];
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 시작위치를 dist 0으로 지정 
		dist[K] = 0;
		
		// 시작위치를 기준으로 다익스트라 시작
		for(int i=0;i<V;i++) {
			// 2. 아직 방문하지 않고, 거리가 제일 작은 정점을 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j=1;j<V+1;j++) {
				if(!visited[j]&&min > dist[j]) {
					min = dist[j];
					minVertex = j;
				}
			}
			
//			System.out.println(minVertex +" "+min);
			// 3. 현재위치를 방문처리
			if(minVertex == -1) continue;
			visited[minVertex] = true;
			
			// 4. 선택된 정점을 거쳐서 갈 수 있는 경우의 비용을 갱신
			for(int j=1;j<V+1;j++) {
				if(!visited[j]&&adjMatrix[minVertex][j]!=0&&dist[j]>adjMatrix[minVertex][j]+min) {
					dist[j] = adjMatrix[minVertex][j] + min;
				}
			}
		}
		for(int i=1;i<dist.length;i++) {
			if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
	}

}
