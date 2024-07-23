import sys

test_case = int(sys.stdin.readline())
for _ in range(test_case):
    coins_num = int(sys.stdin.readline())
    coins = list(map(int, sys.stdin.readline().strip().split()))
    price = int(sys.stdin.readline())
    check_ans = [0] * (price + 1)
    check_ans[0] = 1
    for coin in coins:
        for i in range(coin, len(check_ans)):
            check_ans[i] += check_ans[i - coin]

    print(check_ans[price])