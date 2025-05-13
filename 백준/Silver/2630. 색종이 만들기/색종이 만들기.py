import sys

cnt0 = 0
cnt1 = 0


def find(arr: list, row_start: int, row_end: int, col_start: int, col_end: int):
    global cnt0
    global cnt1

    if row_start >= row_end or col_start >= col_end or row_end < 1 or col_end < 1:
        return

    row = row_end - row_start
    col = col_end - col_start
    check = arr[row_start][col_start]
    is_same = True

    for r in range(row_start, row_end):
        for c in range(col_start, col_end):
            if is_same and check != arr[r][c]:
                is_same = False
                break
        if not is_same:
            break

    if is_same:
        if check == 0:
            cnt0 += 1
        else:
            cnt1 += 1
    else:
        find(arr, row_start, row_start + (row // 2), col_start, col_start + (col // 2))
        find(arr, row_start + (row // 2), row_end, col_start, col_start + (col // 2))
        find(arr, row_start,  row_start + (row // 2), col_start + (col // 2), col_end)
        find(arr, row_start + (row // 2), row_end, col_start + (col // 2), col_end)


size = int(sys.stdin.readline())
paper = []
for i in range(size):
    paper.append(list(map(int, sys.stdin.readline().split())))


if (0 in paper and not 1 in paper) or (1 in paper and not 0 in paper):
    if 0 in paper:
        cnt0 += 1
    else:
        cnt1 += 1
    sys.stdout.write(str(cnt0) + "\n")
    sys.stdout.write(str(cnt1) + "\n")
    sys.exit()

else:
    find(paper, 0, size, 0, size)
    sys.stdout.write(str(cnt0) + "\n")
    sys.stdout.write(str(cnt1) + "\n")