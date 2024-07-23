import sys

coin_num, std_sum = map(int, sys.stdin.readline().split())
coins = [0] * coin_num
for i in range(coin_num):
    coins[i] = int(sys.stdin.readline())

coins.sort(reverse=True)
ans = 0

for coin in coins:
    if coin > std_sum:
        continue

    if coin == std_sum:
        ans += 1
        break

    ans += (std_sum // coin)
    std_sum %= coin

sys.stdout.write(str(ans))
