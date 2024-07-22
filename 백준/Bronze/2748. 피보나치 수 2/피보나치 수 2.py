import sys

size = int(sys.stdin.readline())
memo = [-1] * (size + 1)
memo[0] = 0
memo[1] = 1


def fibo(idx: int) -> int:
    if memo[idx] >= 0:
        return memo[idx]

    if idx >= 2:
        memo[idx] = fibo(idx - 1) + fibo(idx - 2)

    return memo[idx]


sys.stdout.write(str(fibo(size)))