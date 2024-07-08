dwarfs = []
tall_sum = 0
for i in range(9):
    tall = int(input())
    dwarfs.append(tall)
    tall_sum += tall

found = False
for i in range(9):
    if found:
        break
    for j in range(9):
        if i == j:
            continue

        if tall_sum - (dwarfs[i] + dwarfs[j]) == 100:
            a = dwarfs[i]
            b = dwarfs[j]
            dwarfs.remove(a)
            dwarfs.remove(b)
            found = True
            break


dwarfs.sort()
for i in dwarfs:
    print(i)