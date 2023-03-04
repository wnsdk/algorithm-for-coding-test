# Algorithm

코딩테스트를 위한 알고리즘 유형 정리

예시 코드는 모두 파이썬으로 작성되었다.

[0. 파이썬 문법](Algorithm%20df5970c6b04547a0aeaca7d7e2d7a354.md)

[1. 자료구조](Algorithm%20df5970c6b04547a0aeaca7d7e2d7a354.md)

[2. 완전 탐색](Algorithm%20df5970c6b04547a0aeaca7d7e2d7a354.md)

[3. 이분 탐색](Algorithm%20df5970c6b04547a0aeaca7d7e2d7a354.md)

4. 동적 계획법

5. 탐욕법

6. 소수

# 0. 파이썬 문법

---

[Python](https://www.notion.so/Python-3f382de3c71a432692211c43cee838ae) 

# 1. 자료구조

---

알고리즘 문제를 풀 때 필요한 데이터들을 어떤 자료구조에 담을 것인지를 고민해야한다.

## 1) 배열 / 스택 → list

```python
list = []

list.append(x)
list.pop()
```

- 배열 Array
- 스택 Stack : 한 쪽 끝에서만 데이터를 넣고 뺄 수 있는 선형 자료구조 (FILO 또는 LIFO)

## 2) 큐 / 덱 → deque

```python
from collections import deque

dq = deque()

dq.append(x)
dq.pop()

dq.appendleft(x)
dq.popleft()
```

- 큐 Queue : 한 쪽에서는 데이터를 넣을 수만 있고, 다른 한 쪽은 데이터를 뺄 수만 있는 선형 자료구조 (FIFO 또는 LILO)
- 덱 Deque : 양 쪽 모두에서 데이터를 넣고 뺄 수 있는 선형 자료구조

## 3) 우선순위 큐 → heap

```python
import heapq

h = []

heapq.heappush(h, x)
heapq.heappop(h)
```

- 우선순위 큐 Priority Queue : 우선순위 큐는 내부적으로 힙(heap)이라는 완전이진트리로 구성되어있다. 파이썬의 경우 힙의 루트 노드에는 ‘언제나’ 최솟값이 들어있다. (최소힙)

## 4) 딕셔너리

```python

```

## 5) 집합 → set

# 2. 완전 탐색

---

# 3. 이분 탐색

---

# 4. 동적 계획법

---

# 5. 탐욕법

---

# 6. 소수

---

[기타](Algorithm%20df5970c6b04547a0aeaca7d7e2d7a354/%E1%84%80%E1%85%B5%E1%84%90%E1%85%A1%2057a69691d4034607b431e540ee3fe138.md)

---

위상정렬 -> bfs 사용

1. 진입차수가 0인 노드(시작점)을 큐에 모두 넣는다
2. 큐에서 진입 차수가 0인 노드를 꺼내어 자신과 인접한 노드의 간선을 제거한다.
3. 간선 제거 후 진입차수가 0이 된 노드를 큐에 넣는다.
- > 큐가 빌 때까지 2-3작업을 반복한다.
- 모든 노드가 처리되었다면 위상정렬 완성
- 모든 노드가 처리되지 않았다면 사이클 발생

---

# 마방진

행의 합 열의 합 대각선의 합이 모두 같은 정사각형

N * N 마방진 만드는 방법

1) N이 홀수일 때

(0, N / 2)에 1을 써 넣는다.

현재 보고 있는 y 좌표, x 좌표를 각각 -1 시킨 위치에 다음번 숫자를 써넣는다.

만일 이미 해당 칸에 숫자가 써져 있다면, 그 칸 바로 밑칸으로 이동한다.

N * N까지 다 써넣을때까지 반복한다.

2) N이 4의 배수일 때

![Untitled](Algorithm%20df5970c6b04547a0aeaca7d7e2d7a354/Untitled.png)

위 그림처럼 서로 위치바꾸기

---

다익스트라 Dijkstra

5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

```java
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
```

---

플로이드 워샬 Floyd Warshall

5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

```java
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
```

---

KMP

입력1.
ABC ABCDAB ABCDABCDABDE
ABCDABD

