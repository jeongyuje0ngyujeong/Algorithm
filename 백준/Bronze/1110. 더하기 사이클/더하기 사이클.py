import sys

N = sys.stdin.readline().strip()
origin = N
cnt = 0

if int(N) < 10:
    N = '0' + N
A = N[0]
B = N[1]
sum = f'{int(A)+int(B)}'
N = B + sum[-1]

cnt+=1

while int(N) != int(origin):
    A = N[0]
    B = N[1]
    sum = f'{int(A)+int(B)}'
    N = B + sum[-1]
    cnt+=1

print(cnt)