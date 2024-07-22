import sys

size = int(sys.stdin.readline())
num_array = [0] + list(map(int, sys.stdin.readline().strip().split()))
check_arr = sorted(list(set(num_array)))
LCS = [[0] * (size + 1) for _ in range(len(check_arr))]
row = len(check_arr)
col = len(num_array)

for i in range(row):
    for j in range(col):
        if check_arr[i] == 0 or num_array[j] == 0:
            continue

        elif check_arr[i] == num_array[j]:
            LCS[i][j] = LCS[i - 1][j - 1] + 1

        else:
            LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1])

sys.stdout.write(str(LCS[row - 1][col - 1]))