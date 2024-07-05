test_case = int(input())
ans_list = []
for i in range(test_case):

    repeat_num, string = map(str, input().split())
    repeat_num = int(repeat_num)
    check_list =[]
    for j in range(len(string)):
        check_list.append(string[j] * repeat_num)
    ans_list.append(''.join(check_list))
    
for i in range(test_case):
    print(ans_list[i])