import collections
import sys

city, road, dist_info, start_city = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(city + 1)]
for _ in range(road):
    s, e = map(int, sys.stdin.readline().split())
    graph[s].append(e)

is_visited = [False] * (city + 1)
shortest_dist = [3000000] * (city + 1)
shortest_dist[start_city] = 0


def bfs(start: int):
    queue = collections.deque()
    queue.append(start)
    is_visited[start] = True

    while queue:
        current_city = queue.popleft()

        for c in graph[current_city]:
            if not is_visited[c]:
                is_visited[c] = True
                queue.append(c)
                shortest_dist[c] = min(shortest_dist[c], shortest_dist[current_city] + 1)


bfs(start_city)
dist = False
for i in range(1, len(shortest_dist)):
    if shortest_dist[i] == dist_info:
        dist = True
        sys.stdout.write(str(i) + "\n")

if not dist:
    sys.stdout.write('-1')