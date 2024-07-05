#A+B, A-B, A*B, A/B(몫), A%B(나머지)
import sys

A, B = map(str, sys.stdin.readline().split())
A = int(A)
B = int(B)

sys.stdout.write(str(A + B) + "\n")
sys.stdout.write(str(A - B)+ "\n")
sys.stdout.write(str(A * B)+ "\n")
sys.stdout.write(str(A // B)+ "\n")
sys.stdout.write(str(A % B))