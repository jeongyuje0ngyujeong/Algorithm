import sys

n = int(sys.stdin.readline())

for i in range(1, 10):
    sys.stdout.write(str(n) + " * " + str(i) + " = " + str(i * n) + "\n")