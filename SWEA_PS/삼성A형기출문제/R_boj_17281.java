package SAM_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제번호 : 백준 17281 / 야구 
 * 분류 : 순열
 * 접근 : 1. 구현 문제는 문제를 잘 읽는다.
 * 			> 한번 순서가 정해지면 경기 중에는 타순을 변경할 수 없다.
 * 			>> 한번 정해진 순서로 N번의 이닝을 모두 끝내야 한다. 
 * 			>>> 순열의 경우의 수만큼 게임을 진행한다.(N이닝 전부)
 * 		 2. 선수마다 얻을 수 있는 결과가 다르므로 어떤 순서로 두는지에 따라 결과가 달라진다	
 * 			> 순열을 사용한다.
 * 		 3. 1번 선수는 항상 위치가 정해져 있으므로, N-1명의 선수만 순열을 구한다. 
 * 		 4. 순열 리스트에 들어가는 값이 어떤 값이어야 하는지?
 * 			> 순서가 들어가야 하는지, 선수 번호가 들어가야 하는지? 
 * 		 5. 게임 규칙에 따라 구현을 진행 
 */
public class R_boj_17281 {
	static int N, in[][],sel[], res;
	static boolean v[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		in = new int[N+1][10];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				in[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		v = new boolean[10];
		sel = new int[10];
		
		v[4] = true;
		sel[4] = 1;
		res = Integer.MIN_VALUE;
		perm(2);
		System.out.println(res);
		
	}
	private static void play() {
		int score = 0;
		int out;
		int start = 1;
		for(int i=1;i<=N;i++) { // N번의 이닝까지 게임시작
			out = 0;
			boolean[] g = new boolean[4];
			while(out!=3) {
				if(start==10) start = 1;
				int cur = in[i][sel[start]];
				
				if(cur==0) { // 아웃인 경우 
					out += 1;
					start += 1;
					continue;
				}
				
				if(cur==4) { // 홈런인 경우 
					// 주자가 있는지 확인
					int g_cnt = 0;
					for(int j=1;j<=3;j++) {
						if(g[j]) {
							g_cnt += 1;
							g[j] = false;
						}
					}
					score += g_cnt + 1;
					start += 1;
					continue;
				}
				
				for(int j=3;j>0;j--) {
					if(g[j]) {
						int cur_g = cur+j;
						if(cur_g>=4) {
							score += 1;
							g[j] = false;
							continue;
						}
						g[cur_g] = true;
						g[j] = false;
					}
				}
				g[cur] = true;
				start += 1;
				
			}
		}
		res = Math.max(score, res);
		
	}
	private static void perm(int num) {
		if(num == 10) {
			play();
			return;
		}

		for(int i=1;i<=9;i++) {
			if(!v[i]) {
				sel[i] = num;
				v[i] = true;
				perm(num+1);
				v[i] = false;
			}
		}
	}
}
