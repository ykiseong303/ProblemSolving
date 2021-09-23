package algo_ws_0920_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제번호 : 백준 2206 / 벽 부수고 이동하기 
 * 분류 : k차원의 bfs 
 * 접근 : 벽을 부수고 갈 수 있는 상태와 그냥 갈 수 있는 상태를 구별하는 차원을 추가 
 * 		 bfs의 특성상, 제일 처음 도착한 큐의 원소가 최단, 최소를 나타낸다는 점을 이용 
 */
public class boj_2206 {
	static int N, M, shape[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		shape = new int[N][M];
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<M;j++) {
				shape[i][j] = Integer.parseInt(str[j]);
			}
		}
		int res = bfs();
		System.out.println(res);
//		print(shape);
	}
	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		int[][][] v = new int[N][M][2];
		v[0][0][0] = 1;
		
		q.add(new int[]{0,0,0});
		int status = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1] ;
			int w = cur[2];
			if(x==N-1&&y==M-1) {
				return v[x][y][w];
				
			}
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx&&nx<N&&0<=ny&&ny<M&&v[nx][ny][w]==0) {
					if(shape[nx][ny] == 1&&w==0) { // 벽을 만난 경우 + 벽을 부순적이 없다면 
						v[nx][ny][1] = v[x][y][w]+1;
						q.add(new int[] {nx,ny,1});
						
					} else if(shape[nx][ny] == 0) { // 빈 공간을 만난 경우 : 벽을 부수고 온 상태든 아니든 전부 가능 
						v[nx][ny][w] = v[x][y][w]+1;
						q.add(new int[] {nx,ny,w});
					}
					
				}
			}
		}
		
		
		return -1;
	}
	private static void print(int[][] map) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		
	}

}
