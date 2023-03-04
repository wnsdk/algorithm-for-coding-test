// 대표 문제 : BOJ 1753 G4 최단경로
// https://www.acmicpc.net/problem/1753

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*	다익스트라 개요
 * 	
 * 	간선에 가중치가 있는 그래프에서
 * 	특정 시작 정점으로부터 나머지 모든 정점들로 가는 최단경로를 구하는 알고리즘
 * */

public class Dijkstra {

	static final int INF = Integer.MAX_VALUE / 10;
	
	static class Edge {
		int vertex;
		int weight;
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());	// 정점의 개수
		int E = Integer.parseInt(st.nextToken());	// 간선의 개수
		int S = Integer.parseInt(br.readLine());	// 시작 정점 번호
		
		List<Edge>[] adj = new ArrayList[V + 1];	// 그래프 연결 정보 adj[x]		
		for (int i = 1; i < V + 1; i++)
			adj[i] = new ArrayList<>();
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());	// 출발 노드
			int B = Integer.parseInt(st.nextToken());	// 도착 노드
			int C = Integer.parseInt(st.nextToken());	// 가중치
			adj[A].add(new Edge(B, C));
		}
		
		
		
		// 2. 다익스트라
		int[] dp = dijkstra(V, E, S, adj);
		
		
		
		// 3. 출력
		for (int i = 1; i < V + 1; i++) {
			System.out.print("노드" + S + " → 노드" + i + " 최단거리 : ");
			if (dp[i] == INF)
				System.out.println("도달할 수 없음");
			else	
				System.out.println(dp[i]);
		}
	}

	
	/*	매개변수
	 * 	- 정점의 개수가 V개
	 * 	- 간선의 개수가 E개
	 * 	- 시작 노드가 S
	 * 	- 그래프 연결 정보가 adj
	 * 
	 * 	return
	 * 	- 시작 노드 S에서 다른 모든 정점까지 가는 최단거리를 1차원 배열(dp)에 담아서 반환한다.
	 *  - dp[i] : 노드 S에서 노드 i까지 가는 최단거리
	 * */
	private static int[] dijkstra(int V, int E, int S, List<Edge>[] adj) {
		
		boolean[] visited = new boolean[V + 1];		
		
		int[] dp = new int[V + 1];
		Arrays.fill(dp, INF);
		dp[S] = 0;
		
		
		while (true) {
			int start = -1;
			int min = INF;
			
			// 1단계 : 방문한 적 없는 노드들 중에서 dp값이 가장 작은 노드(start) 찾기
			for (int j = 1; j < V + 1; j++)
				if (!visited[j] && min > dp[j]) {
					min = dp[j];
					start = j;
				}
			
			if (start == -1) break;
			visited[start] = true;
			
			
			// 2단계 : 방문한 적 없으면서 start와 인접한 노드들에 대하여, dp값을 갱신해주기
			for (Edge end : adj[start])
				if (!visited[end.vertex])
					dp[end.vertex] = Math.min(dp[end.vertex], dp[start] + end.weight);
		}
		
		return dp;
	}

}