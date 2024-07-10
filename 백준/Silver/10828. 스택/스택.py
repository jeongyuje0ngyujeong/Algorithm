import sys

num = int(sys.stdin.readline())
stack = []
ans_list = []
for i in range(num):
    check = list(map(str, sys.stdin.readline().split()))

    if len(check) != 1:
        stack.append(int(check[1]))

    else:
        if check[0] == "pop":
            if stack:
                ans_list.append(stack.pop())

            else:
                ans_list.append(-1)

        elif check[0] == "size":
            ans_list.append(len(stack))

        elif check[0] == "empty":
            if stack:
                ans_list.append(0)

            else:
                ans_list.append(1)

        elif check[0] == "top":
            if stack:
                (ans_list.append(stack[len(stack) - 1]))

            else:
                ans_list.append(-1)

for ans in ans_list:
    sys.stdout.write(str(ans) + "\n")