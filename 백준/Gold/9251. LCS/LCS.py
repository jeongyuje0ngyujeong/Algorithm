import sys

row_str = ' ' + sys.stdin.readline().strip()
col_str = ' ' + sys.stdin.readline().strip()
lcs = [[0] * (len(col_str)) for _ in range(len(row_str))]

for i in range(1, len(row_str)):
    for j in range(1, len(col_str)):
        if row_str[i] == col_str[j]:
            lcs[i][j] = lcs[i - 1][j - 1] + 1

        else:
            lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])

print(max(lcs[len(row_str) - 1]))