package workshop_0823_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
/*
 * 문제번호 : 백준 7576 / 토마토 
 * 분류 : 그래프탐색 (bfs)
 * 일자 : 2021.08.23
 * 접근 : 익은토마토를 큐에 모두 넣고 bfs를 수행 
 */
public class boj_7576 {
	static int N,M;
	static Queue<Tomato> t = new LinkedList<>();
	static int[][] shape;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		shape = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				shape[i][j] = Integer.parseInt(st.nextToken());
				if (shape[i][j]==1) t.add(new Tomato(i,j));
			}
		}
		
		bfs();
		int res=Integer.MIN_VALUE;
		boolean flag = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(shape[i][j]==0) {
					flag = true;
				}
				res = Math.max(res, shape[i][j]);
			}
		}
		if (flag == true ) System.out.println(-1);
		else System.out.println(res-1);
		
	}
	private static void bfs() {
		while (!t.isEmpty()) {
			Tomato temp = t.poll();
			int x = temp.x;
			int y = temp.y;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx&&nx<N&&0<=ny&&ny<M&&shape[nx][ny]==0) {
					shape[nx][ny] = shape[x][y]+1;
					t.add(new Tomato(nx,ny));
				}
			}
		}
		
	}

}
