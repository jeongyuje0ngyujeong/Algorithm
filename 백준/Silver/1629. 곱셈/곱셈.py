import sys

A, B, C = map(int, sys.stdin.readline().split())
result = 1
A %= C

while B >= 1:
    if B % 2 == 1:
        result = (result * A) % C

    B //= 2
    A = (A * A) % C

sys.stdout.write(str(result))