package algo_ws_0913_0917;

import java.util.Scanner;

/*
 * 문제번호 : 백준 9095
 * 분류 : dp or bfs
 * 접근 : dp >
 * 			d[i] = i번째의 -1, -2, -3값이 존재하기 때문에 세가지 경우의 d값을 합해서 갱신	
 * 		 bfs > 
 * 		    1에서부터 +1, +2, +3 의 bfs를 수행해서 목표값 찾을 때마다 count +1
 * 			다만, 여기서는 큐의 원소가 목적지에 도착하면 소멸하기 때문에 방문처리 필요 x
 * 			또한 진행방향이 한곳이기 때문 
 * 
 */
public class boj_9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N = sc.nextInt();
			int[] d = new int[12];
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			
			for(int i=4;i<=N;i++) {
				d[i] = d[i-1] + d[i-2] + d[i-3];
			}
			System.out.println(d[N]);
		}
	}

}
