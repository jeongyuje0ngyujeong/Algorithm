import sys

cnt = 0
num = int(sys.stdin.readline())
columns = [False] * num
diagonal1 = [False] * (2 * num - 1)
diagonal2 = [False] * (2 * num - 1)


def find_queen(i: int):
    global cnt
    global num
    for j in range(num):
        if not columns[j] and not diagonal1[i + j] and not diagonal2[(i - j) - (num - 1)]:
            if i == num - 1:
                cnt += 1

            else:
                columns[j] = True
                diagonal1[i + j] = True
                diagonal2[(i - j) - (num - 1)] = True

                find_queen(i + 1)
                columns[j] = diagonal1[i + j] = diagonal2[(i - j) - (num - 1)] = False


find_queen(0)
sys.stdout.write(str(cnt))
