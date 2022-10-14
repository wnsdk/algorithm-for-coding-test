// https://www.acmicpc.net/problem/1197 풀이

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Edge>[] adj = new ArrayList[V + 1];
		
		for (int i = 1; i < V + 1; i++)
			adj[i] = new ArrayList<>();
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adj[A].add(new Edge(B, C));
			adj[B].add(new Edge(A, C));
		}
		
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));	// 1단계 : 임의정점 선택 (pq에 넣기)
		int ans = 0;
		
		
		while (!pq.isEmpty()) {
			
			// 2단계 : 인접 정점들 중 최소 비용 간선 선택
			Edge cur = pq.poll();
			if (visited[cur.vertex]) continue;
			
			ans += cur.weight;
			visited[cur.vertex] = true;
			
			// 선택된 정점과 연결된 정점들을 모두 pq에 추가
			for (int i = 0; i < adj[cur.vertex].size(); i++) {
				Edge next = adj[cur.vertex].get(i);
				if (!visited[next.vertex])
					pq.offer(next);
			}
		}
		
		System.out.println(ans);
	}
}
