package com.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution20 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<T+1;tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] lst = new String[201];
			int start_index = 0;
			
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				for(int j=start_index;j<start_index+num;j++) lst[j] = s;
				
				start_index += num;
				
			}
			System.out.printf("#%d\n",tc);
			for(int i=0;i<start_index;i++) {
				if (i!=0 && i%10==0) System.out.print("\n");
				System.out.print(lst[i]);
			}
			System.out.printf("\n");
		}
	}

}
