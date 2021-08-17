package algo_0817;

import java.util.Scanner;

/*
 * 문제번호 : SWEA 1074 / 재미있는 오셀로 게임 
 * 분류 : 구현
 * 일자 : 2021.08.17
 * 접근 : 1. 8방탐색
 * 		 2. 돌을 자기걸로 바꿀 수 있는지 유효성검사 
 * 		 3. 돌을 자기걸로 변환시키는 과정
 */
public class SWEA_1074 {
	static int N;
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			
			map[N/2-1][N/2-1] = 2;
			map[N/2][N/2-1] = 1;
			map[N/2-1][N/2] = 1;
			map[N/2][N/2] = 2;
			
			for(int m = 0;m<M;m++) {
				int x = sc.nextInt()-1; 
				int y = sc.nextInt()-1;
				int z = sc.nextInt();
				int f_x = x;
				int f_y = y;
				for(int d=0;d<8;d++) {
	//				if(d==3) continue;
//					System.out.println("d : "+d);
//					System.out.println("x : "+x +" y : "+y);
//					System.out.println("map[x][y] : " + map[x][y]);
					int temp_x = x;
					int temp_y = y;
					int t_x = x;
					int t_y = y;
					
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(0<=nx&&nx<N&&0<=ny&&ny<N) {
						boolean flag = false;
						if(map[nx][ny]==0) continue;
						if(z!=map[nx][ny]) { // 돌을 놓은 곳과 8방에서 다른돌이 있다면
							int cnt = 0;
							while(true) {
								// 다른 돌을 만나거나 벽에 닿을 때까지 현재방향으로 반복 
								nx =temp_x+ dx[d];
								ny =temp_y+ dy[d];
//								System.out.println("nx : "+nx+" ny : "+ny);
								if(nx<0||nx>=N||ny<0||ny>=N||map[nx][ny]==0) {
									break;
								}
								if(map[nx][ny]==z) {
									flag = true;
									break;
								}
								temp_x = nx;
								temp_y = ny;
								cnt +=1;
							}
//							System.out.println("cnt : "+cnt);
							if(flag == true) {
//								map[t_x][t_y] = z;
								for(int i=0;i<cnt;i++) {
									t_x = t_x+dx[d];
									t_y = t_y+dy[d];
									map[t_x][t_y] = z;
//									System.out.println("t_x+dx[d] : "+t_x+" t_y+dy[d] : "+t_y);
								}
								
							}
						}
						
					}
				}
				map[f_x][f_y] = z; 
//				print(map);
				
			}
			int b=0;
			int w=0;
			for(int[]mbb : map) {
				for(int mm : mbb) {
					if(mm==2) w+=1;
					else if(mm==1) b+=1;
				}
			}
			System.out.printf("#%d %d %d\n",tc,b,w);
		}
		
	}
	private static void print(int[][] map) {
		System.out.println("---------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}

}
