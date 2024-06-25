import sys

testCases = range(int(sys.stdin.readline()))
price = 0
answer = []

for i in testCases:
    price = int(sys.stdin.readline())
    options = range(int(sys.stdin.readline()))

    for j in options:
        quantity, optionPrice = map(int, sys.stdin.readline().split())
        price += (quantity * optionPrice)

    answer.append(price)

for i in answer:
    sys.stdout.write(str(i))
    sys.stdout.write("\n")
