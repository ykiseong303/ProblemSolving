package SAM_A;

import java.util.Scanner;

/*
 * 문제 번호 : 백준 16637 / 괄호 추가하기 
 * 분류 : 브루트포스, dfs(부분집합 : 백트래킹)
 * 접근 : 1. 시작위치에서 다음 값과 괄호를 넣을 것인지,
 * 		    다음값과 다다음 값의 계산 결과를 괄호로 추가할 것인지에 대해 
 * 		    부분집합을 적용
 *    	 2. 모든 경우에 대해 확인이 필요(괄호를 추가하느냐 안하느냐)
 *       3. 음수 * 음수로 최대값이 만들어 질 수 있기 때문에, 항상 최대값을 찾는 dp로는 불가   
 */
public class R_boj_16637 {
	static int N,L,res;
	static String[] str;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = N/2+1;
		str = sc.next().split("");
		num = new int[N];
		for(int i=0;i<N;i+=2) {
			num[i] = Integer.parseInt(str[i]);
		}
		res = Integer.MIN_VALUE;
		powerSet(0,num[0]);
		System.out.println(res);
	}
	private static void powerSet(int idx, int pre) {
		if(idx==N-1) {
			res = Math.max(res, pre);
			return;
		}
		int sum = cal(pre,str[idx+1],num[idx+2]);
		powerSet(idx+2,sum);
		if(idx+4<=N-1) {
		int sub = cal(num[idx+2],str[idx+3],num[idx+4]);
		sum = cal(pre,str[idx+1],sub);
			powerSet(idx+4,sum);
		}
	}
	private static int cal(int a, String op, int b) {
		if(op.equals("+")) {
			return a+b;
		} else if(op.equals("-")) {
			return a-b;
		} else {
			return a*b;
		}
	}

}

