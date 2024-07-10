from collections import deque
import sys

size = int(sys.stdin.readline())
queue = deque([])
ans_list = []
for i in range(size):
    check = list(map(str, sys.stdin.readline().split()))

    if len(check) != 1:
        queue.append(int(check[1]))

    else:
        if check[0] == 'pop':
            if queue:
                ans_list.append(queue.popleft())

            else:
                ans_list.append(-1)

        elif check[0] == 'size':
            ans_list.append(len(queue))

        elif check[0] == 'empty':
            if queue:
                ans_list.append(0)

            else:
                ans_list.append(1)

        elif check[0] == 'front':
            if queue:
                ans_list.append(queue[0])

            else:
                ans_list.append(-1)

        elif check[0] == "back":
            if queue:
                ans_list.append(queue[len(queue) - 1])

            else:
                ans_list.append(-1)

for i in ans_list:
    sys.stdout.write(str(i) + "\n")