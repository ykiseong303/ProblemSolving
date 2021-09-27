package 월말평가;

import java.util.PriorityQueue;
import java.util.Scanner;

// 숫자 정보를 저장하기 위한 클래스 
class Number implements Comparable<Number> {
	int n; // 실제숫자 
	int s1; // 첫번째 숫자 우선순위 
	int s2; // 두번째 숫자 우선순위 
	public Number(int n, int s1, int s2) { // 생성자 
		this.n = n;
		this.s1 = s1;
		this.s2 = s2;      
	}
	@Override
	public int compareTo(Number o) { // 우선순위 큐 구현을 위한 정렬기준 생성 
		if(this.s1 == o.s1) { // 첫번째 우선순위가 같다면 두번째 우선순위로 return
			return Integer.compare(this.s2, o.s2);
		}
		return Integer.compare(this.s1, o.s1); // 첫번째 우선순위를 기준으로 오름차순 return 
	}
	
	
}
/*
 * 문제번호 : 백준 1755 / 숫자놀이 
 * 분류 : 우선순위큐 + 구현 
 * 접근 : 1. 각 숫자에 우선순위를 부여하고 
 * 		 2. 우선순위큐에 순위와 실제 값을 삽입		
 * 		 3. 숫자의 크기가 10이상인 경우 둘로 쪼개서 앞자리, 뒷자리별로 우선순위 적용 
 * 		 4. 10미만인 경우 원래 숫자의 우선순위를 앞에, 뒤에는 0을 부여 
 */
public class boj_1755 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] seq = {10,5,9,8,3,2,7,6,1,4}; // 각 숫자별 우선순위 부여 
		
		PriorityQueue<Number> pq = new PriorityQueue<>(); // 우선순위 큐 
		
		for(int i=N;i<=M;i++) { // N부터 M까지 탐색 
			// 숫자를 쪼개서 나온 합을 우선순위큐에 저장 
			if(i>=10) { // 10보다 큰 수는 둘을 쪼개서 수행 
				int num1 = i/10;
				int num2 = i%10;
				pq.add(new Number(i,seq[num1],seq[num2])); // 실제 값과 두개의 우선순위를 pq에 저장
			} else {
				pq.add(new Number(i,seq[i],0)); // 실제 값과 두개의 우선순위를 pq에 저장
			}
		}
		int index = 0;

		while(!pq.isEmpty()) { // 출력
			System.out.print(pq.poll().n+ " ");
			index ++;
			if(index%10==0) {
				System.out.println();
			}
		}
	}

}
