package workshop_0823_0827;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Edge implements Comparable<Edge>{ // 간선의 정보를 담기위한 클래스 
	int from;
	int end;
	int weight;
	public Edge(int from, int end, int weight) {
		super();
		this.from = from;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) { // 정렬기준 생성 
		
		return Integer.compare(this.weight, o.weight);
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", end=" + end + ", weight=" + weight + "]";
	}
	
}

/*
 * 분류 : MST(최소신장트리)를 구하는 크루스칼 알고리즘 
 */
public class MST_Kruskal {
	static int[] parent;
	static ArrayList<Edge> list;
	static int N, M;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		 
		 // 1. 정점의 수만큼 대표자 집합을 만들기 
		 make();
		 
		 // 2. 간선 정보를 담을 객체와 간선리스트 만들기
		 list = new ArrayList<>();
		 
		 // 3. 간선의 정보를 입력받아서 저장하기 
		 for(int i=0;i<M;i++) {
			 int from = sc.nextInt();
			 int end = sc.nextInt();
			 int weight = sc.nextInt();
			 list.add(new Edge(from,end,weight));
		 }
		 
		 // 4. 간선리스트를 정렬하기 
		 Collections.sort(list);
//		 System.out.println(list.toString());
		 
		 
		 // 5. 가중치가 제일 작은 간선부터 추가하기 
		 // > 정점의 개수 -1개 까지 추가
		 int cnt = 0; // 간선 개수를 count하는 변수 
		 int sum = 0; // 최소비용을 합계하는 변수 
		 
		 
		 for(int i=0;i<list.size();i++) {
			 if(union(list.get(i).from,list.get(i).end)) { // union의 결과가 true인 경우만 
				 cnt ++;
				 sum += list.get(i).weight;
				 
			 }
			 if(cnt == N-1) break;
		 }
		 
		 System.out.println(sum+" "+cnt);
	}
	
	private static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static boolean union(int from, int end) {
		int rA = find(from);
		int rB = find(end);
		if(rA==rB) return false; 
		// from에 end를 연결
		parent[rA] = rB;
		return true;
	}



	private static void make() {
		parent = new int[N]; // 정점이 0부터 시작
		for(int i=0;i<N;i++) {
			parent[i] = i;
		}
	}

}
