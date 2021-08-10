package workshop_0810;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제번호 : 백준 1158 / 오세푸스 
 * 분류 : 자료구조 (큐)
 * 접근 : K번째마다 값을 빼야한다면 K-1번째까지는 다시 뒤로 넘겨주면 된다 
 */
public class boj_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int c = K;
		Queue<Integer> q = new LinkedList<>(); // 데이터를 담을 큐 생성 
		for(int i=1;i<N+1;i++) {
			q.add(i); // 처음에는 1~N까지의 값을 저장 
		}
		sb.append("<");
		while (!q.isEmpty()) { // 큐가 비어 있을때까지 
			for(int i=0;i<K-1;i++) { //K-1번째까지 
				q.add(q.poll()); // 데이터를 poll하고 다시 뒤로 offer 
			}
			sb.append(q.poll()).append(", "); // K번째 값을 poll
			// 이와 같은 과정을 큐가 빌때까지 반
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}
