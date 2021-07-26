package sol_0726;

import java.util.Scanner;

public class SWEA7272 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] no = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
		char[] yes = {'A','D','O','P','Q','R'};
		
		int T = sc.nextInt();
		for(int tc=1;tc<T+1;tc++) {
			String a = sc.next();
			String b = sc.next();
			
			if(a.length()!=b.length()) {
				System.out.printf("#%d DIFF\n",tc);
				continue;
			}
			
			char[]aa = a.toCharArray();
			char[]bb = b.toCharArray();
			int[] check = new int[aa.length];
			
			for(int i=0;i<aa.length;i++) {
				 boolean aaa = false;
				 boolean bbb = false; 
				// 하나씩 꺼내서 어느배열에 포함되는지 확인 
				// 구멍 있는쪽이 편하니 그쪽으로 비교
				if (aa[i]=='B' && bb[i]!='B') {
//					System.out.println("escape B");
					check[i] = -1;
					break;
				} 
				else if (aa[i]!='B' && bb[i]=='B') {
//					System.out.println("escape B");
					check[i] = -1;
					break;
				} 
				for(int j=0;j<yes.length;j++) {
					if(aa[i]==yes[j]) 
						aaa = true;
				}
				for(int j=0;j<yes.length;j++) {
					if(bb[i]==yes[j]) 
						bbb = true;
				}
//				System.out.printf("aaa : "+aaa+ " bbb : "+bbb+"\n");
				if (aaa==bbb) {
					check[i] = 1;
				}
			}
			int sum = 0;
			for(int i=0;i<check.length;i++) {
				sum += check[i];
			}
			if (sum==check.length) {
				System.out.printf("#%d SAME\n", tc);
			} else System.out.printf("#%d DIFF\n", tc);
		
		
		}
	}

}
