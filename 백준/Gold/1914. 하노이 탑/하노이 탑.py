cnt = 0


def recur(n, x, y):
    global cnt

    if n == 1:
        cnt += 1
        print(str(x) + " " + str(y))
        return

    recur(n - 1, x, 6 - x - y)

    cnt += 1
    print(str(x) + " " + str(y))
    recur(n - 1, 6 - x - y, y)


num = int(input())
print(2 ** num - 1)
if num <= 20:
    recur(num, 1, 3)


