dwarfs = []
tall_sum = 0

for i in range(9):
    tall = int(input())
    dwarfs.append(tall)
    tall_sum += tall

check = tall_sum - 100

dwarfs.sort()
found = False
for i in range(9):
    if found:
        break
    for j in range(9):
        if i == j:
            continue

        if check == (dwarfs[i] + dwarfs[j]):
            a = dwarfs[i]
            b = dwarfs[j]
            dwarfs.remove(a)
            dwarfs.remove(b)
            found = True
            break

dwarfs.sort()
for i in dwarfs:
    print(i)