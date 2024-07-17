import collections
import sys

vertices, edges, start = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(vertices + 1)]
is_visited = [False] * (vertices + 1)
ans_list = [[] for _ in range(2)]


def dfs(start_num: int) -> None:
    if not is_visited[start_num]:
        is_visited[start_num] = True
        ans_list[0].append(str(start_num))

        for i in range(len(graph[start_num])):
            check_node = graph[start_num][i]

            if not is_visited[check_node]:
                dfs(check_node)


def bfs(start_num: int) -> None:
    queue = collections.deque()
    if not is_visited[start_num]:
        is_visited[start_num] = True
        queue.append(start_num)

    while queue:
        check_num = queue.popleft()
        ans_list[1].append(str(check_num))

        for i in range(len(graph[check_num])):
            check_node = graph[check_num][i]

            if not is_visited[check_node]:
                is_visited[check_node] = True
                queue.append(check_node)


for i in range(edges):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

is_visited[0] = True
for i in range(len(graph)):
    graph[i] = sorted(graph[i])

dfs(start)
is_visited = [False] * (vertices + 1)
is_visited[0] = True
bfs(start)

sys.stdout.write(' '.join(ans_list[0]) + "\n")
sys.stdout.write(' '.join(ans_list[1]))