입력2.
abababab
abab

```java
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
```

---

크루스칼 Kruskal

3 3
1 2 1
2 3 2
1 3 3

```java
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
```

---

프림 Prim

3 3
1 2 1
2 3 2
1 3 3

```java
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
```

---

LIS

6
10 20 10 30 20 50

이분탐색 버전

```java
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
```

dp 버전

```java
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
```

---

컨벡스 헐 Convex Hull (미완)

8
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2

```java
// 대표 문제 : BOJ 1708 P5 볼록 껍질
// https://www.acmicpc.net/problem/1708

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/*	Convex Hull 개요
 * 
 * 	볼록 껍질(Convex Hull)
 * 
 * */

class Hull{
	int y;
    int x;
    
    Hull(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class ConvexHull {
    
    public static void main(String[] args) throws Exception {
    	
    	// 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());	// 점의 개수
        Hull[] list = new Hull[N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());    
            list[i] = new Hull(y, x);
        }
        
        
        // 2. 컨벡스 헐
        Stack<Integer> stack = convexHull(list);
        
        
        // 3. 출력
        System.out.println(stack.size());
    }
    
    
    private static Stack<Integer> convexHull(Hull[] list) {
    	
    	int N = list.length - 1;
    	
    	// 1. 기준점 선정 (y값, x값이 제일 작은 점)
        for(int i = 0; i < N; i++){
            if(list[0].y > list[i].y || list[0].y == list[i].y && list[0].x > list[i].x){
                Hull temp = list[0];
                list[0] = list[i];
                list[i] = temp;
            }
        }
        
        
        // 2. 기준점 기준으로 반시계방향으로 정렬
        Arrays.sort(list, 1, N, new Comparator<Hull>() {
            @Override
            public int compare(Hull a, Hull b) {
                int v = ccw(new Hull(list[1].x, list[1].y), a, b);
                if(v > 0) return -1;
                if(v < 0) return 1;
                return (Math.abs(a.x) + a.y) - (Math.abs(b.x) + b.y);
            }
        });
        
        // 3. stack 
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < N; i++){
            while(stack.size() > 1 && ccw(list[stack.get(stack.size()-2)], list[stack.peek()], list[i]) <=0 ){
                stack.pop();
            }
            stack.add(i);
        }
    	
		return stack;
	}

	private static int ccw(Hull A, Hull B, Hull C) {
        
        long S = (long)(B.x - A.x) * (C.y - A.y) - (long)(C.x-A.x) * (B.y-A.y);
        
        if (S > 0) return 1;
        else if (S < 0) return -1;
        else return 0;
    }
    
}
```

---

CCW

1 1
7 3
5 5

```java
// 대표 문제 : BOJ 11758 G5 CCW
// https://www.acmicpc.net/problem/11758

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*	CCW 개요
 * 
 * 	선분 교차 판별(CCW; Counter Clock Wise)
 * 	점 3개를 차례로 이었을 때 반시계 방향인지, 시계 방향인지, 일직선인지 알 수 있는 알고리즘
 * */

public class CCW {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		
		int S = CCW(y1, x1, y2, x2, y3, x3);
		
		if (S == 1) System.out.println("CCW 값은 양수, 세 점을 차례로 이으면 반시계 방향");
		else if (S == -1) System.out.println("CCW 값은 음수, 세 점을 차례로 이으면 시계 방향");
		else if (S == 0) System.out.println("CCW 값은 0, 세 점을 차례로 이으면 일직선");
	}
	
	/*	매개변수
	 * 	- 점 (y1, x1)
	 * 	- 점 (y2, x2)
	 * 	- 점 (y3, x3)
	 * 
	 * 	return
	 * 	- 결과가 양수 	: 반시계 방향
	 * 	- 결과가 음수 	: 시계 방향
	 * 	- 결과가 0		: 일직선
	 * */
	private static int CCW(int y1, int x1, int y2, int x2, int y3, int x3) {
		int S = x1 * y2 + x2 * y3 + x3 * y1 - (x2 * y1 + x3 * y2 + x1 * y3);
		
		if (S > 0) return 1;
		else if (S < 0) return -1;
		else return 0;
	}

}
```
