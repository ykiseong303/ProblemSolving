package hw_algo_05_0923;

import java.util.Scanner;

/*
 * 문제번호 : 정올 1681 / 해밀턴 순환회로
 * 분류 : 순열 (백트래킹)
 * 접근 : 1. 시작위치를 기준으로 
 * 		 2. 방문할 수 있는 노드들의 순열을 나타내기 
 * 		 3. 다른 경우를 위해 왔던 경로를 미방문처리하기 
 * 		 4. 기저조건 
 * 			> N-1개를 다 돌렸을 때, 마지막으로 기록된 노드에서 회사로 돌아갈 수 없는 경우는 return 
 * 			> 돌아갈 수 있다면, 해당 경로를 sum하고 min갱신 
 *		 5. 가지치기 
 *			> 현재 진행중인 재귀 스택에서 sum이 min보다 커진다면 return 
 */
public class jo_1681 {
	static int N;
	static long min;
	static int[][] map;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		min = Long.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		v = new boolean[N];
		v[0] = true; // 시작위치를 방문처리하고 시작 
		dfs(0,0,0);
		System.out.println(min);

	}
	
	// cnt : 몇번 돌렸는지, index : 현재 보고 있는 정점, sum : 현재까지의 합 
	private static void dfs(int cnt, int index, int sum) {
		if(sum > min) return; // 가지치기 
		if(cnt == N-1) { // 기저조건 
			if(map[index][0]==0) return; // 현재 정점에서 회사로 돌아갈 수 없는 경우 return 
			sum += map[index][0];
			min = Math.min(min, sum);
			return;
		}
		
		

		for(int i=0;i<N;i++) {
			if(!v[i]&&map[index][i]!=0) {
				v[i] = true;
				dfs(cnt+1,i,sum+map[index][i]);
				v[i] = false;
			}
		}
	}

}
