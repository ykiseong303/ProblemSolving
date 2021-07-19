package com.java.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputPractice {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// 1. 정수 > 문자열 입력받는 경우 
		
		// nextInt로 정수+\n을 입력받고
		// 정수는 N으로, 버퍼에는 분리자(개행문자)만 남긴다
		// int N = sc.nextInt(); 
		 
		// nextLine은 개행문자까지 입력을 받기 때문에 
		// 앞에서 nextInt()이후 버퍼에 남아있던 \n을 입력받고 
		// 별도의 입력과정이 진행되지 않고 명령이 종료된다.
		// String s = sc.nextLine();  
		// System.out.println(N+" "+s); // 입력받은 정수만 출력됨을 알 수 있다.
		
		// 1.1 그럼 해결책은?
		
		// 1) 임의로 nextInt()를 한번 더 실행시켜서 버퍼의 값을 없앤다.
		//	int N = sc.nextInt();
		//	sc.nextLine(); // 버퍼에 남아있는 개행문자 처리 
		//	String s = sc.nextLine();
		//	System.out.println(N+" "+s);
		
		// 2) next()를 사용한다. 
		//	단, next()는 개행문자, 탭 이전까지만 입력받기 때문에
		//	입력으로 ABC DE를 받으면, next()는 ABC까지만 입력받고 
		// 	버퍼에는 \tDE\n가 남게 된다. 
			
		//  next는 공백문자 앞까지, nextLine은 \n을 입력받을 때까지 
		//	String s = sc.next();
		//	System.out.println(N+" "+s);  
		//	System.out.println(sc.nextLine()); // next이후 버퍼에 남은 값을 확인할 수 있다.

		// --------------------------------------------------------------	
		// 2. 버퍼를 사용한 데이터 입력방법
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 버퍼리더는 엔터만을 경계로 입력값을 인식한다. 그러므로 별도의 split과정이 필요
		// 또한 모두 String으로 입력받기 때문에, 자료형에 맞는 파싱작업이 필요 
		//	int T = Integer.parseInt(br.readLine());
		//	String s = br.readLine();
		//	System.out.println(T+" "+s); // 띄어쓰기를 무시하고, 개행문자(엔터)를 받을때까지를 모두 입력받
			
		// 2.1 공백을 두고 여러개의 입력이 한번에 주어지는 경우
		// 	알고리즘 문제를 풀 때 주로 마주하게 될 유형인데,split과정을 수행하면 된다.
		//	String[] s = br.readLine().split(" ");
		//	for (int i=0;i<s.length;i++) System.out.println(s[i]);

		// 2.2 공백을 두고 숫자 데이터가 한번에 주어지는 경우 
		// 현재 생각나는 방법은 스트링으로 입력받은 배열의 길이만큼 정수형 배열을 선언하고
		// 정수배열에다 입력받은 스트링 배열을 Integer로 파싱 
		// 데이터의 길이 N개만큼 반복을 수행해야 하는데, 시간효율성에 문제가 없는지?
		// 더 나은 방법이 있는지? 계속 알아보기 
		//	String[] s = br.readLine().split(" ");
		//	int [] num = new int[s.length];
		//	for (int i=0;i<s.length;i++) num[i] = Integer.parseInt(s[i]);
		//	System.out.printf("s[0] + s[1] = %d",num[0]+num[1]);

		// 2.3 공백없이 데이터가 한번에 주어지는 경우 
		// ex) ABCD, 1234 등 
		// split옵션을 ""으로 주면 한칸씩 입력을 받음 
		//	String[] s = br.readLine().split("");
		//	System.out.print(Integer.parseInt(s[0])+Integer.parseInt(s[1]));

		// String[] s 형태의 스트링 배열은 스트링의 자료형을 여러개 가지는 배열로 해석할 수 있다.
		// 따라서 배열내부의 값은 모두 스트링 값이고, 각 원소(스트링)를 charAt으로 접근이 가능하다. 
		//	String[] s = {"AB","CD"};
		//	System.out.print(s[0].charAt(0)+s[0].charAt(1)+s[1].charAt(0)+s[1].charAt(1));
			
		// 3. StringTokenizer를 사용해서 '입력받은 문자열을 구분하기'
		//	버퍼리더 + split을 사용해도 되지만, 효율성에서 공백을 땡겨오는 StringTokenizer가 더 효율적이다.
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//  문자열을 입력받고 토큰으로 분리 (공백 기준)
		//  토큰 자체도 문자열이므로 원하는 자료형으로의 파싱이 필요 
		//	StringTokenizer st = new StringTokenizer(br.readLine());
		//  공백을 기준으로 분리된 토큰을 하나씩 가져오기 
		//	int num1 = Integer.parseInt(st.nextToken());
		//	int num2 = Integer.parseInt(st.nextToken());
		//	System.out.print(num1+num2);
		
		// 4. n개의 데이터를 공백을 기준으로 m번 입력받는 2차원 배열 데이터 만들기 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 선언과 동시에 한줄을 입력받음 
			StringTokenizer st = new StringTokenizer(br.readLine());
		//  행과 열의 개수를 입력받기 
			int N = Integer.parseInt(st.nextToken()); // 2 
			int M = Integer.parseInt(st.nextToken()); // 2
			int [][] shape = new int[N][M];
			
			for (int i=0;i<N;i++) {
		// 	줄바꿈을 해서 입력을 받으려면 
		//  스트링 입력을 새로 받고, 토큰을 새로 생성 
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<M;j++) {
					shape[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i=0;i<N;i++) {
				for (int j=0;j<M;j++) {
					System.out.print(shape[i][j] + " ");
				}
				System.out.print("\n");
			}
	}

}
