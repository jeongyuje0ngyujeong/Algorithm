import sys

sys.setrecursionlimit(10 ** 5)
graph = [[]]
is_visited = []
test_case = int(sys.stdin.readline())
answer = [''] * test_case


def dfs(num: int, check_group: int) -> bool:
    is_visited[num] = check_group

    for i in graph[num]:
        if not is_visited[i]:
            result = dfs(i, -check_group)
            if not result:
                return False

        elif is_visited[i] == check_group:
            return False

    return True


for i in range(test_case):
    vertex, edge = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(vertex + 1)]
    is_visited = [0] * (vertex + 1)

    for _ in range(edge):
        s, e = map(int, sys.stdin.readline().split())
        graph[s].append(e)
        graph[e].append(s)

    result = True
    for j in range(1, vertex + 1):
        if not is_visited[j]:
            result = dfs(j, 1)
            if not result:
                break

    if result:
        answer[i] = "YES"
    else:
        answer[i] = "NO"


for i in answer:
    sys.stdout.write(str(i) + "\n")
