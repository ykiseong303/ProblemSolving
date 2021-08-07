package recursive_re;
/*
 * 5개의 원소 중 부분집합을 만드는 경우 
 */
public class powerSet {
	static int[] lst = {1,2,3,4,5};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		powerset(0,new boolean[lst.length]);
	}
	private static void powerset(int cnt, boolean[] visited) {
		
		if(cnt==lst.length) {
			for(int i=0;i<lst.length;i++) {
				if(visited[i]) { // 골랐던 값만 출력 
					System.out.print(lst[i]+" ");
				} 
				else System.out.print("X "); // 고르지 않았다면 X를 출력 
			}
			System.out.println();
			return;
		}
		
		visited[cnt] = true; // 현재위치를 고르기
		powerset(cnt+1,visited); // 다음 위치로 이동 
		visited[cnt] = false; // 현재위치를 고르지 않기 
		powerset(cnt+1,visited);
	}

}
