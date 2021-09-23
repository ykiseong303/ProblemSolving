package algo_ws_0920_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 번호 : 백준 1600 / 말이 되고픈 원숭이 
 * 분류 : k차원의 bfs
 * 접근 : 1. 말과 원숭이의 움직임 중 어떤 조합으로 해야 최소이동횟수인지 알 수 x
 * 		 > 모든 경우를 확인 > bfs로 접근 
 * 		 2. 현재 차원에서 말로 이동할 수 있는 경우라면 q에 말 이동가능까지 추가 
 */
public class boj_1600 {
	static int K, N, M;
	static int[][] shape;
	static int[] dx = {-1,1,0,0,-1,-2,-2,-1,1,2,2,1};
	static int[] dy = {0,0,-1,1,-2,-1,1,2,-2,-1,1,2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 K = Integer.parseInt(br.readLine());
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 M = Integer.parseInt(st.nextToken());
		 N = Integer.parseInt(st.nextToken());
		 
		 shape = new int[N][M];
		 
		 for(int i=0;i<N;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0;j<M;j++) {
				 shape[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 int res = bfs();
		 System.out.println(res);

	}
	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,0,0});
		boolean[][][] v = new boolean[N][M][K+1];
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int w = cur[2];
			int cnt = cur[3];
			
			if(x==N-1&&y==M-1) {
				return cnt;
			}
			
			// 말로 갈 수 있는 상태라면 12번을 체크 아니라면 4번만 
//			int m = w<K ? 12 : 4;
			for(int i=0;i<(w==K?4:12);i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nk = (i<4 ? w : w+1);
				if(0<=nx&&nx<N&&0<=ny&&ny<M&&shape[nx][ny]!=1&&!v[nx][ny][nk]) {
					v[nx][ny][nk] = true;
					q.add(new int[] {nx,ny,nk,cnt+1});
//					// i<4까지는 원숭이로만 이동 
//					if(i<4) {
//						v[nx][ny][w] = true;
//						q.add(new int[] {nx,ny,w,cnt+1});
//					} else {
//						v[nx][ny][w+1] = true;
//						q.add(new int[] {nx,ny,w+1,cnt+1});
//					}
					
				}
				
			}
			
		}
		
		return -1;

	}

}
