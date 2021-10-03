package recursive_re;


/*
 * 3개의 수 중에서 2개를 고르는 순열
 * 순열은 순서가 의미가 있고, 중복을 허용하므로 
 * 현재 위치를 고른적이 있다면 다음 순서에서는 못 고르게 해야함 
 * 조합과 비슷할 수 있는데, 조합은 순서가 의미가 없기 때문에 다음번 부터는 아예못쓴다고 생각하면 됌  
 */
public class Permutation {
	static int[] lst = {1,3,5};
	
	public static void main(String[] args) { 
		boolean[] visited = new boolean[3];
		perm(0, new int[2],visited);
	}
	private static void perm(int cnt, int[] sel, boolean[] visited) {
		// 기저조건 
		if(cnt==sel.length) {// 다 골랐다면
			for(int i=0;i<sel.length;i++) {
				System.out.print(sel[i]+ " ");
			}
			System.out.println();
			return; // 재귀호출 종료 
		}
		
		for(int i=0;i<lst.length;i++) {
			if(visited[i]==false) { // 현재위치를 방문하지 않았다면 
				visited[i] = true; // 현재위치를 방문처리하고  
				sel[cnt] = lst[i]; // 현재위치의 값을 sel배열에 담는다, sel배열의 크기만큼 받아야하므로 인자는cnt
				perm(cnt+1,sel,visited); // 하나 선택하고 다음위치로 재귀호출 
				visited[i] = false; // 재귀호출이 종료되고 나서, 현재위치를 사용하지 않은 것으로 변경 
				
			}
		}
	}
	
}
