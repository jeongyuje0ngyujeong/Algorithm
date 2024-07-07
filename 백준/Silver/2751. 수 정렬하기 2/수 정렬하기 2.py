import sys

size = int(sys.stdin.readline())
num_list = []

for i in range(size):
    num_list.append(int(sys.stdin.readline()))

num_list.sort()

for i in range(size):
    sys.stdout.write(str(num_list[i]) + "\n")
