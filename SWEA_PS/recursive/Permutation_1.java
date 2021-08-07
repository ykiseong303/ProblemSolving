package recursive_re;
/*
 * 중복순열 
 * 3개중에 2개를 뽑는데, 중복을 허용하는 경우 
 * 중복순열이므로 순서는 의미가 있지만 중복해서 뽑을 수도 있음 
 */
public class Permutation_1 {
	static int[] lst = {1,3,5};
	public static void main(String[] args) {
		perm(0,new int[2]);
	}
	private static void perm(int cnt, int[] sel) {
		if(cnt==sel.length) { // 전부 다 골랐을 때 출력하고 현재호출 종료 > 호출했던 곳으로 이동 
			for(int i=0;i<sel.length;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<lst.length;i++) {
			// 중복이 허용되므로 방문했는지 확인할 필요가 없음
			sel[cnt] = lst[i]; //현재 원소를 넣고 
			perm(cnt+1,sel); // 재귀호출 
		}
	}

}
