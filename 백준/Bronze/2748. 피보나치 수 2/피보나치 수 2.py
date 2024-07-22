import sys

size = int(sys.stdin.readline())
fibo = [0] * (size + 1)
fibo[0] = 0
fibo[1] = 1

for i in range(2, size + 1):
    fibo[i] = fibo[i - 1] + fibo[i - 2]

sys.stdout.write(str(fibo[size]))