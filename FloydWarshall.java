// 대표 문제 : BOJ 11404 G4 플로이드
// https://www.acmicpc.net/problem/11404

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*	플로이드 워셜 개요
 * 	
 * 	간선에 가중치가 있는 그래프에서
 * 	모든 정점 간의 최단경로를 구하는 알고리즘
 * */

public class FloydWarshall {

	static final int INF = Integer.MAX_VALUE / 10;
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());	// 정점의 개수
		int E = Integer.parseInt(br.readLine());	// 간선의 개수
		
		int[][] dp = new int[V + 1][V + 1];
		for (int i = 1; i < V + 1; i++) {
			Arrays.fill(dp[i], INF);	// 처음에는 모든 노드가 서로 도달불가 상태라고 가정하기
			dp[i][i] = 0;				// 자기 자신으로 가는 거리는 0
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());	// 출발 노드
			int B = Integer.parseInt(st.nextToken());	// 도착 노드
			int C = Integer.parseInt(st.nextToken());	// 가중치
			dp[A][B] = Math.min(dp[A][B], C);
		}
		
		
		
		// 2. 플로이드 워셜
		floydWarshall(V, E, dp);
		
		
		
		// 3. 출력
		System.out.print("  거리\t|");
		for (int i = 1; i < V + 1; i++)
			System.out.print(" 노드 " + i + "\t");
		System.out.println();
		for (int i = 1; i < V + 2; i++)
			System.out.print("-------\t");
		System.out.println();
		for (int i = 1; i < V + 1; i++) {
			System.out.print("  노드 " + i + "\t|");
			for (int j = 1; j < V + 1; j++)
				if (dp[i][j] == INF) System.out.print("도달불가\t");
				else System.out.print("  " + dp[i][j] + "\t");
			System.out.println();
		}
	}

	
	/*	매개변수
	 * 	- 정점의 개수가 V개
	 * 	- 간선의 개수가 E개
	 * 	- 노드 i에서 노드 j까지 최단거리는 dp[i][j]
	 * 
	 * 	return
	 * 	- 아무것도 반환하지 않는다.
	 * 	- 대신, 매개변수이자 참조변수인 dp가 결과값을 담고 있다.
	 * */
	private static void floydWarshall(int V, int E, int[][] dp) {
		
		for (int k = 1; k < V + 1; k++)
			for (int a = 1; a < V + 1; a++)
				for (int b = 1; b < V + 1; b++)
					dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k][b]);
	}

}
