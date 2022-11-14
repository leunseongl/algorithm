def bs(x):
    lt, rt = 0, n-1
    while lt<=rt:
        mid = (lt+rt)//2
        if one[mid] == x:
            return 1
        elif one[mid] < x:
            lt = mid+1
        else:
            rt = mid-1
    return 0


t = int(input())
for _ in range(t):
    n = int(input())
    one = list(map(int, input().split()))
    one.sort()
    m = int(input())
    two = list(map(int, input().split()))
    for i in two:
        print(bs(i))
