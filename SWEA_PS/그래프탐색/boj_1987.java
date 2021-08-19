package homework_0816_0820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

/*
 * 문제번호 : 백준 1987 / 알파벳 
 * 분류 : 재귀(DFS) + 백트래킹
 * 일자 : 2021.08.19
 * 접근 : 1. 한번 방문했던 곳은 다시 갈 수 없다? 
 * 			> 그 위치를 방문처리 
 * 		 2. 더 이상 전진할 수 없는 경우 ?
 * 			> 호출되었던 시점으로 리턴하는데 전진했던 곳을 다시 만날 수도 있으므로
 * 			> 전진했던 곳에 대한 방문처리를 없애주는 작업 필요 (백트래킹)
 * 		 3. 방문처리 어떻게? 
 * 			> 알파벳으로 값을 받아오니 아스키코드 변환 후 -65해서 0~25의 정수형으로 저장
 * 			> 방문처리도 int[26]의 정수형 배열로 처리 (인덱스 번호로)
 */
public class boj_1987 {
	static int[][] shape;
	static int[]v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int R,C,res=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		shape = new int[R][C];
		v = new int[26];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				shape[i][j] = str.charAt(j)-65; // 문자를 숫자로 저장 A => 0, B => 1... 
			}
		}
		
		v[shape[0][0]] = 1; // 첫 위치는 항상 방문할 수 있으므로 방문처리 
		dfs(0,0,1); // 첫 위치를 방문하고 시작하므로 1로 시작 
		System.out.println(res);
//		print(shape);
	}
	private static void dfs(int x, int y, int cnt) {
		
		res = res > cnt ? res : cnt; // 최대한 갈 수 있는 depth를 갱신 
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx&&nx<R&&0<=ny&&ny<C) {
				if(v[shape[nx][ny]]==0) { // 방문한적이 없다면 
					
					v[shape[nx][ny]] = 1; // 방문처리 해주고 
					dfs(nx,ny, cnt+1); // 다음위치로 재귀호출, depth +1   
					v[shape[nx][ny]] = 0; // 직전 재귀에서 모두 끝나고 돌아오면 방문했던 위치를 미방문처리 
				}
			}
		}
		
	}
	private static void print(int[][] shape2) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(shape[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
