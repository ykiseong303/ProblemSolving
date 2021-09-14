package algo_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제번호 : 백준 1018 / 체스판 다시 그리기
 * 분류 : 브루트포스 + 배열탐색 + 구현 
 * 일자 : 2021.08.12
 * 접근 : 1. M*N크기의 보드에서 8*8의 크기로 자를 수 있는 시작위치들을 구한다
 * 			> 0~N-8, 0~M-8까지의 범위가 8*8의 크기로 나눌 수 있는 시작위치들의 범위 
 * 		 2. shape의 복사 
 * 			> deepcopy 구현 
 * 		 3. 사방탐색
 * 			> 현재위치랑 다음위치랑 같다면 > 다음위치는 다른 값 > 칠하는 개수 +1
 * 		 4. 시작위치가 W,B두가지로 시작할 수 있으므로 두가지 경우 모두 찾기 
 * 		 5. result 갱신 
 */
public class boj_1018 {
	static String[][]shape;
	static int N,M,res;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shape = new String[N][M];
		
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<M;j++) {
				shape[i][j] = str[j];
			}
		}
		
		res = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int w = Integer.MAX_VALUE;
		
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				w = start(i,j,"W");
				b = start(i,j,"B"); 
				res = res<Math.min(w, b) ? res : Math.min(w, b);
			}
//			
		}
		System.out.println(res);
	}
	private static int start(int x, int y, String c) {
		String[][]copy = new String[8][8];
		int cnt = 0;
		boolean flag = false;
		boolean flag2 = false;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				copy[i][j] = shape[i+x][j+y];
			}
		}
		if(!copy[0][0].equals(c)) {
			cnt+=1;
			copy[0][0] = c;
		}
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				
				
				for(int d=0;d<4;d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					if(0<=nx&&nx<8&&0<=ny&&ny<8) {
						if(copy[i][j].equals(copy[nx][ny])) {
//							System.out.println("xy : "+copy[i][j]+ " nxny : "+copy[nx][ny]);
							if(copy[i][j].equals("B")) {
								copy[nx][ny] = "W";
							}
							else if(copy[i][j].equals("W")) {
								copy[nx][ny] = "B";
							}
							cnt +=1;
						}
					}
				}
				
			}
			
		}
//		for(int i=0;i<8;i++) {
//			for(int j=0;j<8;j++) {
//				System.out.print(copy[i][j]+" "); 
//			}
//			System.out.println();
//		}
		return cnt;
		
	}
	


}
