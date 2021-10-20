package workshop_0816_0820;

import java.util.Scanner;
/*
 * 문제번호 : 백준 3109 / 빵집 
 * 분류 : dfs(백트래킹) + 그리디 
 * 일자 : 2021.08.18
 * 접근 : 1. 첫 위치를 시작으로 깊이우선탐색 시작 
 * 		 2. 현 위치에서 더 이상 움직일 수 없다면 백트래킹 
 */
public class R_boj_3109 {
	static int R,C,cnt;
	static int target;
	static char[][]map;
	static int[]dx = {-1,0,1};
	static int[]dy = {1,1,1};  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		target = 0;
		for(int i=0;i<R;i++) {
			String str = sc.next();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int r = 0;r<R;r++) {
			if(target==R-1) break;
			dfs(r,0);
		}
		System.out.println(cnt);
		
		
	}
	private static boolean dfs(int r, int c) {
		if(c==C-1) {
			target = r;
			cnt+=1;
			print(map);
			return true;
		}
		for(int d=0;d<3;d++) {
			int nr = r+dx[d];
			int nc = c+dy[d];
			if(0<=nr&&nr<R&&0<=nc&&nc<C&&map[nr][nc]=='.') {
				map[nr][nc] = 'o';
				if(dfs(nr,nc)) return true;
				
//				return dfs(nr,nc);
			}
		}
		return false; // 다 돌고서도 도착하지 못한 경우 
	}
	
	private static void print(char[][] map2) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------");
	}
	
}
