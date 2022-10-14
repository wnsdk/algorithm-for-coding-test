import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> adj = new PriorityQueue<>();
		
		p = new int[V + 1];
		for (int i = 1; i < V + 1; i++) p[i] = i;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adj.offer(new Edge(A, B, C));
		}
		
		int cnt = 0;
		int ans = 0;
		
		while (cnt < V - 1) {
			Edge edge = adj.poll();
			if (union(edge.vertex1, edge.vertex2)) {
				cnt++;
				ans += edge.weight;
			}
		}
		
		System.out.println(ans);
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
