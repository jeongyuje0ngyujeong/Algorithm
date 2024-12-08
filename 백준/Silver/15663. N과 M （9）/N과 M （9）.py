import sys

n, m = map(int, sys.stdin.readline().strip().split())
nums = list(map(int, sys.stdin.readline().strip().split()))
nums.sort()
is_visited = [False] * n
answer = []


def back_tracking(depth: int):
    pre_num = -1

    if depth == m:
        print(" ".join(answer))
        return

    for i in range(len(nums)):
        if is_visited[i] or pre_num == nums[i]:
            continue

        is_visited[i] = True
        answer.append(str(nums[i]))
        pre_num = nums[i]
        back_tracking(depth + 1)
        is_visited[i] = False
        del answer[-1]


back_tracking(0)