import java.util.Scanner;

/*
 * 문제번호 : SWEA 5125 / 햄버거 다이어트 
 * 분류 : DP 
 * 접근 : 1. d[i][w] = i번째 재료까지 고려했을 때, 현재 w에서의 점수의 최대 값 
 * 		 2. 칼로리의 최대치를 분할해서, i번째 재료까지 고려했을 때, 1부터 L까지의 경우를 저장하고 갱신 
 * 		 3. i번째 재료의 칼로리가 현재 최대칼로리(Wi)보다 작거나 같을 때, 
 * 			> i번째 재료를 포함하는경우, 포함하지 않는 경우 중 최대값을 선택 
 * 			>> i번째 재료를 포함한다면, i번째 재료의 점수 + 현재 최대 칼로리 - i번째 재료의 칼로리 까지의 d값 
 * 			>> 포함하지 않는다면, i-1번째의 현재 최대 칼로리 값으로 유지 
 * 			>>> 가능한 이유는, 이미 이전위치에서부터 각각의 위치는 최대값을 나타내는 것이 확실하기 때문에.
 * 		 
 */ 
public class DP3_KnapsackTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		 
		
		for(int i=1;i<N+1;i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
			
		}
		
		int[][] d = new int[N+1][W+1];
		for(int i=0;i<=N;i++) {
			for(int w= 0;w<=W;w++) {
				// 현재물건의 무게가, 지금 구하려고하는 w무게보다 작거나 같으면 
				// 가방에 담을 수 있다. 
				if(weights[i]<=w) { 
					// 직전 무게까지의 경우, 현재가치 + 직전 물건까지의 최적의 가치 
					d[i][w] = Math.max(d[i-1][w], profits[i]+d[i-1][w -weights[i]]);
				} else { // 해당 물건을 가방에 넣을 수 없다.
					d[i][w] = d[i-1][w]; // 담을 수 없다면 직전 물건까지의 경우가 최대가치 
				}
										
			}
		}
		System.out.println(d[N][W]);
	}

}
