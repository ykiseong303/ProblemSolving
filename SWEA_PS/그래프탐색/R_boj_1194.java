package algo_ws_0920_0924;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제번호 : 백준 1194 / 달이 차오른다, 가자 
 * 분류 : bfs + 비트마스킹 
 * 접근 : 1. 열쇠를 갖고 있는 상태를 어떻게 표현할 것인지? 
 * 		    > 각각의 열쇠를 매번 사용할 수 있어야하므로, 일반적인 k차원의 방문배열은 
 * 		    > 딱 한가지의 상태밖에 나타낼 수 없음 
 * 		    > 비트마스킹을 사용해서 각각의 키를 가지고 있는 상태를 표현 
 * 		 2. 방문배열의 크기는 [N][M][1<<6]
 * 			> 키는 총 6개, 키와 문은 아스키코드 'a'/'A'를 빼서 사용하기 때문에 항상 0 ~ 5의 값을 가짐
 * 			> 이 6개의 값을 비트 이동연산자 1<<'key'로 사용하면 6가지의 키를 저장할 수 있기 때문에 
 * 			> 방문배열의 크기를 [1<<6]으로 지정 
 * 		 3. 어떤 출구든 도착만 하면 되므로 bfs를 이용 
 */
public class R_boj_1194 {
	static int N,M;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][][] v; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		v = new boolean[N][M][1<<6];
		
		int s = 0;
		int e = 0;
		for(int i=0;i<N;i++) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<temp.length;j++) {
				map[i][j] = temp[j];
				if(map[i][j]=='0') {
					s = i;
					e = j;
				}
				
			}
		}
		
		int res = bfs(s, e);
		System.out.println(res);
		
//		print(map);
	}
	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c,0,0}); 
		v[r][c][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int k = cur[2];
			int cnt = cur[3];
			System.out.println(x+" "+y+" "+k+" "+cnt);
			if(map[x][y]=='1') {
				return cnt;
			}
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nk = k;
				if(0<=nx&&nx<N&&0<=ny&&ny<M&&map[nx][ny]!='#'&&!v[nx][ny][nk]) {
					if('A'<=map[nx][ny]&&map[nx][ny]<='F') { // 문을 만나는 경우 
						System.out.println("door");
						if( (nk & (1<<map[nx][ny]-'A')) == 0 ) {
							// 키를 가지고 있지 않은 상태 
							continue;
						}
					}
 
					if('a'<=map[nx][ny]&&map[nx][ny]<='f') { // 키를 만나는 경우
						nk |= 1<<map[nx][ny]-'a';
						System.out.println(nk);
					}
					v[nx][ny][nk] = true;
					q.add(new int[] {nx,ny,nk, cnt+1});
				}
				
				
			}
		}
		return -1;
		
	}
	private static void print(char[][] map) {
		System.out.println("-----------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
		
	}

}
