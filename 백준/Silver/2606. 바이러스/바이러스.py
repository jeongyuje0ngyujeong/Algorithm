import sys

vertices = int(sys.stdin.readline())
edges = int(sys.stdin.readline())
computers = [[] for _ in range(vertices + 1)]
virus_computer = 0
is_visited = [False] * (vertices + 1)


def dfs(start: int) -> None:
    global virus_computer

    if not is_visited[start]:
        is_visited[start] = True

        for com in computers[start]:
            if not is_visited[com]:
                virus_computer += 1
                dfs(com)


for i in range(edges):
    s, e = map(int, sys.stdin.readline().split())
    computers[s].append(e)
    computers[e].append(s)

dfs(1)
sys.stdout.write(str(virus_computer))
