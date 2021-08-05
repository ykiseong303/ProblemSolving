package workshop_0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제번호 : SWEA 5215
 * 분류 : 재귀호출 
 * 목적 : Kcal 제한을 넘지 않는 한에서 최고의 점수 출력 
 * 접근 : N가지 재료에 대한 조합(순서의미x, 중복x)
 * 
 * 구현 : 부분집합과 조합으로 생각할 수 있음. 
 * 	 부분집합
 * 	 1. 현재위치를 고르고 재귀 호출 
 * 	 2. 종료조건을 만나면 직전호출로 돌아가서 고르지 않는 경우에 대해 재귀호출
 */
public class SWEA_5215_2 {
	static int[] score;
	static int[] kcal;
	static boolean[] visited;
	static int N,limit,res,sum1,sum2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 limit = Integer.parseInt(st.nextToken());
			 sum1 = 0;
			 sum2 = 0;
			 res = 0;
			 visited = new boolean[N];
			 score = new int[N];
			 kcal = new int[N];
			 for(int i=0;i<N;i++) {
				 st = new StringTokenizer(br.readLine());
				 score[i] = Integer.parseInt(st.nextToken());
				 kcal[i] = Integer.parseInt(st.nextToken());
			 }
			 powerSet(0,0);
			 System.out.printf("#%d %d\n",tc,res);
		}
	}
	private static void powerSet(int idx,int cnt) {
		
		if(cnt == N) { // 종료조건 
			int kcal_sum = 0;
			int score_sum = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]==true) { // 고른 요소들에 한해서만 
					kcal_sum += kcal[i]; // 각각의 합계를 계산 
					score_sum += score[i];
				}
			}
			if(kcal_sum<=limit) { // 제한 값을 초과하지 않는 범위에서 최댓값 갱신 
				res = Math.max(res, score_sum);
			} 
			return;
		}
		
		
		visited[idx] = true; // 현재위치를 고르는 경우 
		powerSet(idx+1,cnt+1); // 재귀호출 
		visited[idx] = false; // 현재위치를 고르지 않는 경우 
		powerSet(idx+1,cnt+1); // 재귀호출 
		
	}

}
