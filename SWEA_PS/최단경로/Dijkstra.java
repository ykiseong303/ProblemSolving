package workshop_0823_0827;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 0;
		int end = N-1;
		final int INF = Integer.MAX_VALUE;
		
		// 1. 방문여부, 최단거리 갱신하는 배열 생성
		// - 최단거리 배열은 INF로 초기화 
		// - 인접행렬 구현 
		
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		boolean[] visited = new boolean[N]; // 방문여부를 확인하는 배열 
		int[] distance = new int[N]; // 최단거리 갱신하는 배열 
		
		Arrays.fill(distance, INF);
		
		distance[start] = 0; // 시작위치는 0으로 시작
		
		// 2. 다익스트라 알고리즘 
		for(int i=0;i<N;i++) {
			// 3. 아직 방문하지 않고, distance배열 중 가장 작은 값을 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j=0;j<N;j++) {
				if(!visited[j]&&min > distance[j]) {
					min = distance[j];
					minVertex = j;
				}
			}
			// 4. 선택한 정점을 방문처리 
			visited[minVertex] = true;
			if(minVertex == end) break; //
			
			// 5. 아직 방문하지 않고, 현재 선택한 정점과 연결되어 있으며, 현재 비용보다 선택한 정점을 거쳐서 갈때 더 작은 경우 
			for(int j=0;j<N;j++) {
				if(!visited[j]&&map[minVertex][j]!=0&&distance[j] > min+map[minVertex][j]) {
					distance[j] = min+map[minVertex][j];
				}
			}
		}
		System.out.println(distance[end]);
	}

}
