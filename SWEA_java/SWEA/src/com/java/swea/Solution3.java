package com.java.swea;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub	
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		for (int i=1;i<T+1;i++) {
			int [] num = new int[10];
			for (int j=0;j<10;j++) num[j] = Integer.parseInt(sc.next());
			Arrays.sort(num);
			int sum = 0;
			for (int k=1;k<9;k++) sum += num[k];
			System.out.printf("#%d %.0f\n",i,(sum)/8.0);
		}
	}

}
