import sys

size = int(sys.stdin.readline())
answer = []
isVisited = [False] * (size + 1)


def back_tracking(num: int, depth: int):
    global size
    if size == depth:
        print(' '.join(map(str, answer)))
        return

    for i in range(1, size + 1):
        if not isVisited[i]:
            isVisited[i] = True
            answer.append(i)
            back_tracking(i + 1, depth + 1)
            isVisited[i] = False
            del answer[-1]


back_tracking(1, 0)
