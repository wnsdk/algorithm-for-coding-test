// 이분탐색 버전
// 대표 문제 : BOJ 11053 S2 가장 긴 증가하는 부분 수열
// https://www.acmicpc.net/problem/11053

import java.util.Arrays;
import java.util.Scanner;

/*	가장 긴 증가하는 부분 수열
 * 	(LIS; Longest Increasing Subsequence)
 * 
 * 	이분탐색(Binary Search)을 이용한 풀이
 * 	속도가 더 빠르다.
 * */

public class LIS_BS {

	public static void main(String[] args) {
		
		// 1. 입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 수열의 크기
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		
		
		// 2. LIS (이분탐색을 이용한 풀이)
		int ans = LIS(A);
		
		
		
		// 3. 출력
		System.out.println("가장 긴 증가하는 부분 수열의 길이 : " + ans);
	}

	private static int LIS(int[] A) {
		
		int[] dp = new int[A.length]; // 동적테이블 dp[k] : 해당(k) 길이를 만족하는 자리(k자리)에 오는 수의 최소값 
		int size = 0;
		
		for (int i = 0; i < A.length; i++) {
			int pos = Arrays.binarySearch(dp, 0, size, A[i]);
			if (pos >= 0) continue;
			
			int insertPos = Math.abs(pos) - 1; // 맨뒤 또는 기존원소 대체자리
			dp[insertPos] = A[i];
			
			if (insertPos == size) size++;
		}

		return size;
	}

}