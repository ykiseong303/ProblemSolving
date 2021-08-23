package workshop_0823_0827;

import java.util.ArrayList;import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제번호 : 백준 1260 / DFS와 BFS
 * 분류 : 그래프 탐색 
 * 일자 : 2021.08.23
 * 접근 : 그래프를 인접리스트 혹은 인접행렬로 구현 후 탐색 
 */
public class boj_1260 {
	static ArrayList<Integer>[] adj_lst;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		adj_lst = new ArrayList[N+1];
		for(int i=1;i<adj_lst.length;i++) {
			adj_lst[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj_lst[x].add(y);
			adj_lst[y].add(x);
		}
		
		for(int i=1;i<adj_lst.length;i++) {
			Collections.sort(adj_lst[i]);
		}
		
		dfs(V,new boolean[N+1]);
		System.out.println();
		bfs(V);
		
	}
	private static void bfs(int V) {
		/*
		 * bfs 시작하면 할것 
		 * 1) 큐를 만들기 
		 * 2) 큐에다가 시작원소 넣기 
		 * 3) 시작원소를 방문처리 
		 * 4) 큐가 빌때까지 탐색 
		 * 		> 큐에 넣으면서, 바로 방문처리 
		 */
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N+1];
		q.add(V);
		v[V] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for(int i=0;i<adj_lst[x].size();i++) {
				if(!v[adj_lst[x].get(i)]) {
					q.add(adj_lst[x].get(i));
					v[adj_lst[x].get(i)] = true;
				}
			}
		}
		
	}
	private static void dfs(int V,boolean[]v) {
		/*
		 * dfs로 들어오면 할 것 
		 * 1) 현재위치를 방문처리한다 
		 * 2) 현재위치에서 방문할 수 있는 곳 탐색 
		 */
		
		
		System.out.print(V+" ");
		v[V] = true;
		
		for(int i=0;i<adj_lst[V].size();i++) {
			if(!v[adj_lst[V].get(i)]) {
				dfs(adj_lst[V].get(i),v);
			}
		}
		
	}

}
