# 우선순위 큐 사용을 위해 힙큐 쓰기
import heapq, sys
input = sys.stdin.readline
inf = 10000000


def dijkstra(start):
    # 시작 노드 (start) 에 대한 가중치 배열 새로 선언
    distances = [inf] * (N + 1)
    visited = [False] * (N + 1)
    # 나에서 나한테 가는 비용은 0으로 초기화
    distances[start] = 0
    # 큐 초기화 (나에서 나한테 가는 비용은 0 V2)
    heap = [(0, start)]
    while heap:
        # 가장 우선순위 높은 (제일 가중치 낮은) 노드와 거기로 이동하는 가중치 pop
        current_distance, current_node = heapq.heappop(heap)
        # 이미 체크했던 노드인지 검사
        if visited[current_node]:
            continue
        # 노드 방문 체크
        visited[current_node] = True
        # 더 적어서 갱신해야 한다면 pop된 노드의 테이블에 접근
        for next_node in table[current_node]:
            # pop된 노드로 이동하는 비용과 그 노드에서 next_node 로 이동하는 비용을 합해 (이 문제에선 항상 1)
            # 새로운 거리 계산
            distance = current_distance + 1
            # 만약 새로 계산한 거리가 기존 distances 테이블의 값보다 작다면
            if distance < distances[next_node]:
                # 최소 비용 갱신 후 heapq에 push
                distances[next_node] = distance
                heapq.heappush(heap, (distance, next_node))
    return distances


N, M, K, X = map(int, input().strip().split())
table = [[] for _ in range(N + 1)]

for _ in range(M):
    n1, n2 = map(int, input().strip().split())
    table[n1].append(n2)
    
result = dijkstra(X)
result_count = 0
for i in range(1, N + 1):
    if result[i] == K:
        print(i)
        result_count += 1
if result_count == 0:
    print(-1)