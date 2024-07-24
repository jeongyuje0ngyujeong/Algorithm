import sys

room = int(sys.stdin.readline())
timeline = [[] for _ in range(room)]
for i in range(room):
    timeline[i] = list(map(int, sys.stdin.readline().strip().split()))

timeline.sort(key=lambda x: (x[1], x[0]))
check_time = 0
cnt = 0
for i in range(room):
    if check_time > timeline[i][0]:
        continue

    cnt += 1
    check_time = timeline[i][1]

sys.stdout.write(str(cnt))