import sys

math_expression = sys.stdin.readline().strip()
if '+' in math_expression:
    split_first = list(map(str, math_expression.split('-')))
    for i in range(0, len(split_first)):
        if '+' in split_first[i]:
            check_num = 0
            split_second = split_first[i].split('+')
            for check in split_second:
                check_num += int(check)
            split_first[i] = check_num

        else:
            split_first[i] = int(split_first[i])

    answer = split_first[0]
    for i in range(1, len(split_first)):
        answer -= split_first[i]

    sys.stdout.write(str(answer))

else:
    numbers = list(map(int, math_expression.split('-')))
    answer = numbers[0]
    for i in range(1, len(numbers)):
        answer -= numbers[i]

    sys.stdout.write(str(answer))