import sys

a, b, c, d = map(str, sys.stdin.readline().split())

sum1 = a + b
sum2 = c + d

answer = str(int(sum1) + int(sum2))
sys.stdout.write(answer)

