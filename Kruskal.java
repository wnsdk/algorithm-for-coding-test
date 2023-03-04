// 대표 문제 : BOJ 1197 G4 최소 스패닝 트리
// https://www.acmicpc.net/problem/1197

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*	크루스칼 개요
 * 
 * 	최소 신장 트리(MST; Minimum Spanning Tree)를 만드는 알고리즘
 * 	- 신장 트리(Spanning Tree)	: 그래프 내의 모든 정점을 포함하는 트리
 * 	- 최소 신장 트리(MST)		: 신장 트리에 사용된 간선들의 가중치 합이 최소인 트리
 * 	
 * 	프림 알고리즘과의 차이점
 * 	- 간선의 수가 적을 때 사용한다.
 * */

public class Kruskal {
	
	static int[] p;
	
	static class Edge implements Comparable<Edge> {
		int vertex1;
		int vertex2;
		int weight;
		
		public Edge(int vertex1, int vertex2, int weight) {
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
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
		
		int V = Integer.parseInt(st.nextToken());	// 정점의 개수
		int E = Integer.parseInt(st.nextToken());	// 간선의 개수
		List<Edge> adj = new ArrayList<>();			// 그래프 연결 정보
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());	// 정점 1
			int B = Integer.parseInt(st.nextToken());	// 정점 2
			int C = Integer.parseInt(st.nextToken());	// 가중치
			adj.add(new Edge(A, B, C));
		}
		
		// 2. 크루스칼
		int ans = kruskal(V, adj);
		
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
	private static int kruskal(int V, List<Edge> adj) {
		
		p = new int[V + 1];
		for (int i = 1; i < V + 1; i++) p[i] = i;
		
		int cnt = 0;
		int tot = 0;
		
		
		// 1단계 : 그래프의 간선들을 가중치의 오름차순으로 정렬한다.
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (Edge edge : adj) pq.offer(edge);
		
		
		
		while (cnt < V - 1) {
			// 2단계 : 정렬된 간선 리스트 순서대로, 사이클을 형성하지 않는 간선을 선택한다.
			Edge edge = pq.poll();
			if (union(edge.vertex1, edge.vertex2)) {
				cnt++;
				tot += edge.weight;
			}
		}
		
		return tot;
	}

	
	private static boolean union(int a, int b) {
		
		int x = find(a);
		int y = find(b);
		if (x == y) return false;
		p[x] = y;
		return true;
	}

	
	private static int find(int x) {
		
		if (x == p[x]) return p[x];
		return p[x] = find(p[x]);
	}

}