package workshop_0802_0806;

import java.util.Scanner;

/*
 * 문제번호 : SWEA 12100 / Ladder1
 * 분류 : 구현(사방탐색)
 * 일자 : 2021.08.16
 * 접근 : 1. 양 옆에 길이 있으면 갈 수 있을때까지 이동
 */
public class SWEA_1210 {
	static int[] dy = {-1,1};
	static int[][] shape;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc=1;tc<=10;tc++) {
			int N = sc.nextInt();
			shape = new int[100][100];
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					shape[i][j] = sc.nextInt();
				}
			}
			
			
			for(int y=0;y<100;y++) {
				int f = y;
				int x = 0;
				if(shape[x][y]==0) continue;
				int ny = 0;
				while(x<100) {
					// 좌우에 길이 있는지 검사 
					if(0<=f+dy[0]&&f+dy[0]<100&&shape[x][f+dy[0]]==1) { // 왼쪽 
						ny = move(x,f,0);
						f= ny;
					} 
					else if ((0<=f+dy[1]&&f+dy[1]<100)&&shape[x][f+dy[1]]==1) { // 오른쪽 
						ny = move(x,f,1);
						f=ny;
					}
					x+=1;
				}
				x-=1;
				
				if(shape[x][ny]==2) {
					System.out.printf("#%d %d\n",tc,y);
				}
			}
		}
	}
	private static int move(int x, int y, int dir) {
		// 벽이나 0을 만날때까지 현재방향으로 이동 
		while(true) {
			int ny = y+dy[dir];
			if(ny<0||ny>=100||shape[x][ny]==0) break;
			y = ny;
		}
		return y;
	}

}
