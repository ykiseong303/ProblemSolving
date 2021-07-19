package com.java.swea;

import java.util.Scanner;

public class Solution17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner( System.in);
			int T = sc.nextInt();
			sc.nextLine();
			for (int tc =1;tc<T+1;tc++) {
				String s = sc.next(); // 문자열을 입력받음
				int index = 1;
				int lst[] = {0,0,0,0,0,0,0,0,0,0};
				int start = Integer.parseInt(s);
//				System.out.println(s);
				while(true) { 
					
					// 문자열을 하나씩 끄집어내서 비교 
					for(int i=0;i<s.length();i++) {
//						System.out.println(s.charAt(i)-'0');
						if (lst[s.charAt(i)-'0'] == 0) lst[s.charAt(i)-'0']=1;
					}
					
					int check = 0;
					
					for (int number : lst) {
//						System.out.printf("%d ",number);
						check += number;
					}
//					System.out.printf("check : %d\n",check);
					if (check==10) {
						System.out.printf("#%d %d\n",tc,Integer.parseInt(s));
						break;
					
					}
					
					
					
					// 문자열을 정수로 변환
					int num = Integer.parseInt(s);
					// 2배 곱하기
					index += 1;
//					start *= index;
					num = start*index;
					// 곱해진 수를 다시 문자열로 변환 
					s = Integer.toString(num);
//					System.out.print(num+"\n");
			}
//			System.out.print(index-1);
		}
	}

}
