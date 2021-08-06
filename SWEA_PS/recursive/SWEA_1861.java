package ssafy.im.solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 문제번호 : SWEA_1861 / 정사각형 방 
 * 목적 : 최대 움직일 수 있는 위치와 이동횟수 출력 
 * 접근 : dfs + dp 
 * 구현 : 1. map의 모든 위치를 dfs한다 
 * 		 2. 현재위치가 방문한적이 없다면(dp테이블값이 1이 아니라면)
 * 			현재위치에서부터 사방을 탐색한다. (조건에 일치할때만)
 * 		    시작위치를 static으로 두고 탐색을 진행할 때마다 시작위치와 탐색위치의 dp를 갱신한다.
 * 		 3. 현재위치를 방문한적이 있다면 dp값을 리턴한다 
 * 		 4. 탐색을 종료하고 위치를 찾는다 
 */
public class SWEA_1861 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,f_x,f_y;
	static int[][] shape;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			shape = new int[N][N];
			dp = new int[N][N]; // dp 테이블 
			for(int i=0;i<N;i++) { // 2차원 map 입력 
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					
					shape[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = 1; // 그자리에만 있어도 1이될 수 있으므로 1로 초기화 
				}
			}
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					f_x = i; f_y = j; // 현재위치를 스태틱 변수에 저장 
					dfs(i,j); // dfs탐색 
				}
			}
			int res = 0;
			int max = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(max < dp[i][j]) { // dp값에 따라 갱신 
						res = shape[i][j];
						max = dp[i][j];
					}
					if(max == dp[i][j]) { // dp값이 같다면 
						if(shape[i][j] < res) { // shape의 작은 값으로 갱신 
							res = shape[i][j];
							max = dp[i][j];
						}
					}
				}
			}
			System.out.printf("#%d %d %d\n",tc,res,max);
//			for(int[]d : dp) {
//				for(int dd : d) {
//					System.out.print(dd+" ");
//				}
//				System.out.println();
//			}
		}
	}
	private static void dfs(int x, int y) {
		if(dp[x][y]!=1) { // 방문한적이 있다면 
			dp[f_x][f_y] = dp[x][y]+1; // 현재위치에서 움직이는 1회 + 이전의 최대 이동값 
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if((0<=nx&&nx<N) &&(0<=ny&&ny<N) && (shape[x][y] - shape[nx][ny] ==-1)) {
//				System.out.println("f_x : "+f_x+" f_y : " +f_y);
				dp[f_x][f_y] +=1; // 스태틱 위치의 값을 1증가 
				if(x!=f_x && y!=f_y) dp[x][y] +=1; // dfs 탐색하는데, 첫 호출이 아니라면 그 위치도 +1 
				dfs(nx,ny);
			}
		}
		
	}

}
