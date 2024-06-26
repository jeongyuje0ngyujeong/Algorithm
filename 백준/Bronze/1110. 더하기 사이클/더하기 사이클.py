import sys

num = int(sys.stdin.readline())
checkNum = int(num)
cnt = 0

while True:
    cnt += 1

    if checkNum < 10:
        checkNum = int(str(checkNum) + str(checkNum))

    else :
        checkNum = int(str(checkNum % 10) + str(((checkNum // 10) + (checkNum % 10)) % 10))

    if checkNum == num:
        break

sys.stdout.write(str(cnt))