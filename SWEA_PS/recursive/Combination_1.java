package recursive_re;

/*
 * 3개 중 2개를 뽑는경우
 * 중복을 허용하는 중복조합 
 * 중복은 가능하지만 순서가 다르다고 다른 것으로 취급하지 않음 
 */
public class Combination_1 {
	static int[] lst= {1,3,5};
	public static void main(String[] args) {
		
		comb(0,0,new int[2]);
	}
	private static void comb(int cnt, int start, int[] sel) {
		
		if(cnt==sel.length) { //전부 뽑은 경우 
			for(int i=0;i<sel.length;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			
			return;
		}
		for(int i=start;i<lst.length;i++) {
			sel[cnt] = lst[i];
			comb(cnt+1,i,sel);
		}
	}
	
}
