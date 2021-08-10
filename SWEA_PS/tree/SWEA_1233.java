package workshop_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제번호 : SWEA 1233 / 사칙연산 유효성검사 
 * 분류 : 자료구조(트리) 
 * 접근 : 리프노드의 끝부터 시작까지 부모 ~ 루트까지 탐색하며 연산자가 있는지 검사한다
 * 구현 : 1. 이진트리는 N개의 원소중 N/2개의 노드만 자식노드를 가질 수 있다.
 * 			> 따라서 이후 N/2+1 ~ N개까지는 리프노드임을 알 수 있다. 
 * 		 2. 현재위치가 i라 할 때, i/2를 통해 부모노드로 접근할 수 있다. (좌우 상관없음)
 */
public class SWEA_1233 {
	static String[] tree;
	static boolean flag;
	static String[] operator = {"+","-","*","/"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=1;tc<11;tc++) {
			flag = false;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			tree = new String[N+1];
			
			for(int i=1;i<=N/2;i++) { // 리프노드 직전까지만 값을 입력받음 
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				tree[i] =st.nextToken();
			}
			for(int i=N/2+1;i<N+1;i++) { // 리프노드만 값을 입력받음 
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				tree[i] = st.nextToken();
			}
			for(int i=N;i>N/2+1;i--) { // 리프노드의 끝에서부터 시작까지 탐색 
				flag = parentSearch(i); // 부모중 연산자가 하나라도 아닌게 있다면 false를 리
				if(flag==false) {
					System.out.printf("#%d 0\n",tc);
					break;
				}
			}
			if(flag==true) System.out.printf("#%d 1\n",tc);
			
		}
	}

	private static boolean parentSearch(int i) {
		boolean flag2 = true;
		L : while(true) {
			i = i/2;
			for(String op : operator) { // 연산자를 묶어놓은 배열 
				flag2 = false;
				// 하나라도 일치하는게 있다면 flag를 true, 그리고 다음 연산자확
				if(tree[i].equals(op)) { 
					flag2 = true;
					break;
				}
			}
			if (flag2==false) break L;
			if(i==1) break; // 루트노드까지 탐색하고, 루트노드에 도달했다면 
		}
		return flag2;
	}

}
