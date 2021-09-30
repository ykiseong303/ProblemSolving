package algo_ws_0927_1001;

import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int x;
	int y;
	int w;
	public Point(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}
	@Override
	public int compareTo(Point o) {
		return Integer.compare(this.w, o.w);
	}
	
}
/*
 * 문제번호 : SWEA 1249 / 보급로 
 * 분류 : 다익스트라
 * 목적 : 시작위치에서 도착지까지 가는 경로 중, 소요 시간이 가장 짧은 경로의 시간 출력 
 * 접근 : 1. 최단 경로를 구하는 거지만, bfs로 접근하는 경우 항상 최적해를 보장하지않음 (가중치)
 * 		 2. 시작위치에서 도착지까지 가는 모든 길에 대한 최단 경로를 갱신해 간다면? 
 * 			> 다익스트라 
 * 		 3. 이차원 맵에서의 다익스트라는 우선순위큐를 사용 + 방문처리 필요 
 * 			> 방문처리를 해도 pq에서는 큐에 들어있는 원소 중 우선순위가 가장 빠른 원소부터 나오므로		
 * 			> 도착지에 가장 먼저 도착하는 원소가 가장 빨리 도착한 것 
 *  
 * 
 */
public class SWEA_1249 {
	static int N, map[][],res;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][]v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			v = new boolean[N][N];
			for(int i=0;i<N;i++) {
				String[] str = sc.next().split("");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			res = 0;
			res = dijkstra();
			System.out.printf("#%d %d\n",tc,res);
		}

	}

	private static int dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0,0,0));
		v[0][0] = true;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(p.x==N-1&&p.y==N-1) {
				return p.w;
			}
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(0<=nx&&nx<N&&0<=ny&&ny<N&&!v[nx][ny]) {
					v[nx][ny] = true;
					pq.add(new Point(nx,ny,p.w+map[nx][ny]));
				}
			}
		}
		return -1;
	}

}
