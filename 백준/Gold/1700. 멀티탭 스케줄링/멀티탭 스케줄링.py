import ast
import sys

n, k = map(int, sys.stdin.readline().strip().split())
k_order = list(map(int, sys.stdin.readline().strip().split()))
cnt = 0
is_used = []

for i in range(k):
    used_thing = k_order[i]
    if used_thing in is_used:
        k_order[i] = 0
        continue

    if n > 0:
        n -= 1
        is_used.append(used_thing)
        k_order[i] = 0
        continue

    check = -1
    for val in is_used:
        if val not in k_order:
            is_used.remove(val)
            n += 1
            break

        if check < k_order.index(val):
            check = k_order.index(val)

    if n == 0:
        del is_used[is_used.index(k_order[check])]

    else:
        n -= 1
    k_order[i] = 0
    is_used.append(used_thing)
    cnt += 1

sys.stdout.write(str(cnt))
