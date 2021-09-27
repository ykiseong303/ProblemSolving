package 월말평가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제번호 : 백준 1707 / 이분 그래프  
 * 목적 : 이분그래프 여부를 출력 
 * 접근 : 1. 현재 정점과 인접한 정점이 서로 다른 색으로 칠해지도록 설정 
 * 		 2. 인접한 정점 중 이미 방문한 정점이 있는데, 현재 정점의 색깔과 같다면 이분 그래프 x (모두 달라야함)
 * 		 3. 그래프의 관계가 항상 연결된 것만 주어지는 것이 아니므로, 모든 정점을 확인해야함 
 * 			>> 항상 연결관계가 있는 것만이 그래프가 아님, 특히 이 경우에는 다른 그룹으로 나누는 것이므로 모두 확인이 필요함 
 */
public class R_boj_1707 {
	static int V,E;
	static int[] v;
	static ArrayList<Integer>adjlist []; 
	static boolean flag;
	static boolean dfs_flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			// 인접리스트 생성
			adjlist = new ArrayList[V+1];
			v = new int[V+1];
			for(int i=0;i<=V;i++) {
				adjlist[i] = new ArrayList<>(); 
			}
			
			// 인접리스트의 값 입력하기 
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				adjlist[v1].add(v2);
				adjlist[v2].add(v1);
			}
			flag = false;
			for(int i=1;i<V+1;i++) {
				if(v[i]==0) {
					if(bfs(i)==true) {
						flag = true;
						break;
					}
				}
			}
//			for(int i=1;i<=V;i++) {
//				if(v[i]==0) {
//					if(dfs(i,2)== false) {
//						flag = true;
//						break;
//					}
//				}
//			}
			System.out.println(flag==false ? "YES" : "NO" );
		}
		
	}
	private static boolean dfs(int x, int color) {
		v[x] = color;
		for(int node : adjlist[x]) {
			if(v[node]==0) {
				if(!dfs(node, 5-color)) {
					return false;
				}
			} else if (v[node]==v[x]) {
				return false;
			}
		}
		return true;
	}
	private static boolean bfs(int x) {
		Queue<int[]> q = new LinkedList<>();
		// 2, 3으로 그래프 탐색 
		q.add(new int[] {x,2});
		v[x] = 2;
		boolean flag = false; 
		
		L : while(!q.isEmpty()) {
			int[] cur= q.poll();
			int node = cur[0];
			int color = cur[1];
//			System.out.println("node : "+ node);
			for(int node2 : adjlist[node]) {
				if(v[node2]==0) { // 아직 방문안한 정점이라면 
					v[node2] = 5 - color;
					q.add(new int[] {node2,5-color});
				} else if(v[node2]!=0&&v[node]==v[node2]) {
					flag = true;
					break L;
				}
			}
		}
		return flag;
		
	}

}
