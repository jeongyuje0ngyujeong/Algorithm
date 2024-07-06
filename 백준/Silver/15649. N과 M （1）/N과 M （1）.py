num, size = map(int, input().split())

ans_list = []
isVisited = [False for _ in range(num)]


def find_num(n: int, depth: int):
    global size
    if size == depth:
        print(" ".join(ans_list))
        return

    for i in range(n):
        if not isVisited[i]:
            isVisited[i] = True
            ans_list.append(str(i + 1))
            find_num(n, depth + 1)
            isVisited[i] = False
            del ans_list[-1]

find_num(num, 0)