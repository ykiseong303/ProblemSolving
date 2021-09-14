package workshop_0830_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int to;
	int weight;
	public Node(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	// 우선순위 큐를 지정하기 위한 정렬기준 (가중치 오름차순)
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
	
}

/*
 * 문제번호 : 백준 17532 / 최단 경로 
 * 분류 : 다익스트라 + 우선순위 큐 + 인접리스
 * 일자 : 2021.08.30
 * 접근 : 1. 문제 조건에서 정점의 수는 최대 20000개 이므로, 인접리스트로 구현
 * 		 2. 인접리스트를 구현하기 위한 클래스 지정 
 * 		 3. 아직 방문하지 않은 정점 중 거리비용이 최소인 값을 찾기 위해 우선순위큐를 사용 
 * 			> 큐에서 한번씩 poll하면서, 방문 정점인지 아닌지 체크
 * 			>> 그러면 큐에는 방문하지 않은 정점들만 들어가게 됌 
 */
public class R_boj_17532 {
	static int V,E,K;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<Node> adjList[];
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 V = Integer.parseInt(st.nextToken());
		 E = Integer.parseInt(st.nextToken());
		 
		 st = new StringTokenizer(br.readLine());
		 K = Integer.parseInt(st.nextToken());
		 
		 // 1. 인접리스트 표현 
		 adjList = new ArrayList[V+1];
		 for(int i=1;i<=V;i++) {
			 adjList[i] = new ArrayList<Node>();
		 }
		 
		 for(int i=0;i<E;i++) {
			 st = new StringTokenizer(br.readLine());
			 int from = Integer.parseInt(st.nextToken());
			 int to = Integer.parseInt(st.nextToken());
			 int weight = Integer.parseInt(st.nextToken());
			 adjList[from].add(new Node(to,weight));
		 }
		 
		 // 2. 방문처리, 거리의 최소비용을 나타내는 배열 생성 
		 visited = new boolean[V+1];
		 dist = new int[V+1];
		 Arrays.fill(dist, Integer.MAX_VALUE);
		 dist[K] = 0; // 시작 정점을 0으로 처리 
		 
		 dijkstra(K);
		 
		 for(int i=1;i<V+1;i++) {
			 if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			 else System.out.println(dist[i]);
		 }
	}
	private static void dijkstra(int K) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(K,0));
		
		while(!pq.isEmpty()) {
			// 3. 우선순위 큐에서 가중치가 가장 작은 정점을 poll
			Node n = pq.poll();
			int current = n.to; // 현재 정점을 지정 
			
			if(visited[current]) continue; // 그런데, 방문한 정점이면 pass
			visited[current] = true; // 아니면 방문처리 
			
			// 현재 정점을 기준으로 연결된 정점을 하나씩 탐색
			for(Node node : adjList[current]) {
				// 선택한 정점에서 인접한 정점의 최소비용보다 
				// 선택한 정점을 거쳐서 가는 경우가 비용이 더 적다면 갱신 
				if(dist[node.to] > dist[current]+node.weight) {
					dist[node.to] = dist[current]+node.weight;
					// 거리를 갱신하고 우선순위 큐에 조건을 만족하는 인접 정점과, 갱신된 가중치를 append
					pq.add(new Node(node.to,dist[node.to]));
				}
			}
		}
		
	}

}
