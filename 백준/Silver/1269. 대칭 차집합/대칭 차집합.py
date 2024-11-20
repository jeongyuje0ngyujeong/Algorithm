import sys

sys.stdin.readline().strip().split()
check_a = set(map(int, sys.stdin.readline().strip().split()))
check_b = set(map(int, sys.stdin.readline().strip().split()))

intersection = []
for a in check_a:
    if a in check_b:
        intersection.append(a)

result = check_a
result.update(check_b)

for i in intersection:
    if i in result:
        result.remove(i)

print(len(result))
