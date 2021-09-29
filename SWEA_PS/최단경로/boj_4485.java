package algo_ws_0927_1001;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


class Point implements Comparable<Point>{
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
 * 문제번호 : 백준 4485 / 초록색 옷을 입은애가 젤다지?
 * 분류 : 다익스트라(우선순위큐), dp 
 * 접근 : 1. N이 최대 125까지 이므로 dfs(백트래킹)로는 불가 
 * 		 2. dp는 하향식 방식으로 접근 (좀 더 수정해보기)
 * 		 3. 다익스트라
 * 			> 각 위치에서 인접한 정점을 모두 pq에 삽입
 * 			> pq에서 w가 가장 작은 정점을 계속 poll
 * 			> bfs의 특성에 따라 가장 먼저 도착한 시점이 최소 비용 거리임을 알 수 있음 
 */
public class boj_4485 {
	static int N, map[][],res, dp[][];
	static boolean[][] v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = 1;
		while(true) {
			N = sc.nextInt();
			if(N==0) break;
			
			map = new int[N][N];
			v = new boolean[N][N];
			dp = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			v[0][0] = true;
			for(int i=0;i<N;i++) {
				Arrays.fill(dp[i], 987654321);
			}
			dijkstra(0,0);
			System.out.printf("Problem %d: %d\n",index,res);
			index +=1;
		}

	}
	
	
	
	
	
	private static int dijkstra(int r, int c) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(r,c,map[r][c]));
		v[r][c] = true;
		while(!pq.isEmpty()) {
			Point p = pq.poll(); 
//			System.out.println(p.x+" "+p.y+" "+p.w+" "+p.sum);
			if(p.x==N-1&&p.y==N-1) {
				res = p.w;
				break;
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





	private static int solve(int r, int c) {
		if(r==N-1&&c==N-1) {
			return map[r][c];
		}
		if(dp[r][c]!=987654321) return dp[r][c];
		
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			if(0<=nx&&nx<N&&0<=ny&&ny<N&&!v[nx][ny]) {
//				System.out.println("YES");
				v[nx][ny] = true;
				dp[r][c] = Math.min(dp[r][c],map[r][c] + solve(nx,ny));
				v[nx][ny] = false;
			}
		}
		return dp[r][c];
	} 
	
	
	
	
	
	private static void dfs(int r, int c, int sum) {
//		v[r][c] = true;
		if(sum > res) return;
		if(r==N-1&&c==N-1) {
			sum += map[N-1][N-1];
			res = Math.min(res,sum);
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			if(0<=nx&&nx<N&&0<=ny&&ny<N&&!v[nx][ny]) {
				v[nx][ny] = true;
				dfs(nx,ny,sum+map[r][c]);
				v[nx][ny] = false;
			}
		}
		
	}

}
