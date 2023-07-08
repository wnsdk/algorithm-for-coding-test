import heapq

# adj[a][b] : a 노드에서 b 노드까지 가는 비용 (가는 경로가 존재하지 않으면 -1)
adj = [[-1] * (n + 1) for _ in range(n + 1)]

# 프림 알고리즘
# 최소 신장 트리(MST) 생성 알고리즘 - 모든 정점을 포함하고, 사용된 간선들의 합이 최소인 트리
tot = 0
visited = [False] * (n + 1)
h = []

# 1단계 : 임의 정점 선택 (1번 노드, 거리는 0)
heapq.heappush(h, (0, 1))

while h:
    # 2단계 : 인접 정점들 중 최소 비용 간선 선택
    weight, vertex = heapq.heappop(h)

    if visited[vertex]:
        continue

    tot += weight
    visited[vertex] = True

    # 선택된 정점과 연결된 정점들을 모두 힙에 추가
    for i in range(1, n + 1):
        d = adj[vertex][i]

        # 가는 경로가 존재해야하고, 방문한 적 없어야 함
        if d > -1 and not visited[i]:
            heapq.heappush(h, (d, i))

print(tot)
