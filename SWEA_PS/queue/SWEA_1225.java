package ssafy.im.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 번호 : SWEA_1225 / 암호생성기 
 * 목적 : 만들어지는 암호를 출력  
 * 접근 : 큐 
 */
public class SWEA_1225 {
	
	public static void main(String[] args) throws IOException {
		int T =1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (T<11) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> lst = new LinkedList<>();
			
			for(int i=0;i<8;i++) lst.add(Integer.parseInt(st.nextToken()));
//			Collections.reverse(lst);
			
			encode(lst);
			
			System.out.printf("#%d ",T);
			for(int i : lst) {
				System.out.print(i +" ");
			}
			System.out.println();
			T+=1;
		}
			
	}

	private static void encode(Queue<Integer> lst) {
		int index =1;
		int cnt =0;
		while(true) {
			if(cnt ==5) { // 사이클이 돌면 index, cnt를 초기화 
				index = 1;
				cnt = 0;
			}
			int N = lst.poll(); // 큐에서 하나 빼기 
//			System.out.println(N);
			int sub = N-index; // 뺀 값과 index를 계산 
			if(sub<=0) { // 0보다 작거나 같다면 0을 넣고 종료 
				lst.add(0);
				break;
			}
			lst.add(sub);
			index +=1;
			cnt +=1;
//			System.out.println(lst);
		}
		 
	}

}
