package workshop_0816_0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제번호 : SWEA 1247 / 최적 경로 
 * 분류 : 순열 
 * 일자 : 2021.08.19
 * 접근 : 고객들의 주소로 만들 수 있는 순열을 만든다 
 */
public class R_swea_1247 {
	static loc com, home,map[];
	static int N,min;
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			com = new loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); // 회사 위치 
			home = new loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); // 집 위치 
			// 고객의 주소를 담을 배열 (loc 객체를 담을 수 있는 loc타입의 배열)
			map = new loc[N];
			min = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				map[i] = new loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			perm(0,0,0,com);
			System.out.printf("#%d %d\n",tc,min);
		}
	}
	/**
	 * 고객들의 위치를 순열로 뽑아내기 
	 * @param cnt 뽑은 횟수 
	 * @param total 현재 시점에서 뽑은 위치까지의 거리 합계 
	 * @param visit 방문체크 
	 * @param pre 직전 loc 객체
	 */
	private static void perm(int cnt, int total, int visit, loc pre) {
		if(total > min) { // 가지치기 : 합계가 이미 최소값을 넘어서는 경우 return;
			return;
		}
		if(cnt == N) { // 모두 다 뽑았으면 
			total += pre.calc(home); // 마지막(집)의 위치를 합산 
			min = min > total ? total : min; // 최솟값 갱신 
			return;
		}
		
		for(int i=0;i<N;i++) {
			if((visit&1<<i)==0) { // 방문한적이 없다면 
				// 현재 고객객체 loc와 직전 loc객체의 거리계산 값을 total에 합산
				// pre 자리에는 현재 고객 객체 loc를 줌으로써, 다음 호출에서 이를 pre로 사용할 수 있게 처리 
				perm(cnt+1, total+map[i].calc(pre),visit|1<<i,map[i]);
			}
		}
	}

}
class loc { // 각 위치들을 담는 객체 
	int x;
	int y;
	public loc(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int calc(loc l) {
		return Math.abs(this.x-l.x) + Math.abs(this.y-l.y);
	}
}
