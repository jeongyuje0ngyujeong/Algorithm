import sys
sys.setrecursionlimit(10**6)

preorder = []
ans = []


def make_tree(start: int, end: int):
    if start > end:
        return

    mid = end + 1
    for i in range(start + 1, end + 1):
        if preorder[i] > preorder[start]:
            mid = i
            break

    make_tree(start + 1, mid - 1)
    make_tree(mid, end)
    ans.append(preorder[start])


while True:
    try:
        a = sys.stdin.readline()
        preorder.append(int(a))
    except:
        break

make_tree(0, len(preorder) - 1)
for answer in ans:
    sys.stdout.write(str(answer) + "\n")
