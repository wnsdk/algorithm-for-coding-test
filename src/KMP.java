// 대표 문제 : BOJ 1786 P5 찾기
// https://www.acmicpc.net/problem/1786

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*	KMP 개요
 * 
 * 	Text 문자열에서 Pattern 문자열이 일치하는 위치를 반환해주는 알고리즘
 * */

public class KMP {
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();	// Text
		char[] P = br.readLine().toCharArray();	// Pattern
		
		
		
		// 2. KMP
		ArrayList<Integer> list = KMP(T, P);
		
		
		
		// 3. 출력
		System.out.println("패턴이 일치한 개수\t: " + list.size());
		System.out.print("패턴이 시작하는 위치\t: ");
		for (int i : list) System.out.print(i + " ");
	}
	

	/*	매개변수
	 * 	- Text 문자 배열 T
	 * 	- Pattern 문자 배열 P
	 * 
	 * 	return
	 * 	: T에서 P가 일치할 때, 그 시작 위치 인덱스를 list에 담아 반환
	 * */
	private static ArrayList<Integer> KMP(char[] T, char[] P) {
		
		// 부분일치테이블 만들기
		int[] pi = new int[P.length];
		
		// i : 접미사 포인터 (1부터 시작: 첫글자 틀리면 0위치로 가야하므로.)
		// j : 접두사 포인터
	    for (int i = 1, j = 0; i < P.length; i++) {
	        while (j > 0 && P[i] != P[j])
	        	j = pi[j - 1]; 
	        
	        if (P[i] == P[j]) 
	        	pi[i] = ++j;
	    }
	    
	    
	    ArrayList<Integer> list = new ArrayList<Integer>();
		
		// t : 텍스트 포인터
		// p : 패턴 포인터 
		for (int t = 0, p = 0; t < T.length; ++t) { 
			
			while (p > 0 && T[t] != P[p]) 
				p = pi[p - 1]; 
			
			if (T[t] == P[p]) {
				// 마지막 패턴 문자까지 다 맞았다면 
				if(p == P.length - 1) { 
					list.add(t - p);  
					p = pi[p]; 
				}
				else
					p++;
			}
		}
		return list;
	}
}