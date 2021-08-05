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
 * 		 
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
		
		if(cnt == N) {
			int kcal_sum = 0;
			int score_sum = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]==true) {
					kcal_sum += kcal[i];
					score_sum += score[i];
				}
			}
			if(kcal_sum<=limit) {
				res = Math.max(res, score_sum);
			} 
			return;
		}
		
		
		visited[idx] = true;
		powerSet(idx+1,cnt+1);
		visited[idx] = false;
		powerSet(idx+1,cnt+1);
		
	}

}
