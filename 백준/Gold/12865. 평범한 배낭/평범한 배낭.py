import sys

thing_num, std_weight = map(int, sys.stdin.readline().strip().split())
things = {}
for i in range(thing_num):
    # [0] => 물건의 무게, [1] => 물건의 가치
    things[i + 1] = list(map(int, sys.stdin.readline().strip().split()))

memo = [[0] * (std_weight + 1) for _ in range(thing_num + 1)]

for i in range(1, thing_num + 1):
    for j in range(1, std_weight + 1):
        if j < things[i][0]:
            memo[i][j] = memo[i - 1][j]

        else:
            memo[i][j] = max(memo[i - 1][j], memo[i - 1][j - things[i][0]] + things[i][1])

sys.stdout.write(str(memo[thing_num][std_weight]))