import sys

sys.setrecursionlimit(10**6)

vertex, edge = map(int, sys.stdin.readline().strip().split())
parent = [i for i in range(vertex + 1)]

graph = []
for _ in range(edge):
    a, b, cost = map(int, sys.stdin.readline().strip().split())
    graph.append((cost, a, b))
graph.sort()


def find(x: int) -> int:
    if parent[x] == x:
        return x

    parent[x] = find(parent[x])
    return parent[x]


def union(a: int, b: int) -> None:
    root_a = find(a)
    root_b = find(b)

    parent[max(root_a, root_b)] = min(root_a, root_b)


answer = 0
for g in graph:
    cost, vertex_a, vertex_b = g
    if find(vertex_a) != find(vertex_b):
        union(vertex_a, vertex_b)
        answer += cost

print(answer)
