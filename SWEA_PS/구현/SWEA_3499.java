package ssafy.im.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제번호 : SWEA_3499
 * 목적 : 주어진 방법에 따라 셔플해서 출력
 * 접근 : 입력크기에 따라 배열 크기를 나누기 
 * 		 배열두개의 인덱스를 따로 증가시키면서 출력 
 */
public class SWEA_3499 {
	static String[] sub1;
	static String[] sub2;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if (N%2==0) { // 짝수인 경우 
				sub1 = new String[N/2];
				sub2 = new String[N/2];
				
			} else { // 홀수인 경우 
				sub1 = new String[N/2+1];
				sub2 = new String[N/2];
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<sub1.length;i++) sub1[i] = st.nextToken();
			for(int i=0;i<sub2.length;i++) sub2[i] = st.nextToken();
			
			shuffle(sub1,sub2,tc);
		}
	}
	private static void shuffle(String[] sub1, String[] sub2,int tc) {
		String[] lst = new String[N];
		int index1 = 0;
		int index2 = 0;
		boolean flag = false;
		for(int i=0;i<N;i++) { //lst 배열에 셔플순서대로 값을 저장 
			if(N%2==1&&i==N-2) { // 홀수개인 경우, 임의로 채우고 종료 
				lst[i] = sub2[index2];
				lst[i+1] = sub1[index1];
				break;
			}
			if(!flag) {
				lst[i] = sub1[index1];
				flag = true;
				index1 +=1;
			}
			else {
				lst[i] = sub2[index2];
				flag = false;
				index2 +=1;
			}
			
		}
		System.out.printf("#%d ",tc);
		for(String s : lst) System.out.print(s+" ");
		System.out.println();
	}

}
