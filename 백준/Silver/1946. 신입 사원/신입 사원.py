import sys

test_case = int(sys.stdin.readline())
for _ in range(test_case):
    applicant = int(sys.stdin.readline())
    applicants = [[] for _ in range(applicant)]
    for i in range(applicant):
        applicants[i] = list(map(int, sys.stdin.readline().strip().split()))

    applicants.sort(key=lambda x: x[0])
    check = applicants[0]
    cnt = 1
    for i in range(1, applicant):
        if check[1] > applicants[i][1]:
            check = applicants[i]
            cnt += 1

    print(cnt)