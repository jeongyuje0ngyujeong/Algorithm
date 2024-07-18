import collections
import sys

row = col = int(sys.stdin.readline())
graph = [[] for _ in range(row)]
is_visited = [[False] * row for _ in range(row)]
for i in range(row):
    graph[i] = list(map(int, sys.stdin.readline().strip()))
apt_sum = 0
house_num = [0] * (row * col)


def bfs(start_row: int, start_col: int):
    global apt_sum
    queue = collections.deque()
    queue.append([start_row, start_col])
    house_num[apt_sum] += 1
    is_visited[start_row][start_col] = True

    while queue:
        current_location = queue.popleft()
        current_x = current_location[1]
        current_y = current_location[0]

        dx = [0, 0, -1, 1]
        dy = [-1, 1, 0, 0]

        for i in range(4):
            move_x = current_x + dx[i]
            move_y = current_y + dy[i]

            if move_x >= col or move_x < 0 or move_y >= row or move_y < 0:
                continue

            if not is_visited[move_y][move_x] and graph[move_y][move_x] == 1:
                is_visited[move_y][move_x] = True
                queue.append([move_y, move_x])

                house_num[apt_sum] += 1

    apt_sum += 1


for i in range(row):
    for j in range(row):
        if not is_visited[i][j] and graph[i][j] != 0:
            bfs(i, j)

sys.stdout.write(str(apt_sum) + "\n")
house_num.sort()
for h in house_num:
    if h != 0:
        sys.stdout.write(str(h) + "\n")