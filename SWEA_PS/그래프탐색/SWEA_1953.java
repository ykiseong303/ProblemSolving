package hw_algo_08_0930;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제번호 : SWEA 1953 / 탈주범 검거 
 * 분류 : 그래프탐색 (bfs)
 * 접근 : 1. 시간당 1칸씩 움직일 수 있고, 갈 수 있는 경우의 수를 찾아야 하므로 bfs
 * 		 2. 현재위치에서 다음위치로 이동할 수 있는 곳 찾기 
 * 			>> 파이프의 방향을 고려해서 다음 위치 찾기 
 */
public class SWEA_1953 {
	static int N, M, K, map[][];
	static int[][] dx = {{},{-1,1,0,0},{1,-1},{0,0},{-1,0},{1,0},{1,0},{-1,0}};
	static int[][] dy = {{},{0,0,-1,1},{0,0},{-1,1},{0,1},{0,1},{0,-1},{0,-1}};
	static boolean[][] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][M];
			v = new boolean[N][M];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			bfs(sx,sy);
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(v[i][j]==true) cnt += 1;
				}
			}
			System.out.printf("#%d %d\n",tc,cnt);
		}

	}
	private static void bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		v[sx][sy] = true;
		q.add(new int[] {sx, sy, 1});
//		K -= 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int k = cur[2];
			if(k==K) break;
			
			
			int dir = map[x][y];
			for(int i=0;i<dx[dir].length;i++) {
				int nx = x+dx[dir][i];
				int ny = y+dy[dir][i];
				int comx = dx[dir][i];
				int comy = dy[dir][i];
				if(0<=nx&&nx<N&&0<=ny&&ny<M&&!v[nx][ny]&&map[nx][ny]!=0) {
					for(int j=0;j<dx[map[nx][ny]].length;j++) {
						int nnx = dx[map[nx][ny]][j];
						int nny = dy[map[nx][ny]][j];
						if(comx*-1 == nnx&& comy*-1==nny) {
							v[nx][ny] = true;
							q.add(new int[] {nx,ny,k+1});
						}
					}
				}
			}
		}
	}

}
