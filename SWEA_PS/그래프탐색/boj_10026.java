package homework_0823_0827;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Loc {
	int x;
	int y;
	public Loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
/*
 * 문제번호 : 백준 10026 / 적록색약 
 * 분류 : 그래프 탐색 
 * 일자 : 2021.08.25
 * 접근 : 1. 정상과 적록색약을 구분해서 bfs를 수행한다
 * 		 2. 이중 for문으로 완탐하되, 현재위치의 bfs값이 true일 때만 연결요소의 수를 count
 */
public class boj_10026 {
	static int N;
	static char[][]shape;
	static char[][]copy;
	static boolean flag;
	static int[]dx = {-1,1,0,0};
	static int[]dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		shape = new char[N][N];
		for(int i=0;i<N;i++) {
			char[] str = sc.next().toCharArray();
			for(int j=0;j<N;j++) { 
				shape[i][j] = str[j];
			}
		}
		
		copy = new char[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(shape[i][j]=='R') copy[i][j] ='G'; 
				else copy[i][j] = shape[i][j];
			}
		}
		int cnt1=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(bfs(i,j,shape[i][j],shape)) { 
					cnt1+=1;
				}
			}
		}
		int cnt2=0;
		flag = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(bfs(i,j,copy[i][j],copy)) { 
					cnt2+=1;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
//		print(shape);
	}

	private static boolean bfs(int x, int y, char value, char[][] temp) {
		if(temp[x][y]=='X') return false;
		else {
			Queue<Loc> q = new LinkedList<>();
			q.add(new Loc(x,y));
			char val = temp[x][y];
			temp[x][y] = 'X';
			
			while(!q.isEmpty()) {
				Loc l = q.poll();
				int r = l.x;
				int c = l.y;
				for(int i=0;i<4;i++) {
					int nx = r+dx[i];
					int ny = c+dy[i];
					if(0<=nx&&nx<N&&0<=ny&&ny<N&&temp[nx][ny]==val) {
						temp[nx][ny] = 'X';
						q.add(new Loc(nx,ny));
						
					}
				}
			}
				
			return true;
		}
		
	}
	
	
	private static void print(char[][] shape) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(shape[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
