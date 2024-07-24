import sys

math_expression = sys.stdin.readline().strip()
after_minus = math_expression.split('-')
answer = 0

answer += sum(map(int, (after_minus[0].split('+'))))

for num in after_minus[1:]:
    answer -= sum(map(int, (num.split('+'))))
sys.stdout.write(str(answer))
