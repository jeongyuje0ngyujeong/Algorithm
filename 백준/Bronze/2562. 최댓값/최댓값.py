nums = []
for i in range(9):
    #input()값을 int형으로 지정해줘야함. 아니면 문자열로 인식 -> 이후 max 비교 시 사전순으로 체크함
    # (ex '100' > '9' => false 왜냐! 1 => 9, 0 => 9, 0 => 9 이렇게 문자열 하나하나 비교하기 때문
    nums.append(int(input()))

print(max(nums))
print(nums.index(max(nums)) + 1)