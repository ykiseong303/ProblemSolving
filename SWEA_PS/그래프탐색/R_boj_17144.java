package algo_ws_0920_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제번호 : 백준 17144 / 미세먼지 안녕 !
 * 분류 : 큐 사이즈만큼 돌리는 bfs
 * 접근 : 1. 미세먼지의 확산	
 * 		 	> 모든 미세먼지의 확산은 동시에 일어난다	
 * 			>> 현재 큐에 가지고 있는 값으로만 확산이 이루어져야 함 
 * 			>> 확산될 양은 원래의 map에 적용 (그리고 현재위치의 값을 계산)
 * 		 2. 공기청정기 작동
 * 			> 배열돌리기
 * 			>> 현재위치에 다음 위치의 값을 넣기 
 * 		 3. 미세먼지를 탐색하고 다시 큐에 넣는 작업 
 * 			> 확산과 공기청정기 작동 후에 위치를 찾아 값을 넣기 
 */
public class R_boj_17144 {
	static int N, M, T;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int[] a1dx = {0,1,0,-1};
	static int[] a1dy = {1,0,-1,0};
	static int[] a2dx = {1,0,-1,0};
	static int[] a2dy = {0,1,0,-1};
	
	static int[][] shape;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		shape = new int[N][M];
		
		// 공기청정기 좌표 
		int[] air = new int[2];
		int index = 0;
		// 미세먼지 위치를 담기위한 리스트 생성 
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				shape[i][j] = Integer.parseInt(st.nextToken());
				if(shape[i][j]>4) {
					q.add(new int[] {i,j,shape[i][j]});
				}
				if(shape[i][j]==-1) {
					air[index] = i;
					index += 1;
				}
			}
			
		} 

		while(T>0) {
			
			// 1. 미세먼지 bfs (현재 큐에 들어있는 요소만큼만 수행)
			while(!q.isEmpty()) {
				
				int cur[] = q.poll();
				int x = cur[0];
				int y = cur[1];
				int w = cur[2];
				// 현재위치에서 확산이 가능한 방향의 수 count 
				int cnt = 0;
				int f = (int) Math.floor(w / 5);
				for(int i=0;i<4;i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(0<=nx&&nx<N&&0<=ny&&ny<M&&shape[nx][ny]!=-1) {
						 
						// 확산 가능한 위치에는 f만큼 더해주고 q에 위치 삽입 
						shape[nx][ny] += f;
						cnt +=1;
					}
				}
				// 현재위치는 현재값 - 현재값/5 * 방향의 수
				shape[x][y] -= (f*cnt);
				
			}
			
			
			
//			print(shape);
			
			// 2. 공기청정기 작동 
			// 위쪽부터 
			// 시작위치 기억 
			int temp = shape[0][0];
			int r = 0;
			int c = 0;
			int dir = 0;
			while(dir<4) {
				int nr = r+a1dx[dir];
				int nc = c+a1dy[dir];
				// 공기청정기 좌표는 무시
//				if(shape[r][c]==-1) continue;
				if(nr>=0&&nr<=air[0]&&nc>=0&&nc<M) {
					if(shape[nr][nc]==-1) {
						shape[r][c] = 0;
					} else {
						shape[r][c] = shape[nr][nc];
					}
					r = nr;
					c = nc;
				} else {
					dir ++;
				}
				
			}
			shape[air[0]][0] = -1;
			shape[1][0] = temp;
//			print(shape);
			temp = shape[air[1]][0];
			r = air[1];
			c = 0;
			dir = 0;
			while(dir<4) {
				int nr = r+a2dx[dir];
				int nc = c+a2dy[dir];
				if(air[1]<=nr&&nr<N&&nc>=0&&nc<M) {
					if(shape[nr][nc]==-1) {
						shape[r][c] = 0;
					} else {
						shape[r][c] = shape[nr][nc];
					}
					r = nr;
					c = nc;
				} else {
					dir ++;
				}
			}
			shape[air[1]][0] = -1;
			shape[air[1]][1] = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(shape[i][j]>4) q.add(new int[] {i,j,shape[i][j]});
				}
			}
			T-=1;
//			print(shape);
		}
		int sum = 0;
		 for(int i=0;i<N;i++) {
			 for(int j=0;j<M;j++) {
				 if(shape[i][j]==-1) continue;
				 sum += shape[i][j];
			 }
		 }
		 
		 System.out.println(sum);
	}
	private static void print(int[][] shape) {
		System.out.println("-------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(shape[i][j] +" ");
			}
			System.out.println();
		}
		
	}

}
