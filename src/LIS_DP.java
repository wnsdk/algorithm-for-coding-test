// dp 버전
// 대표 문제 : BOJ 11053 S2 가장 긴 증가하는 부분 수열
// https://www.acmicpc.net/problem/11053

import java.util.Arrays;
import java.util.Scanner;

/*	가장 긴 증가하는 부분 수열
 * 	(LIS; Longest Increasing Subsequence)
 * 
 * 	동적 계획법을 이용한 풀이
 * */

public class LIS_DP {

	public static void main(String[] args) {
		
		// 1. 입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 수열의 길이
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		
		// 2. LIS (dp를 이용한 풀이)
		int ans = LIS(A);
		
		
		// 3. 출력
		System.out.println("가장 긴 증가하는 부분 수열의 길이 : " + ans);
	}

	
	/*	매개변수
	 * 	- 수열 A
	 * 	
	 * 	return
	 * 	- 수열 A의 가장 긴 증가하는 부분 수열의 길이
	 * */
	private static int LIS(int[] A) {
		
		// 동적테이블 : 각 원소를 끝으로하는 LIS값
		int[] dp = new int[A.length];
		Arrays.fill(dp, 1);
		
		
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < i; j++)
				if(A[j] < A[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);

		
		int length = 0;
		for (int i : dp)
			length = Math.max(length, i);
		
		return length;
	}

}