import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize

# 정점 개수 V, 간선 개수 E
V, E = map(int, input().split())
# 시작 정점 번호 start
start = int(input())
# 인접 리스트
adj = [[] for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, input().split())
    adj[u].append((v, w))

# 간선에 가중치가 있는 그래프에서, 어느 한 시작 정점을 기준으로 모든 다른 정점까지의 최단 거리를 구하는 알고리즘
# distance[i] : 시작 정점 start에서 정점 i까지 가는 최단 거리 (INF 값이 들어있다면 도달 불가능)
def dijkstra(start):
    distance = [INF] * (V + 1)
    distance[start] = 0
    visited = [False] * (V + 1)

    h = []
    heapq.heappush(h, (0, start))

    while h:
        # 최단 거리가 가장 짧은 노드 찾기
        dist1, now = heapq.heappop(h)

        # 방문 체크를 하면 시간을 더 단축할 수 있음 (안해도 상관없긴 함)
        if visited[now]:
            continue
        visited[now] = True
        
        # now 노드와 연결된 다른 인접한 노드들을 확인
        for next, dist2 in adj[now]:
            cost = dist1 + dist2
            
            # now 노드를 거쳐서 next 노드로 이동하는 것이 더 짧다면, 값 갱신
            if cost < distance[next]:
                distance[next] = cost
                heapq.heappush(h, (cost, next))

    return distance

distance = dijkstra(start)
for i in distance[1:]:
    print('INF' if i == INF else i)
