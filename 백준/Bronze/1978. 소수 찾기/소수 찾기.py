import math

num = int(input())
nums = list(map(int, input().split()))
cnt = 0
for i in range(num):
    if nums[i] == 1:
        continue
    is_prime = True

    for j in range(2, int(math.sqrt(nums[i])) + 1):
        if nums[i] % j == 0:
            is_prime = False
    if is_prime:
        cnt += 1

print(cnt)