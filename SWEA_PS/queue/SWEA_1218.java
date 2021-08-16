package workshop_0802_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 문제번호 : SWEA 1218 / 괄호 짝짓기 
 * 분류 : 자료구조(스택)
 * 일자 : 2021.08.16
 * 접근 : 1. 입력받은 괄호를 순서대로 꺼내어서 연결되는 괄호가 있는지 확인
 * 		 2. 스택이 비어있는지 아닌지 확인 
 */
public class SWEA_1218 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 1;
		
		while(T<11) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = false;
			String[] str = br.readLine().split("");
			String s=null;
			Stack<String> stack = new Stack<>();
			
			for(int i=0;i<str.length;i++) {
				if(i==0) {
					stack.push(str[i]); // 초기값넣기
					continue;
				}
				if(!stack.isEmpty()) {
					s = stack.pop();
					if(s.equals("{")&&str[i].equals("}")) {
						s = null;
						continue;
					}
					else if (s.equals("(")&&str[i].equals(")")) {
						s = null;
						continue;
					}
					else if (s.equals("<")&&str[i].equals(">")) {
						s = null;
						continue;
					}
					else if (s.equals("[")&&str[i].equals("]")) {
						s = null;
						continue;
					}
				}
//				System.out.println(s);
				if(s!=null) stack.push(s);
				stack.push(str[i]);
			}
			
			if(stack.isEmpty()) flag = true; 
//			System.out.println(stack);
			System.out.printf("#%d %d\n", T, (flag==false ? 0 : 1));
			T += 1;
		}
	}

}
