size = int(input())
num_list = []

for i in range(size):
    num_list.append(int(input()))

num_list.sort()

for i in range(size):
    print(num_list[i])