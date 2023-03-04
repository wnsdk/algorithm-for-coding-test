// 대표 문제 : BOJ 1197 G4 최소 스패닝 트리
// https://www.acmicpc.net/problem/1197

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*	프림 개요
 * 
 * 	최소 신장 트리(MST; Minimum Spanning Tree)를 만드는 알고리즘
 * 	- 신장 트리(Spanning Tree)	: 그래프 내의 모든 정점을 포함하는 트리
 * 	- 최소 신장 트리(MST)		: 신장 트리에 사용된 간선들의 가중치 합이 최소인 트리
 * 	
 * 	크루스칼 알고리즘과의 차이점
 * 	- 간선의 수가 많을 때 사용한다.
 * */

public class Prim {
		
	static class Edge implements Comparable<Edge> {
		int vertex;
		int weight;
		
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());	// 정점 개수
		int E = Integer.parseInt(st.nextToken());	// 간선 개수
		List<Edge>[] adj = new ArrayList[V + 1];	// 그래프 연결 정보
		
		for (int i = 1; i < V + 1; i++)
			adj[i] = new ArrayList<>();
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());	// 정점 1
			int B = Integer.parseInt(st.nextToken());	// 정점 2
			int C = Integer.parseInt(st.nextToken());	// 가중치
			adj[A].add(new Edge(B, C));
			adj[B].add(new Edge(A, C));
		}
		
		
		
		// 2. 프림
		int ans = prim(V, adj);
		
		
		
		// 3. 출력
		System.out.println("MST 간선들의 가중치 합 : " + ans);
	}
	
	
	/*	매개변수
	 * 	- 노드의 개수 V
	 * 	- 그래프 연결 정보 adj
	 * 
	 * 	return
	 * 	- MST에 선택된 모든 간선의 가중치 합을 반환
	 * */
	private static int prim(int V, List<Edge>[] adj) {
		
		int tot = 0;
		
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// 1단계 : 임의정점 선택 (pq에 넣기)
		pq.offer(new Edge(1, 0));	
		
		while (!pq.isEmpty()) {
			
			// 2단계 : 인접 정점들 중 최소 비용 간선 선택
			Edge cur = pq.poll();
			if (visited[cur.vertex]) continue;
			
			tot += cur.weight;
			visited[cur.vertex] = true;
			
			// 선택된 정점과 연결된 정점들을 모두 pq에 추가
			for (int i = 0; i < adj[cur.vertex].size(); i++) {
				Edge next = adj[cur.vertex].get(i);
				if (!visited[next.vertex])
					pq.offer(next);
			}
		}
		
		return tot;
	}
}