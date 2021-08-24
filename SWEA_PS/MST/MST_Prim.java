package workshop_0823_0827;

import java.util.Scanner;

public class MST_Prim {
	static int[][]map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 1. 인접행렬 만들기
		// - 신장트리에 포함되었는지 확인하는 배열, 타 정점에서 자기 자신으로 올 수 있는 최소비용을 나타내는 배열 생성
		boolean[] isMst = new boolean[N];
		int[] minEdge = new int[N];
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE; // 초기값을 INF로 저장  
		}
		
		// 2. 임의의 정점을 선택하고 다음을 탐색할 준비 
		// - 최소비용 합계를 나타낼 변수, 임의의 정점 0을 선택 
		int res = 0; 
		minEdge[0] = 0; // 현재는 타 정점에서 정점 0으로 올 수 있는 최소비용은 0 (자기자신)
		
		
		// 3. N개의 정점 모두 신장트리에 포함될 수 있도록 탐색 시작 
		for(int i=0;i<N;i++) {
			
			// 4. 현재 신장트리에 포함x, 그 중에서 최소비용이 가장 작은 정점을 저장 
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j=0;j<N;j++) {
				if(!isMst[j]&&min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			System.out.println(minVertex);
			// 5. 선택된 정점을 신장트리에 포함시키고 최소비용을 합산  
			isMst[minVertex] = true;
			res += min;
			
			// 6. 아직 신장트리 포함x, 현재 선택된 정점과 연결되어 있으며,
			// 그런 정점들 중 현재 비용이 선택된 정점으로 갈 수 있는 비용보다 크다면 
			for(int j=0;j<N;j++) {
				if(!isMst[j]&&map[minVertex][j]!=0&&minEdge[j]>map[minVertex][j]) {
					// 7. 조건을 만족하는 정점들의 최소비용을 갱신
					minEdge[j] = map[minVertex][j];
				}
			}
		}
		System.out.println(res);
		
		
	}

}
