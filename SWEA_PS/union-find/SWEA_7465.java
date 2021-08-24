package homework_0823_0827;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 문제번호 : SWEA 7465 / 창용 마을 무리의 개수 
 * 분류 : 유니온파인드 
 * 일자 : 2021.08.24
 * 접근 : 입력받은대로 합집합을 구성한다
 * 		 입력을 정렬해서 union을 구성하거나 or 마지막에 모두 다시한번 find과정 필요 
 */
public class SWEA_7465 {
	static int N,M;
	static int[] parent;
	
	static void make() {
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
	}
	
	static int find (int x) {
		if (x == parent[x]) return x; 
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int rootA = find(x);
		int rootB = find(y);
		if(rootA==rootB) return;
		
		parent[rootB] = rootA;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			make();
			for(int i=0;i<M;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				union(from,to);
				
				 
			}
			for(int j=0;j<parent.length;j++) {
		    	find(j);
			}
			Arrays.sort(parent);
			int target = parent[1];
			int cnt = 1;
			for(int j=2;j<parent.length;j++) {
		    	if(target!=parent[j]) {
		    		cnt ++;
		    		target = parent[j];
		    	}
			}
			System.out.printf("#%d %d\n",tc,cnt);
			
			
		}
	
	}

}
