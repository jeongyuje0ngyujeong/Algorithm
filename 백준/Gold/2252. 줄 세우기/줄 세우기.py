import collections
import sys

vertex, edge = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(vertex + 1)]
priority_arr = [0] * (vertex + 1)
for i in range(edge):
    s, e = map(int, sys.stdin.readline().split())
    graph[s].append(e)
    priority_arr[e] += 1

queue = collections.deque()

for i in range(1, vertex + 1):
    if priority_arr[i] != 0:
        continue

    queue.append(i)

answer = []
while queue:
    check_student = queue.popleft()
    answer.append(str(check_student))

    for s in graph[check_student]:
        priority_arr[s] -= 1
        if priority_arr[s] == 0:
            queue.append(s)

sys.stdout.write(" ".join(answer))