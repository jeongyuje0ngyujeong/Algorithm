import collections
import sys
sys.setrecursionlimit(10**6)

vertices = int(sys.stdin.readline())
graph = [[] for _ in range(vertices + 1)]
is_visited = [False] * (vertices + 1)
check_parent = [0] * (vertices + 1)


def dfs(start: int) -> None:
    if not is_visited[start]:
        is_visited[start] = True

        for i in graph[start]:
            if not is_visited[i]:
                check_parent[i] = start
                dfs(i)


while True:
    try:
        s, e = map(int, sys.stdin.readline().split())
        graph[s].append(e)
        graph[e].append(s)

    except:
        break

dfs(1)
for a in range(2, vertices + 1):
    sys.stdout.write(str(check_parent[a]) + "\n")