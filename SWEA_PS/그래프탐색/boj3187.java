package day1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제번호 : 백준 3187 / 양치기 꿍
 * 목적 : 양과 늑대가 살아남을 수 있는 수를 출력
 * 접근 : bfs
 * 구현 : 1. 방문처리 : 방문한 지역은 #으로 처리 (더 이상 방문 x)
 * 		 2. 탐색 : 탐색하면서 해당 연결요소에 양과 늑대의 수를 count
 * 		 3. 한번 탐색할 때마다 결과 갱신 
 */
public class boj3187 {
	static int N,M, S, W;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map  = new char[N][M];
		for (int i=0;i<N;i++) {
			char[] lst = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = lst[j];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!='#') {
					bfs(i,j);
//					print(map);
				}
			}
		}
		System.out.println(S +" "+ W);
//		print(map);
	}
	private static void bfs(int r, int c) {
		int s = 0;
		int w = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		if(map[r][c]=='k') s += 1;
		else if (map[r][c]=='v')w += 1;
		map[r][c] = '#';
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for (int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx&&nx<N&&0<=ny&&ny<M&&map[nx][ny]!='#') {
					if(map[nx][ny]=='k') {
						s += 1;
					} else if(map[nx][ny]=='v'){
						w += 1;
					}
					map[nx][ny] = '#';
					q.add(new int[] {nx, ny});
				}
			}
		}
		if(s>w) {
			S += s;
		} else {
			W += w;
		}
	}
	private static void print(char[][] map) {
		System.out.println("===================");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("===================");
	}

}
