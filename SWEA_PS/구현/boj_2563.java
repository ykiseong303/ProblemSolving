package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제번호 : 백준 2563 / 색종이 
 * 분류 : 구현 
 * 접근 : 각 색종이의 영역을 count한다
 * 		 중복되는 영역이라면 그 영역을 굳이 뺄 필요는 없음 ! 
 * 구현 : 1. 100*100의 영역을 만든다
 * 		 2. 각 색종이의 시작위치 ~ +10까지를 1로 채운다	
 * 		 3. 이차원 배열을 하나씩 탐색하며 1인 값만 카운트 해준다.
 * 		 
 * 		 배열을 0부터 채울때 좌표계에서 x,y좌표는 index와 동일하게 생각(나중에 다시 그려보면 앎) 
 * 
 */
public class boj_2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] s = new int[100][100]; // 100*100의 영역 만들기 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int a=x;a<x+10;a++) { // x지점부터 10칸까지 
				for(int b=y;b<y+10;b++) { // y지점부터 10칸까지 
					s[a][b] = 1; // 해당하는 영역을 1로 표기 
				}
			}
		}
		int cnt = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(s[i][j] == 1) cnt +=1; // 1로 표기한 값을 count 
			}
		}
		System.out.println(cnt);

	}

}
