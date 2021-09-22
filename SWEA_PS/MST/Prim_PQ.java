package algo_ws_0920_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 문제번호 : 백준 1197 / 최소 스패닝트리 
 * 분류 : MST (우선순위큐 + 프림) 
 * 접근 : 1. 정점간의 연결을 인접리스트로 구현
 * 		 2. 임의의 시작정점을 기준으로 연결된 정점을 하나씩 pq에 넣기 
 * 		 3. pq에서 하나씩 poll해보며 이미 신장트리에 포함되어있는 정점인지 확인 
 * 			>> pq는 항상 우선순위가 가장높은 값이 root임을 이용  
 */
class Node implements Comparable<Node> {
	int vertex;
	int weight;
	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
	
	
}
public class Prim_PQ {
	static ArrayList<Node> lst[];
	static int V,E;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
			
		lst = new ArrayList[V+1];
		// 인접리스트 생성 
		for(int i=1;i<V+1;i++) {
			lst[i] = new ArrayList<Node>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from =Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 양방향 그래프 연결관계 표현 
			lst[from].add(new Node(to,weight));
			lst[to].add(new Node(from,weight));
		}
			
			
		int sum=0;
		sum = prim();
		System.out.println(sum);
		
	}
	private static int prim() {
		PriorityQueue<Node>pq = new PriorityQueue<>();
		boolean[] isMst = new boolean[V+1];
		int sum = 0;
		// 시작 점을 우선순위큐에 삽입 
		pq.add(new Node(1,0)); // 여기서는 1부터 시작 
		
		while (!pq.isEmpty()) { // 우선순위큐가 빌때까지 
			// 1. 큐에서 원소를 하나 빼고 
			Node node = pq.poll(); 
			// 2. 신장트리에 포함되어있는 정점이라면 continue 
			if(isMst[node.vertex]==true) {
				continue;
			}
			
			// 3. 선택된 정점을 방문처리하고 
			isMst[node.vertex]=true; 
			sum += node.weight;
			
			// 4. 선택된 정점과 연결된 정점 중, 아직 MST에 포함되지 않은 정점을 pq에 삽입 
			// 우선순위큐는 우선순위가 가장 높은 게 루트에 있기 때문에 
			// 같은 정점이 큐에 여러번 들어가도, 가중치가 가장 작은 값만 고려함
			// 중복된 정점은 isMST배열에 이미 true처리가 되었을 것이므로 69번 라인에서 걸러짐  
			for(Node nextNode : lst[node.vertex]) {
				if(isMst[nextNode.vertex]==false) {
					pq.add(new Node(nextNode.vertex,nextNode.weight));
				}
			}
		}
		return sum;
	}

}
