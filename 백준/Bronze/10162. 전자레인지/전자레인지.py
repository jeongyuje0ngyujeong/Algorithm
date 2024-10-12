import sys

time = int(sys.stdin.readline())
five_min = 60 * 5
one_min = 60 * 1
ten_sec = 10

result = [0] * 3

if time >= five_min:
    result[0] = time // five_min
    result[1] = (time % five_min) // one_min
    if ((time % five_min) % one_min) % ten_sec != 0:
        print(-1)
    else:
        result[2] = ((time % five_min) % one_min) // ten_sec
        for val in result:
            sys.stdout.write(str(val) + " ")

elif time >= one_min:
    result[0] = 0
    result[1] = time // one_min
    if (time % one_min) % ten_sec != 0:
        print(-1)
    else:
        result[2] = (time % one_min) // ten_sec
        for val in result:
            sys.stdout.write(str(val) + " ")

else:
    result[0] = 0
    result[1] = 0
    if time % ten_sec != 0:
        print(-1)
    else:
        result[2] = time // ten_sec
        for val in result:
            sys.stdout.write(str(val) + " ")