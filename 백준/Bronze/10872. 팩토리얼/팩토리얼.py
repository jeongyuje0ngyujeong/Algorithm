def factorial(num):
    if num <= 0:
        return 1
    return num * factorial(num - 1)


num = int(input())
if num == 0:
    print(1)

else:
    print(factorial(num))


