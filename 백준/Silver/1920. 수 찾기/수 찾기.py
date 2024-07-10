import sys

ans_list = []


def search(n: int, array: list, left: int, right: int) -> None:
    global ans_list
    if left > right:
        ans_list.append(0)
        return

    mid = (left + right) // 2
    if n == array[mid]:
        ans_list.append(1)
        return

    elif n < array[mid]:
        search(n, array, left, mid - 1)

    else:
        search(n, array, mid + 1, right)


num_size = int(sys.stdin.readline())
numbers = list(map(int, (sys.stdin.readline()).split()))

numbers.sort()
find_num_size = int(sys.stdin.readline())
find_nums = list(map(int, (sys.stdin.readline()).split()))

for i in (range(find_num_size)):
    search(find_nums[i], numbers, 0, num_size - 1)

for i in range(len(ans_list)):
    sys.stdout.write(str(ans_list[i]) + "\n")
