check_nums = range(2, 10001)
nums = list(check_nums)

for i in range(2, 101):
    for j in range(len(check_nums)):
        if check_nums[j] == i:
            continue

        if check_nums[j] % i == 0:
            if check_nums[j] in nums:
                del nums[nums.index(check_nums[j])]


test_case = int(input())
ans_list = []
for i in range(test_case):
    num = int(input())
    ans = ""
    if num % 2 == 0 and num // 2 in nums:
        ans = str(num // 2) + " " + str(num // 2)
    else:
        for j in range(num // 2, -1, -1):
            if j in nums and num - j in nums:
                ans = str(min(j, num - j)) + " " + str(max(j, num - j))
                break
    ans_list.append(ans)

for i in range(test_case):
    print(ans_list[i])

