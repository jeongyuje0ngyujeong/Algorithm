import sys
from collections import deque

row, col = map(int, sys.stdin.readline().strip().split())
queue = deque()
maps = [[] for _ in range(row)]
answer = [[-1 for _ in range(col)] for _ in range(row)]

for i in range(row):
    array = list(map(int, sys.stdin.readline().strip().split()))
    j = 0
    for c in array:
        maps[i].append(c)
        if c == 2:
            queue.append((i, j))
            answer[i][j] = 0
        elif c == 0:
            answer[i][j] = 0
        j += 1

while queue:
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    y, x = queue.popleft()
    for i in range(4):
        mx = dx[i] + x
        my = dy[i] + y

        if mx >= col or mx < 0 or my >= row or my < 0 or answer[my][mx] != -1:
            continue

        answer[my][mx] = answer[y][x] + 1
        queue.append((my, mx))

for a in answer:
    print(' '.join(map(str, a)))
