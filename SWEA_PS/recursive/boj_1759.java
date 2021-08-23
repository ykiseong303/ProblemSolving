package homework_0823_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 문제번호 : 백준 1759 / 암호 만들기 
 * 분류 : 브루트포스 + 조합 
 * 일자 : 2021.08.23
 * 접근 : 1. 오름차순으로 만들기 위해서는 ? 
 *  		 > 정렬
 *  	 	 > 정렬된 데이터를 조합으로 하면 알아서 오름차순으로만 선택  
 */
public class boj_1759 {
	static int L, C;
	static char[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		String s = br.readLine().replace(" ", "");
		arr = s.toCharArray();
		Arrays.sort(arr);
		
		comb(0,0,new char[L]);
	}
	private static void comb(int cnt, int start, char[]sel) {
		if(cnt == L) {
			// 조합이 다 만들어지면 자음 모음 cnt
			int mo = 0; 
			int ja = 0;
			for(int i=0;i<sel.length;i++) {
				if(sel[i]=='a'||sel[i]=='e'||sel[i]=='i'||sel[i]=='o'||sel[i]=='u') {
					mo+=1;
				}
				else {
					ja +=1;
				}
			}
			if(mo>=1&&ja>=2) {
				for(int i=0;i<sel.length;i++) {
					System.out.print(sel[i]);
					if(i==sel.length-1) System.out.println("");
				}
			}
			return;
		}
		for(int i=start;i<C;i++) {
			sel[cnt] = arr[i];
			comb(cnt+1,i+1,sel);
		}
		
	}

}
