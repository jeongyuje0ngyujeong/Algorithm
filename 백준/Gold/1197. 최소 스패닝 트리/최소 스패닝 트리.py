import sys

vertex, edge = map(int, (sys.stdin.readline().split()))
edges = [[]for _ in range(edge)]
union_find = [i for i in range(vertex + 1)]


def union(a: int, b: int) -> None:
    a = find(a)
    b = find(b)

    union_find[max(a, b)] = min(a, b)


def find(idx: int) -> int:
    if union_find[idx] == idx:
        return idx

    union_find[idx] = find(union_find[idx])
    return union_find[idx]


for i in range(edge):
    edges[i] = list(map(int, sys.stdin.readline().split()))


def same_parent(a: int, b: int) -> bool:
    return find(a) == find(b)


edges.sort(key=lambda x: x[2])
ans_sum = 0

for i in range(edge):
    start = edges[i][0]
    end = edges[i][1]
    weight = edges[i][2]

    if not same_parent(union_find[start], union_find[end]):
        union(union_find[start], union_find[end])
        ans_sum += weight

sys.stdout.write(str(ans_sum))




