import sys

stair_num = int(sys.stdin.readline())
if stair_num <= 3:
    if stair_num == 1:
        sys.stdout.write(sys.stdin.readline())
    else:
        stairs = [0] * stair_num
        for i in range(stair_num):
            stairs[i] = int(sys.stdin.readline())

        if stair_num == 2:
            sys.stdout.write(str(sum(stairs)))

        else:
            sys.stdout.write(str(stairs[2] + max(stairs[0], stairs[1])))
else:
    stairs = [0] * stair_num
    for i in range(stair_num):
        stairs[i] = int(sys.stdin.readline())

    scores = [0] * stair_num
    scores[0] = stairs[0]
    scores[1] = stairs[0] + stairs[1]
    scores[2] = stairs[2] + max(stairs[0], stairs[1])

    for i in range(3, stair_num):
        scores[i] = stairs[i] + max(scores[i - 3] + stairs[i - 1], scores[i - 2])

    sys.stdout.write(str(scores[stair_num - 1]))
