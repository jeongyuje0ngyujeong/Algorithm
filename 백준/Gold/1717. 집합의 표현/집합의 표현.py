import sys

sys.setrecursionlimit(1000000)

vertex, edge = map(int, sys.stdin.readline().strip().split())
parent = [i for i in range(vertex + 1)]


def find(x: int) -> int:
    if parent[x] == x:
        return x

    parent[x] = find(parent[x])
    return parent[x]


def union(a: int, b: int):
    root_a = find(a)
    root_b = find(b)

    if root_a < root_b:
        parent[root_b] = root_a
    else:
        parent[root_a] = root_b


def check_same(a: int, b: int):
    root_a = find(a)
    root_b = find(b)

    if root_a == root_b:
        return True
    return False


for i in range(edge):
    check, a, b = map(int, sys.stdin.readline().strip().split())
    if check == 0:
        union(a, b)
        continue

    if check_same(a, b):
        print("YES")
        continue

    print("NO")
