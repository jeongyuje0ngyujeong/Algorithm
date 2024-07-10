from collections import deque
import sys

num, order = map(int, sys.stdin.readline().split())
queue = deque([i + 1 for i in range(num)])
ans_list = []
while queue:
    for i in range(order):
        check = queue.popleft()

        if (i + 1) == order:
            ans_list.append(check)

        else:
            queue.append(check)

sys.stdout.write("<")
for i in range(len(ans_list)):
    if i == len(ans_list) - 1:
        sys.stdout.write(str(ans_list[i]))
        break

    sys.stdout.write(str(ans_list[i]) + ", ")
sys.stdout.write(">")

