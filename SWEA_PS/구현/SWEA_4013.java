package algo_ws_0927_1001;

import java.util.Scanner;

/*
 * 문제번호 : SWEA 4013 / 특이한 자석 
 * 분류 : 구현 
 * 구현 : 1. 배열의 움직임 메소드 구현 
 * 		 2. 날이 맞물리는 부분
 * 			> 위, 아래 방향에 대해 조건이 안맞을 때까지 반복 
 */
public class SWEA_4013 {
	static int K, map[][], rot[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			K = sc.nextInt();
			map = new int[4][8];
			rot = new int[K][2];
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<8;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0;i<K;i++) {
				for(int j=0;j<2;j++) {
					rot[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<K;i++) {
				int[] flag = new int[4];
				// 시작위치에서 인접한 자석까지 비교
				int target = rot[i][0]-1;
				int up = rot[i][0]-1;
				int down = rot[i][0]-1;
				// 자기 돌아가는 것 체크
				if(rot[i][1]==1) {
					flag[rot[i][0]-1] = 1; 
				} else {
					flag[rot[i][0]-1] = -1;
				}
				while(true) { // 위쪽 먼저 비교 
					if(up==0) break;
					// 시작위치와 위에 값을 비교 
					up-=1;
					if(map[target][6]!=map[up][2]) {
						flag[up] = flag[target]*-1; 
					} else {
						break;
					}
					target -=1;
				}
				target = rot[i][0]-1;
				while(true) {
					if(down==3) break;
					down += 1;
					if(map[target][2]!=map[down][6]) {
						flag[down] = flag[target]*-1;
					} else {
						break;
					}
					target +=1;
				}
				for(int j=0;j<flag.length;j++) {
					rotation(j,flag[j]);
				}
//				System.out.println(Arrays.toString(flag));
//				print(map);
				
			}
			int index = 0;
			int sum = 0;
			for(int j=0;j<4;j++) {
				if(map[j][0]==1) {
					sum += Math.pow(2, j);
				}
				index +=1;
			}
			System.out.printf("#%d %d\n",tc,sum);
			
		}
	}
	
	
	private static void rotation(int r, int menu) {
		int temp[] = new int[8];
		switch (menu) { 
			case 1 : // 시계방향으로 회전 
				
				System.arraycopy(map[r],0,temp,1,7);
				temp[0] = map[r][7];
				map[r] = temp;
				break;
			case -1 : // 시계반대방향으로 회전 
				System.arraycopy(map[r],1,temp,0,7);
				temp[7] = map[r][0];
				map[r] = temp;
				break;
			case 0 : // 회전하지 않음 
				break;
		}
	}
	private static void print(int[][] map) {
		System.out.println("------------------");
		for(int i=0;i<4;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
		System.out.println("------------------");
	}

}
