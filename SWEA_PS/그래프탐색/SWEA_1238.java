package workshop_0823_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node {
	int x;
	int depth;
	public Node(int x, int depth) {
		this.x = x;
		this.depth = depth;
	}
}
/*
 *  문제 번호 : SWEA 1238 / Contact
 *  분류 : 그래프탐색 
 *  일자 : 2021.08.23
 *  목적 : depth가 가장 큰 리프노드 들 중 최대값을 출력 
 *  접근 : 1. 간선정보를 인접리스트로 구현 
 *  	  2. bfs 혹은 dfs를 탐색
 *    		> bfs : 현재 노드, depth를 관리하는 Node 클래스를 생성, 큐에 append할 때마다 depth도 갱신
 *    	    > dfs : 재귀를 탈때마다, depth를 갱신 / 기저조건 도달시, 최대 depth 노드들의 값을 출력  
 *  	  
 */
public class SWEA_1238 {
	static ArrayList<Integer>[] adj_lst;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			Queue<Integer> temp = new LinkedList<>();
			int max_val = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				int a = Integer.parseInt(st.nextToken());
				temp.add(a);
				if(a>max_val) max_val = a;
			}
			adj_lst = new ArrayList[max_val+1];
			
			for(int i=1;i<adj_lst.length;i++) {
				adj_lst[i] = new ArrayList<>();
			}
			
			while(!temp.isEmpty()) {
				int v1 = temp.poll();
				int v2 = temp.poll();
				adj_lst[v1].add(v2);
			}
			
			// 인접리스트로 bfs수행 
			int res = bfs(V,max_val+1);
			System.out.printf("#%d %d\n",tc,res);
			
		}

	}
	private static int bfs(int V, int max_val) {
		boolean[] visited = new boolean[max_val];
		visited[V] = true;
		int res = Integer.MIN_VALUE;
		int max_depth = Integer.MIN_VALUE;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(V,0));
		
		while(!q.isEmpty()) {
			boolean flag = false;
			Node n = q.poll();
			int current = n.x;
			int depth = n.depth;
			
			for(int i=0;i<adj_lst[current].size();i++) {
				if(!visited[adj_lst[current].get(i)]) {
					flag = true;
					visited[adj_lst[current].get(i)] = true;
					q.add(new Node(adj_lst[current].get(i),depth+1));
				}	
			}
			if (flag==false) {
				if(depth > max_depth) res = Integer.MIN_VALUE;
				if(depth >= max_depth) {
//					System.out.println(current);
					max_depth = depth;
					res = Math.max(res,current);
				}
			}
		}
		return res;
		
	}

}
