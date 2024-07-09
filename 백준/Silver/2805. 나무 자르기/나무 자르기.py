if __name__ == "__main__":
    import sys
    input = sys.stdin.readline

    N, K = map(int, input().split())
    array = list(map(int, input().split()))


    array.sort()

    start = 1
    end = max(array)
    mid = (start + end) // 2
    while(start <= end):
        #mid = (start+end)//2
        cnt = 0
        for tree in array:
            if tree > mid:
                cnt += (tree-mid)
        if cnt < K:
            end = mid-1
            mid = (start + end) // 2
        else:
            start = mid+1
            mid = (start + end) // 2

    print(mid)