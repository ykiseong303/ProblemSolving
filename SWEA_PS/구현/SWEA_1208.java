package workshop_0802_0806;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 문제번호 : SWEA 1208 / Flatten
 * 분류 : 정렬, 구현 
 * 일자 : 202.08.16
 * 접근 : 정렬 후, 맨앞과 맨뒤의 숫자를 연산한다 
 *   	 제한 횟수를 모두 채우고 나오는 경우 마지막에 한번 더 정렬해주는 것이 필요 
 */
public class SWEA_1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			ArrayList<Integer> q = new ArrayList<>();
			int N = sc.nextInt();
			for(int i=0;i<100;i++) {
				q.add(sc.nextInt());
			}
			boolean flag = false;
			while (N>0) {
				Collections.sort(q);
				int first = q.get(0);
				int last = q.get(99);
				int num = last - first;
				if(num<=1) {
					flag = true;
					System.out.printf("#%d %d\n",tc,num);
					break;
				}
				else {
					q.set(99, last-1);
					q.set(0,first+1);
				}
				N-=1;
			}
			Collections.sort(q);
			if (flag==false) System.out.printf("#%d %d\n",tc,q.get(99)-q.get(0));
		}
	}

}
