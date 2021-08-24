package workshop_0823_0827;

import java.util.Scanner;

/*
 * 문제번호 : SWEA 3289 / 서로소 집합 
 * 분류 : 유니온파인드 
 * 일자 : 2021.08.24
 * 접근 : 유니온파인드 메서드를 구현하고, 각 정점들에 대해 이를 수행한다. 
 */
public class SWEA_3289 {
	static int N, M;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			// make-set 하고 
			make();
			// union, find 메서드 구현  
			for(int i=0;i<M;i++) {
				int com = sc.nextInt();
				int from = sc.nextInt();
				int to = sc.nextInt();
				switch(com) {
					case 0 : 
						union(from,to);
						break;
					case 1 :
						int r1 = find(from);
						int r2 = find(to);
						if(r1==r2) {
							sb.append(1);
						} else {
							sb.append(0);
						}
						break;
				}
			}
			System.out.printf("#%d %s\n",tc,sb);
			sb.delete(0, sb.length());
		}
	}
	private static void make() {
		parent = new int[N+1];
		for(int i=1;i<N+1;i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static boolean union(int num1, int num2) {
		int v1 = find(num1);
		int v2 = find(num2);
		if(v1==v2) return false;
		parent[v2] = v1;		
		
		return true;
	}

}
