package recursive_re;

/* 
 * 조합 
 * 3개중에 2개를 조합으로 뽑는 경우 
 * 순서가 의미가 없고, 중복도 허용하지 않음 
 */
public class Combination {
	static int[] lst = {1,3,5};
	public static void main(String[] args) {
		
		comb(0,0,new int[2]);
	}
	private static void comb(int cnt, int start,int[] sel) {
		if(cnt==sel.length) { // 다 뽑았으면 종료 
			for(int i=0;i<sel.length;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if(start==lst.length) { // 다 고르지 않았는데, 리스트의 모든 원소를 확인한 경우 
			return;
		}
		sel[cnt] = lst[start]; // 현재위치의 원소를 담고 
		comb(cnt+1,start+1,sel); // 한개 뽑음, 다음위치를 인자로 재귀호출 
		comb(cnt,start+1,sel); // 위의 재귀호출이 종료되었을 때 뽑지 않은채로 다음위치를 인자로 재귀호출 
		
//		for(int i=start;i<lst.length;i++) { // 뽑기 시작하는 위치는 start에서부터 
//			sel[cnt] = lst[i];
//			// 중복을 허용하지 않도록, 다음 호출에서는 현재에서 한칸 뒤의 원소를 사용할 수 있도록
//			// 현재위치+1의 값을 start인자로 넘김 
//			comb(cnt+1,i+1,sel); 
//		}
	}

}
