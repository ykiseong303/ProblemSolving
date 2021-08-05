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
 * 		 조합
 * 		 1. 1~N가지를 다 뽑는 경우를 생각해야함 (nC1 ~ nCn까지 전부 확인하며 최댓값 갱신)
 * 		 2. 조합을 재귀로 구현하는 것은 중복을 피하기 위해 현재위치에서 바로 다음값을 인자로 보냄
 * 		 3. 재료의 점수와 칼로리를 담는 두개의 배열을 재귀로 넣어서 할 수도 있지만,
 * 			처음부터 합계를 계산하고 재귀 호출은 다음값을 주고 종료를 만나면 사용했던 값 지우기(인자확인이 불가하기 때문) 
 */
public class SWEA_5215 {
	static int[] score;
	static int[] kcal;
	static int N,limit,res;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 limit = Integer.parseInt(st.nextToken());
			 res = 0;
			 int sum1 = 0;
			 int sum2 = 0;
			 score = new int[N];
			 kcal = new int[N];
			 for(int i=0;i<N;i++) {
				 st = new StringTokenizer(br.readLine());
				 score[i] = Integer.parseInt(st.nextToken());
				 kcal[i] = Integer.parseInt(st.nextToken());
			 }
			 
			 for(int k=1;k<N+1;k++) { // 1 ~ N까지 뽑는 모든 경우를 확인하기 위해 loop
				 comb(0,0,k,sum1,sum2);
			 }
			 
			 System.out.printf("#%d %d\n",tc,res);
		}
	}
	private static void comb(int start,int cnt,int k,int sum1, int sum2) {
		if(cnt == k) { // 종료조건 
			if(sum2<=limit) {
				res = Math.max(res, sum1);
			}
			return;
		}
		for(int i=start;i<N;i++) {
			sum1 += score[i];
			sum2 += kcal[i];
			comb(i+1,cnt+1,k,sum1,sum2);
			sum1 -= score[i]; // 현재 골랐던 요소를 다시 돌려놓기 
			sum2 -= kcal[i];
		}
	}

}
