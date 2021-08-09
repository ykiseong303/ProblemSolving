package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제번호 : SWEA_9229 / 한빈이와 Spot Mart
 * 목적 : 두개를 고를 때 한계값을 넘지 않는 최댓값 출력 
 * 접근 : 1. 조합 + 재귀호출 
 * 			- 중복되지 않는 것을 고르고, 둘의 합계가 한계를 넘지 않을때마다 갱신 
 * 
 */
public class SWEA_9229 {
	static int N,M,res;
	static int[] lst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			lst = new int[N];
			res = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) lst[i] = Integer.parseInt(st.nextToken());
			
			comb(0,0,0);
			if(res==0) System.out.printf("#%d -1\n",tc);
			else System.out.printf("#%d %d\n",tc,res);
		}
	}
	/**
	 * 조합 + 재귀호출 
	 * 
	 * @param cnt : 몇번 뽑았는지 세는 변수 
	 * @param start : 뽑으려는 index
	 * @param sum : 골랐을 때의 값의 합 
	 */
	private static void comb(int cnt, int start,int sum) {
		if(sum > M) return; // 개수와 상관없이 범위를 벗어나면 종료 
		if(cnt==2) { // 범위를 벗어나지 않고 두개를 다 골랐을 때 
			res = (res > sum) ? res : sum; // res를 갱신 
			return;
		}
		for(int i=start;i<N;i++) {
			comb(cnt+1,i+1,sum+lst[i]); // 현재값을 sum에 더해서 재귀호출 
		}
	}

}
