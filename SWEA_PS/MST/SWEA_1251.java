package workshop_0823_0827;

import java.util.Arrays;
import java.util.Scanner;

class island {
	long x;
	long y;
	public island() {}
	public island(int x, int y) {
		this.x = x;
		this.y = y;
	} 
}
/*
 * 문제번호 : SWEA 1251 / 하나로 
 * 분류 : MST 
 * 일자 : 2021.08.25
 * 접근 : 1. 각 섬을 모두 연결시키는 인접행렬 구성 
 * 		 2. 구성된 인접행렬로 MST계산 (프림 or 크루스칼)
 */
public class SWEA_1251 {
	static island[] lst;
	static double[][] map;
	static int N;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt();
		 for(int tc=1;tc<=T;tc++) {
			 N = sc.nextInt(); // 정점의 수 
			 
			 // 정점을 저장하기 위한 리스트 생성 
			 lst = new island[N];
			 // 정점의 x,y좌표 저장 
			 for(int i=0;i<N;i++) lst[i] = new island();
			 for(int i=0;i<N;i++) lst[i].x = sc.nextLong();
			 for(int i=0;i<N;i++) lst[i].y = sc.nextLong();
			 double E = sc.nextDouble();
					 
					 
			 // 정점간 연결관계를 인접행렬로 표현 
			 // > 모두 연결되어 있다고 생각 
			 map = new double[N][N];
			 for(int i=0;i<N;i++) {
				 for(int j=0;j<N;j++) {
					 if(i==j) continue;
					 map[i][j] = calc(i,j);
				 }
			 }
			 
			 // MST구하기 
			 final double INF = Double.MAX_VALUE;
			 boolean[] visited = new boolean[N];
			 double[] dist = new double[N];
			 Arrays.fill(dist, INF);
			 dist[0] = 0.0;
			 double sum = 0;
			 
			 
			 for(int i=0;i<N;i++) {
				 
				 int minVertex = -1;
				 double min = Double.MAX_VALUE;
				 // 아직 방문하지 않고, 거리가 최소인 정점을 선택 
				 for(int j=0;j<N;j++) {
					 if(!visited[j]&&min>dist[j]) {
						 minVertex = j;
						 min = dist[j];
					 }
				 }
				 
				 // 선택된 정점을 방문처리하고 비용을 합산 
				 visited[minVertex] = true;
				 sum += min;
				 
				 // 아직 방문하지 않고, 현재 정점과 연결되어 있으며, 현재 정점으로 갈때 비용이 더 적은 경우
				 // 값들을 업데이트 
				 for(int j=0;j<N;j++) {
					 if(!visited[j]&&map[minVertex][j]!=0.0&&dist[j]>map[minVertex][j]) {
						 dist[j] = map[minVertex][j];
					 }
				 }
			 }
			 double res = sum*E;
			 System.out.printf("#%d %d\n",tc,(long) Math.round(res));
			 
			 
//			 print(map);
			 
 			 
		 }
	}
	private static void print(double[][] map) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static double calc(int i, int j) {
		return Math.pow(Math.abs(lst[i].x-lst[j].x),2) + Math.pow(Math.abs(lst[i].y-lst[j].y),2);
	}

}
