import sys

score = int(sys.stdin.readline())
if score >= 90:
    sys.stdout.write("A")

elif score >= 80:
    sys.stdout.write("B")

elif score >= 70:
    sys.stdout.write("C")

elif score >= 60:
    sys.stdout.write("D")

else:
    sys.stdout.write("F")
