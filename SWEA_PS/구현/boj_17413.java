package ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제번호 : 백준 17413 / 단어뒤집기2 
 * 분류 : 구현 
 * 목적 : 태그가 아닌 곳만 뒤집어서 출력
 * 접근 : 스트링 빌더를 사용 (reverse) 
 * 구현 : >나 공백을 만나면 스트링빌더에 있던 값을 거꾸로 출력, 삭제
 * 		 태그일때 아닐때의 flag변수 구현 
 */
public class boj_17413 {
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[]str = br.readLine().split("");
		boolean tag = false;
		for(int i=0;i<str.length;i++) {
			if(str[i].equals("<")) {
				System.out.print(sb.reverse().toString());
				sb.delete(0, sb.length());
				System.out.print(str[i]);
				tag = true;
				continue;
			}
			if(str[i].equals(">")) {
				System.out.print(str[i]);
				tag = false;
				continue;
			}
			if(tag == true) {
				System.out.print(str[i]);
				continue;
			}
			if(str[i].equals(" ")&&tag==false) {
				System.out.print(sb.reverse().toString());
				System.out.print(" ");
				sb.delete(0, sb.length());
				continue;
			}
			if(tag == false) sb.append(str[i]);
			if(i==str.length-1 && tag == false) System.out.print(sb.reverse().toString());
		}
	
	}

}
