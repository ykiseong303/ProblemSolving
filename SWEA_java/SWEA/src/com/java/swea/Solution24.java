package com.java.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution24 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] shape = new int[N][N];
			int[][] temp = new int[N][N];
			String[][] res = new String[N][3];
			// shape 입력받기
			for(int i=0;i<N;i++) { 
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<N;j++) {
					shape[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res_index_i = 0;
			int res_index_j = 0;
			for(int i=0;i<3;i++) {
				temp = turn(N,shape);
				
				for (int []datas : temp) {
					if (res_index_i == N) res_index_i = 0;
//					System.out.printf("res_index_i : %d res_index_j : %d\n",res_index_i,res_index_j);
					String s = "";
					for (int data : datas) {
						s+=Integer.toString(data);
					}
//					System.out.println(s);
					
					res[res_index_i][res_index_j] = s; 
					res_index_i +=1;
					
				}
				
				res_index_j += 1;
				shape = temp;
			}
			System.out.printf("#%d\n", tc);
			for (String[] r : res) {
				for(String rr : r) { 
					System.out.print(rr+" ");
				}
				System.out.print("\n");
			}
			
		}
	}

	private static int[][] turn(int N, int [][] shape) {
		// TODO Auto-generated method stub
		int index_i=0;
		int index_j=0;
		int[][] new_shape = new int[N][N];
		for(int j=0;j<N;j++) {
			for(int i=N-1;i>-1;i--) {
				
//				System.out.printf("i : %d j : %d\n",i,j);
				new_shape[index_i][index_j] = shape[i][j];
				index_j += 1;
				if (i==0) index_j = 0;
				
			}
//			if (j==N-1) index_i = 0;
			index_i += 1;
		}
		return new_shape;
	}

}
