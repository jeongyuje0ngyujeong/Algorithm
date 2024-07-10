import sys
import heapq

size = int(sys.stdin.readline())
pq = []
ans = []

for i in range(size):
    order = int(sys.stdin.readline())
    if order == 0:
        if pq:
            ans.append(heapq.heappop(pq)[1])

        else:
            ans.append(0)

    else:
        heapq.heappush(pq, (-order, order))

for i in range(len(ans)):
    sys.stdout.write(str(ans[i]) + "\n")