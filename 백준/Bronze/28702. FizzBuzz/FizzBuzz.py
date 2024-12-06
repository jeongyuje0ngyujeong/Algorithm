

def print_answer(num: int) -> None:
    if num % 3 == 0 and num % 5 == 0:
        print("FizzBuzz")
        return

    elif num % 3 == 0:
        print("Fizz")
        return

    elif num % 5 == 0:
        print("Buzz")
        return

    else:
        print(num)
        return


for i in range(3):
    check = input()
    if check.isdigit():
        check = int(check) + (3 - i)
        print_answer(check)
        break

