package algo_ws_0920_0924;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제번호 : 백준 17472 / 다리 만들기 2
 * 분류 : 최단경로 + MST
 * 접근 : 모든 섬을 연결하는 최단 경로 > MST를 유추 
 * 		 1. 각 섬을 정점, 이를 연결하는 다리를 간선으로 파악 
 * 			> 각각의 섬을 구분할 수 있도록 넘버링 
 * 			> 현재 섬에서 다른 섬으로 도착하도록 이동 
 * 			>> 도착한다면 정점간의 그래프 연결 
 *  	 2. 그래프가 완성되면 크루스칼 or 프림을 이용해서 MST 계산 
 *  	 3. 그래프의 인접행렬을 만들 때, 다리를 연결하는 최소비용으로 계속 갱신할 것이므로 max값으로 초기화 
 *  	 4. 프림을 사용할때, 현재 정점과 연결 여부를 확인해야 하므로 max값을 다시 0으로 초기화하는 작업 필요 
 */
public class R_boj_17472 {
	static int N, M, shape[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		shape = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				shape[i][j] = sc.nextInt();
			}
		}
		
		// 1. 각 섬에 대한 넘버링 (연결요소)
		int index = 2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(shape[i][j]==1) {
					numbering(i,j,index);
					index++;
				}
			}
		}
		// 2. 각 섬을 연결하는 다리를 만들기 (그래프 만들기)
		int V = index -2; // 정점의 수 
		adjMatrix = new int[V][V];
		for(int i=0;i<V;i++) {
			Arrays.fill(adjMatrix[i],Integer.MAX_VALUE);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(shape[i][j]>1) {
					make(i,j,shape[i][j]);
				}
			}
		}
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(adjMatrix[i][j]==Integer.MAX_VALUE) {
					adjMatrix[i][j] = 0;
				}
			}
		}
		int res = prim(V);
		System.out.println(res);

	}
	
	private static int prim(int V) {
		int sum = 0;
		
		int[] dist = new int[V];
		boolean[] isMst = new boolean[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		for(int i=0;i<V;i++) {
			
			int minIndex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<V;j++) {
				if(!isMst[j]&&dist[j]<min) {
					minIndex = j;
					min = dist[j];
				}
			}
			
			if(minIndex == -1) break; // 더 이상 정점에 연결할 수 없는 경우 (다 채우지 못했는데) 
			isMst[minIndex] = true;
			sum += min;
			
			for(int j=0;j<V;j++) {
				if(!isMst[j]&&adjMatrix[minIndex][j]!=0&&adjMatrix[minIndex][j]<dist[j]) {
					dist[j] = adjMatrix[minIndex][j];
				}
			}
			
		}
		boolean flag = false; 
		for(int i=0;i<V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				flag = true;
				break;
			}
		}
		
		return flag==true ? -1 : sum;
	}
	
	private static void make(int r, int c, int val) {

		int x = r;
		int y = c;
		int island = 0;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			int cnt = 0;
			
			while(0<=nx&&nx<N&&0<=ny&&ny<M&&shape[nx][ny]==0) { // 범위안에 있고, 진행방향이 바다인 경우만
				// 조건문에서의 nx, ny는 다음위치가 아니라 현재위치로 보는게 맞음 
				// 다음위치가 나와 다른 섬인 경우 
				nx += dx[i];
				ny += dy[i];
				cnt +=1;
				if(0<=nx&&nx<N&&0<=ny&&ny<M&&shape[nx][ny]!=0&&shape[nx][ny]!=val&&cnt>=2) {
					island = shape[nx][ny];
					if(cnt<adjMatrix[val-2][island-2]) {
						adjMatrix[val-2][island-2] = cnt; 
						adjMatrix[island-2][val-2] = cnt;
					}
				}
			}
		}
		
		
		
	}

	private static void numbering(int r, int c, int index) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		shape[r][c] = index;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx&&nx<N&&0<=ny&&ny<M&&shape[nx][ny] == 1) {
					shape[nx][ny] = index;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	
	private static void print(int[][] map) {
		System.out.println("-----------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
		
	}

}
